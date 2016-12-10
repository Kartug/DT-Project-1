package niit.com;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import niit.com.Dao.CatagoryDAO;
import niit.com.Dao.ProductsDAO;
import niit.com.Dao.UsersDetailDao;
import niit.com.model.Products;
import niit.com.model.UsersDetail;

@Controller
public class RegistrationController {

	@Autowired
	UsersDetailDao usersDetailDao;
	
	@RequestMapping("/register")
	public String registermodel(Model model) {
		UsersDetail user = new UsersDetail();
		model.addAttribute("usersdetail", user);
		return "account";
	}
		



	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView RegistrationForm(@Valid @ModelAttribute("usersdetail") UsersDetail usersDetail,BindingResult result) {
		System.out.println("coming through the controller");
		System.out.println(usersDetail.getUserId());
		if(result.hasErrors())
		{
			ModelAndView model=new ModelAndView("account");
			return model;
		}
		usersDetail.setEnabled(true);
        usersDetailDao.addUser(usersDetail);
		ModelAndView modelAndView = new ModelAndView("registrationSucess");
		return modelAndView;
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		//System.out.println("Inside login mapping");
		//System.out.println(logout+"    "+error);
		
		if (error != null) {
			model.addAttribute("error", "Invalid username and password");
			return "login";// return to login page
		}
		
		else if(logout!=null)
			return "redirect:/";//After successfull logout
	
		return "login";// return to login page
		}

}
