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

import niit.com.Dao.SuppliersDAO;
import niit.com.model.Suppliers;
import niit.com.util.Util;


	@Controller
	public class SuppliersController {
        
		@Autowired
		private SuppliersDAO suppliersDAO;
      
		
		@Autowired(required = true)
		@Qualifier(value = "SuppliersDAO")
		public void setSuppliersDAO(SuppliersDAO ps) {
			this.suppliersDAO = ps;
		}

		@RequestMapping(value = "/suppliers", method = RequestMethod.GET)
		public String listSuppliers(Model model) {
			System.out.println("Hello.. I'm inside /suppliers list");
			model.addAttribute("isAdminClickedSuppliers", "true");
			model.addAttribute("suppliers", new Suppliers());
			model.addAttribute("suppliersList", this.suppliersDAO.list());
			return "Suppliers";
}

		// For add and update supplier both
		@RequestMapping(value = "/supplier/add", method = RequestMethod.POST)
		public String addSupplier(@ModelAttribute("suppliers") Suppliers suppliers) {
			System.out.println("Hello.. I'm inside /suppliers add");
			String newID = Util.removeComma(suppliers.getId());
			suppliers.setId(newID);
			suppliersDAO.saveOrUpdate(suppliers);

			return "redirect:/suppliers";

		}

		@RequestMapping("/supplier/remove/{id}")
		public String removeSupplier(@PathVariable("id") String id, ModelMap model) throws Exception {
			System.out.println("Hello.. I'm inside /suppliers remove");
			try {
				suppliersDAO.delete(id);
				model.addAttribute("message", "Successfully Added");
			} catch (Exception e) {
				model.addAttribute("message", e.getMessage());
				e.printStackTrace();
			}
			return "redirect:/suppliers";
		}

		@RequestMapping("/supplier/edit/{id}")
		public String editSupplier(@PathVariable("id") String id, Model model) {
			System.out.println("editSupplier");
			model.addAttribute("suppliers", suppliersDAO.get(id));
			model.addAttribute("isAdminClickedEditSuppliers", "true");
			model.addAttribute("listsuppliers", suppliersDAO.list());
			return "redirect:/suppliers";
		}
	}


