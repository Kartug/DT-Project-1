package niit.com;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import niit.com.Dao.ShippingDAO;
import niit.com.model.Shipping;


@Controller
public class ShippingController {	
	@Autowired
	ShippingDAO shippingDAO;
	
	@RequestMapping("/shippingPage")
	public String shippingmodel(Model model) {
		Shipping user = new Shipping();
		model.addAttribute("shippingdetail", user);
		return "Shipping";
	}
		



	/*@RequestMapping(value = "/register", method = RequestMethod.POST)
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
*/
}
