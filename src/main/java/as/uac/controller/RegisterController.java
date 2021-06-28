package as.uac.controller;

import as.uac.entity.User;
import as.uac.service.RegisterService;
import as.uac.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController
{
	@Autowired
	RegisterService registerService;
	
	@RequestMapping("/registration")
	public String ShowRegistrationForm(Model model)
	{
		model.addAttribute("newUser", new User());
		return "register";
	}
	
	@PostMapping("/processRegistration")
	public String ProcessRegistration(HttpServletRequest request, Model model)
	{
		String name      = request.getParameter("name");
		String username  = request.getParameter("username");
		String password  = request.getParameter("password");
		String privilege = request.getParameter("privilege");
		
		System.out.println("\nPARAMETERS RECEIVED FOR USER REGISTRATION");
		System.out.println("NAME     -->" + name);
		System.out.println("USERNAME -->" + username);
		System.out.println("PASSWORD -->" + password);
		System.out.println("PRIVILEGE-->" + privilege);
		if (name.equalsIgnoreCase("") || username.equalsIgnoreCase("") || password.equalsIgnoreCase(""))
		{
			model.addAttribute("registerPageMessage",
			                   Utility.HTMLInfoFormat("Please fill in all the fields!", "error"));
			return "register";
		}
		
		try
		{
			registerService.SaveUser(new User(name, username, password, privilege));
		} catch (Exception e)
		{
			e.printStackTrace();
			model.addAttribute("registerPageMessage",
			                   Utility.HTMLInfoFormat("Error! Try with a unique Username", "error"));
			return "register";
		}
		
		model.addAttribute("loginPageMessage",
		                   Utility.HTMLInfoFormat("Registration Successful! You may try logging in now.", "success"));
		
		return "login";
	}
}
