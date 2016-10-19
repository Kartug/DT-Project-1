package niit.com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/")
	public String getPage()
	{
		return "index";
	}
	@RequestMapping("/about")
	public String getAbout()
	{
		return "About";
	}
	@RequestMapping("/login")
	public String getlogin()
	{
		return "login";
	}
	@RequestMapping("/contact")
	public String getContact()
	{
		return "Contact";
	}
}