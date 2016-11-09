package niit.com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PageController {
	@RequestMapping("/")
	public String getIndex()
	{
		return "index";
	}
	@RequestMapping("/account")
	public String getaccount()
	{
		return "account";
	}
	@RequestMapping("/login")
	public String getlogin()
	{
		return "login";
	}
}
