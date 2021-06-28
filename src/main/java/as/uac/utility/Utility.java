package as.uac.utility;

import java.util.ArrayList;
import java.util.List;

public class Utility
{
	public static List<String> GetCoursesNames()
	{
		List<String> courses = new ArrayList<String>();
		courses.add("Computer Science & Engineering");
		courses.add("Information Technology");
		courses.add("Electronics & Communication Engineering");
		courses.add("Mechanical Engineering");
		courses.add("Civil Engineering");
		
		System.out.println("\nCOURSES ADDED TO HTTP MODEL");
		for (int i = 0; i < courses.size(); i++)
		{
			String course = courses.get(i);
			System.out.println((i + 1) + "-->" + course);
		}
		
		return courses;
	}
	
	public static String MapCourseNameToDBColumnName(String displayName)
	{
		String dbColName = null;
		System.out.println("\nMAPPING -->" + displayName);
		switch (displayName)            // map display names to database column names, for query use
		{
			case "Computer Science & Engineering":
				dbColName = "cse";
				break;
			case "Information Technology":
				dbColName = "it";
				break;
			case "Electronics & Communication Engineering":
				dbColName = "ece";
				break;
			case "Mechanical Engineering":
				dbColName = "me";
				break;
			case "Civil Engineering":
				dbColName = "ce";
				break;
		}
		System.out.print(" TO -->" + dbColName);
		
		return dbColName;
	}
	
	public static String HTMLInfoFormat(String message, String type)
	{
		switch (type)
		{
			case "info":
				type = "infoMsg";
				break;
			case "error":
				type = "errorMsg";
				break;
			case "success":
				type = "successMsg";
				break;
			default:
				break;
		}
		System.out.println("\nHTML INFO FORMAT");
		System.out.println("TYPE --> " + type);
		
		String htmlFormat = "<div class=\"" + type + "\">" + message + "</div>";
		return htmlFormat;
	}
}
