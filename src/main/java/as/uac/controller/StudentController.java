package as.uac.controller;

import as.uac.bean.PreferenceListOption;
import as.uac.service.StudentService;
import as.uac.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController
{
	public static List<PreferenceListOption> preferenceList;
	public static int                        rank = 0;
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/student")
	public String ShowStudent (HttpServletRequest request, Model model)
	{
		HttpSession httpSession = request.getSession();
		String      whoIs       = (String) httpSession.getAttribute(LoginController.WHO_IS);
		
		if ((whoIs != null) && whoIs.equalsIgnoreCase("student"))
		{
			AddStudentStuff(model);
			return "student";
		}
		else
		{
			model.addAttribute("loginPageMessage", Utility.HTMLInfoFormat("Login as STUDENT to access", "error"));
			return "login";
		}
	}
	
	public void AddStudentStuff (Model model)
	{
		if (rank == 0)
		{
			rank =
				new Random().nextInt(10000 - 1) + 1;    // generate random rank of student, since no real exam was held
			System.out.println("\nSTUDENT ASSIGNED RANK --> " + rank);
		}
		
		model.addAttribute("title", "UAC Student Portal");
		model.addAttribute("rank", StudentController.rank);
		model.addAttribute("pList", preferenceList);
		model.addAttribute("courses", Utility.GetCoursesNames());
		model.addAttribute("instituteNames", studentService.GetInstitueNames());
	}
	
	@RequestMapping("/addPListItem")
	public String AddPreferenceListItem (@RequestParam("ins") String institute, @RequestParam("crs") String course,
	                                     Model model)
	{
		System.out.println("\nPARAMETERS RECEIVED FOR PREFERENCE LIST ADDITION");
		System.out.println("COURSE    --> " + course);
		System.out.println("INSTITUTE --> " + institute);
		
		if (preferenceList == null)
		{
			preferenceList = new ArrayList<PreferenceListOption>();
		}
		
		System.out.println("\nCHECKING IF OPTION ALREADY EXISTS IN THE LIST");
		for (int i = 0; i < preferenceList.size(); i++)
		{
			PreferenceListOption pListOption = preferenceList.get(i);
			
			System.out.println("INDEX --> " + i);
			System.out.println("COURSE 	  : " + pListOption.getCourse());
			System.out.println("INSTITUTE : " + pListOption.getInstitute());
			
			if (pListOption.getCourse().equalsIgnoreCase(course) &&
			    pListOption.getInstitute().equalsIgnoreCase(institute))
			{
				System.out.println("!!! OPTION ALREADY EXISTS IN THE LIST");
				System.out.println("MATCH FOUND AT INDEX --> " + i);
				
				model.addAttribute("studentPageMessage",
				                   Utility.HTMLInfoFormat("This choice already exists in the List", "info"));
				AddStudentStuff(model);
				return "student";
			}
		}
		
		preferenceList.add(new PreferenceListOption(course, institute));
		System.out.println("\nPREFERENCE LIST NOW :");
		for (int i = 0; i < preferenceList.size(); i++)
		{
			PreferenceListOption preferenceListOption = preferenceList.get(i);
			System.out.println(i + 1);
			System.out.println("COURSE 	  : " + preferenceListOption.getCourse());
			System.out.println("INSTITUTE : " + preferenceListOption.getInstitute());
		}
		
		AddStudentStuff(model);
		return "student";
	}
	
	@RequestMapping("/movePListItem")
	public String MovePreferenceListItem (@RequestParam("pIns") String institute, @RequestParam("pCrs") String course,
	                                      @RequestParam("move") String move, Model model)
	{
		System.out.println("\nPARAMETERS RECEIVED FOR MOVING PREFERENCE LIST OPTION");
		System.out.println("COURSE 	  : " + course);
		System.out.println("INSTITUTE : " + institute);
		System.out.println("MOVE	  : " + move);
		
		int requiredIndex = - 1;
		
		System.out.println("\nITERATING THROUGH PREFERENCE LIST TO MATCH OPTIONS FOR SWAPPING " + move.toUpperCase());
		for (int i = 0; i < preferenceList.size(); i++)
		{
			PreferenceListOption pListOption = preferenceList.get(i);
			
			System.out.println("INDEX --> " + i);
			System.out.println("COURSE 	  : " + pListOption.getCourse());
			System.out.println("INSTITUTE : " + pListOption.getInstitute());
			
			if (pListOption.getCourse().equalsIgnoreCase(course) &&
			    pListOption.getInstitute().equalsIgnoreCase(institute))
			{
				if (i == 0 && move.equalsIgnoreCase("UP"))
				{
					System.out.println("TOP ITEM CANNOT BE FURTHER UPPPED");
					model.addAttribute("studentPageMessage", Utility.HTMLInfoFormat("Item already at Top!", "info"));
					AddStudentStuff(model);
					return "student";
				}
				if (i == (preferenceList.size() - 1) && move.equalsIgnoreCase("DOWN"))
				{
					System.out.println("BOTTOM ITEM CANNOT BE FURTHER DOWNED");
					model.addAttribute("studentPageMessage", Utility.HTMLInfoFormat("Item already at Bottom!", "info"));
					AddStudentStuff(model);
					return "student";
				}
				
				System.out.println("REQUIRED INDEX FOUND AT --> " + i);
				requiredIndex = i;
				break;
			}
		}
		
		if (requiredIndex == - 1)
		{
			model.addAttribute("studentPageMessage", Utility.HTMLInfoFormat("Invalid Options", "error"));
			AddStudentStuff(model);
			return "student";
		}
		
		if (move.equalsIgnoreCase("UP"))
		{
			Collections.swap(preferenceList, requiredIndex, (requiredIndex - 1));
		}
		else if (move.equalsIgnoreCase("DOWN"))
		{
			Collections.swap(preferenceList, requiredIndex, (requiredIndex + 1));
		}
		
		AddStudentStuff(model);
		return "student";
	}
	
	@RequestMapping("/delPListItem")
	public String DeletePreferenceListItem (@RequestParam("pIns") String institute, @RequestParam("pCrs") String course,
	                                        Model model)
	{
		System.out.println("\nPARAMETERS RECEIVED FOR DELETING PREFERENCE LIST OPTION");
		System.out.println("COURSE 	  : " + course);
		System.out.println("INSTITUTE : " + institute);
		
		System.out.println("\nCHECKING IF OPTION EXISTS IN THE LIST");
		for (int i = 0; i < preferenceList.size(); i++)
		{
			PreferenceListOption pListOption = preferenceList.get(i);
			
			System.out.println("INDEX --> " + i);
			System.out.println("COURSE 	  : " + pListOption.getCourse());
			System.out.println("INSTITUTE : " + pListOption.getInstitute());
			
			if (pListOption.getCourse().equalsIgnoreCase(course) &&
			    pListOption.getInstitute().equalsIgnoreCase(institute))
			{
				System.out.println("OPTION EXISTS IN THE LIST");
				System.out.println("MATCH FOUND AT INDEX --> " + i);
				
				preferenceList.remove(i);
				
				model.addAttribute("studentPageMessage", Utility.HTMLInfoFormat("Choice removed.", "info"));
				AddStudentStuff(model);
				return "student";
			}
		}
		
		System.out.println("\nNON EXISTING OPTION SENT FOR DELETION. CHECK REQUEST.");
		
		model.addAttribute("studentPageMessage", Utility.HTMLInfoFormat("Invalid Options", "error"));
		AddStudentStuff(model);
		return "student";
	}
	
	@RequestMapping("/getAdmission")
	public String GetAdmission (HttpServletRequest request, Model model)
	{
		System.out.println("\nREQUEST FOR ADMISSION RECEIVED");
		System.out.println("STUDENT RANK --> " + rank);
		
		String admissionResult = studentService.GetAdmission(preferenceList, rank);
		System.out.println(admissionResult);
		if (admissionResult.contains("ADMISSION SUCCESSFUL"))
		{
			model.addAttribute("admissionResult", Utility.HTMLInfoFormat(admissionResult, "success"));
		}
		else
		{
			model.addAttribute("admissionResult", Utility.HTMLInfoFormat(admissionResult, "error"));
		}
		
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		StudentController.preferenceList = null;
		StudentController.rank           = 0;
		
		model.addAttribute("title", "ADMISSION RESULTS");
		return "admission-result";
	}
}
