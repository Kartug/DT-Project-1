package niit.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import niit.com.Dao.CatagoryDAO;
import niit.com.Dao.ProductsDAO;
import niit.com.Dao.UsersDetailDao;
import niit.com.model.Products;


@Controller
public class PageController {
	
	@Autowired
	UsersDetailDao usersDetailDAO;
	
	@Autowired
	private CatagoryDAO catagoryDAO;
	
	@Autowired
	private ProductsDAO productsDAO;


	@RequestMapping("/account")
	public String getaccount()
	{
		return "account";
	}
   @RequestMapping("/loginpage")
	public String getloginpage()
	{
		return "login";
	}
   @RequestMapping("/403")
	public String getaccessPage()
	{
		return "accessdeniedpage";
	}
	
   @RequestMapping("/thankYouPage")
  	public String getthankYouPage()
  	{
  		return "thankYou";
  	}
	@RequestMapping("/")
	public ModelAndView getPage( @ModelAttribute("selectedProduct") final Products selectedProduct) {
		
		ModelAndView model=new ModelAndView("/index");
		
		model.addObject("catagoryList", catagoryDAO.list());
		model.addObject("productList", productsDAO.list());
		
		
		System.out.println("inside / mapping");

		if(selectedProduct!=null){
			model.addObject("selectedProduct",selectedProduct);
		}
		else
			System.out.println("The object is null");
		
		return model;
		
}
}


