package as.uac.controller;

import as.uac.service.LoginService;
import as.uac.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController
{
	public static String WHO_IS = "whoIsLoggedIn";
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	AdminController adminController;
	
	@Autowired
	StudentController studentController;
	
	@RequestMapping("/login-form")
	public String ShowLogin()
	{
		return "login";
	}
	
	@PostMapping("/login")
	public String Login(HttpServletRequest request, Model model)
	{
		String username   = (String) request.getParameter("username");
		String password   = (String) request.getParameter("password");
		String authResult = loginService.AuthenticateUser(username, password);
		
		System.out.println("\nPARAMETERS RECEIVED FOR LOGIN");
		System.out.println("USERNAME --> " + username);
		System.out.println("PASSWORD --> " + password);
		
		if (authResult.equalsIgnoreCase("Admin"))
		{
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute(WHO_IS, "admin");
			adminController.AddAdminStuff(model);
			
			return "admin";
		}
		else if (authResult.equalsIgnoreCase("Student"))
		{
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute(WHO_IS, "student");
			studentController.AddStudentStuff(model);
			
			return "student";
		}
		else
		{
			model.addAttribute("loginPageMessage", Utility.HTMLInfoFormat("Invalid Credentials", "error"));
			
			return "login";
		}
	}
	
	@RequestMapping("/logout")
	public String Logout(HttpServletRequest request, Model model)
	{
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		
		StudentController.preferenceList = null;
		StudentController.rank           = 0;
		WHO_IS                           = "";
		model.addAttribute("loginPageMessage", Utility.HTMLInfoFormat("Logged out successfully", "success"));
		
		return "login";
	}
}
