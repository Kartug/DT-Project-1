package niit.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import niit.com.Dao.CatagoryDAO;
import niit.com.model.Catagory;
import niit.com.util.Util;


@Controller
public class CatagoryController {

	@Autowired
	private CatagoryDAO catagoryDAO;
	
	@Autowired
	private Catagory catagory;

	@Autowired(required = true)
	@Qualifier(value = "CatagoryDAO")
	public void setCatagoryDAO(CatagoryDAO catagoryDAO) {
		this.catagoryDAO = catagoryDAO;
	}
	
	
	@RequestMapping(value = "/catagories", method = RequestMethod.GET)
	public ModelAndView listCategories(Model model) {
		System.out.println("Hello.. I'm inside /catagory list");
		//TO CARRY THE DATA TO NEXT PAGE
		//model.addAttribute("category", new Catagory());
		model.addAttribute("isAdminClickedCatagory", "true");
		model.addAttribute("catagoryList",catagoryDAO.list()); 
		return new ModelAndView("Catagory", "catagory", new Catagory());
	}

	// For add and update category both
	@RequestMapping(value = "/catagory/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("catagory") Catagory catagory, Model model) {

		System.out.println("Hello.. I'm inside /categories add" +catagory);
		
		String newID=Util.removeComma(catagory.getCatagory_id());
		catagory.setCatagory_id(newID);
		catagoryDAO.saveOrUpdate(catagory);
		
		model.addAttribute("isAdminClickedCatagory", "true");
		model.addAttribute("catagoryList",catagoryDAO.list());
		model.addAttribute("catagory",new Catagory());
		System.out.println(catagoryDAO.list());
		return "admin";
	}

	@RequestMapping("/catagory/remove/{id}")
	public String removeCategory(@PathVariable("id") String id, ModelMap model) throws Exception {

		System.out.println("Hello.. I'm inside /catagories remove");
		
		try {
			catagoryDAO.delete(id);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/catagories";
	}

	@RequestMapping("/catagory/edit/{id}")
	public String editCatagory(@PathVariable("id") String id, Model model) {
		System.out.println("Hello.. I'm inside /catagories edit");
		model.addAttribute("catagory",catagoryDAO.get(id));
		model.addAttribute("isAdminClickedEditCatagories", "true");
		model.addAttribute("listCatagories", catagoryDAO.list());
		return "redirect:/catagories";
	}
	
}