package as.uac.controller;

import as.uac.service.AdminService;
import as.uac.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController
{
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/admin")
	public String ShowAdmin (HttpServletRequest request, Model model)
	{
		HttpSession httpSession = request.getSession();
		String      whoIs       = (String) httpSession.getAttribute(LoginController.WHO_IS);
		
		if ((whoIs != null) && whoIs.equalsIgnoreCase("admin"))
		{
			AddAdminStuff(model);
			return "admin";
		}
		else
		{
			model.addAttribute("loginPageMessage", Utility.HTMLInfoFormat("Login as ADMIN to access!", "error"));
			return "login";
		}
	}
	
	public void AddAdminStuff (Model model)
	{
		model.addAttribute("title", "UAC Administrators Area");
		model.addAttribute("courses", Utility.GetCoursesNames());
		model.addAttribute("institutes", adminService.GetAllInstitutes());
	}
	
	@PostMapping("/seatOp")
	public String ProcessSeatOperation (HttpServletRequest request, Model model)
	{
		HttpSession httpSession = request.getSession();
		String      whoIs       = (String) httpSession.getAttribute(LoginController.WHO_IS);
		
		if (! whoIs.equalsIgnoreCase("admin"))
		{
			model.addAttribute("loginPageMessage", Utility.HTMLInfoFormat("Login as ADMIN to access!", "error"));
			return "login";
		}
		
		String institute = request.getParameter("SOP_institute");
		String branch    = request.getParameter("SOP_branch");
		String operation = request.getParameter("SOP_operation");
		String magnitude = request.getParameter("SOP_magnitude");
		
		System.out.println("\nPARAMETERS RECEIVED FOR SEAT OPERATION");
		System.out.println("Institute --> " + institute);
		System.out.println("Branch    --> " + branch);
		System.out.println("Operation --> " + operation);
		System.out.println("Magnitude --> " + magnitude);
		
		adminService.SeatOperation(institute, branch, operation, magnitude);
		
		AddAdminStuff(model);
		return "admin";
	}
}
