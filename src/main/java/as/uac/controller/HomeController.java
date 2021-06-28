package as.uac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController
{
	
	@RequestMapping("/")
	public String ShowHome(HttpServletRequest request, Model model)
	{
		HttpSession httpSession = null;
		
		if (request.getSession(false) == null)
		{
			httpSession = request.getSession(true);
			httpSession.setAttribute(LoginController.WHO_IS, "nobody");
		}
		
		return "index";
	}
	
}
