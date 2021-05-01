package as.uac.bean;

public class PreferenceListOption
{
	String course;
	String institute;
	
	public PreferenceListOption ()
	{
	}
	
	public PreferenceListOption (String course, String institute)
	{
		this.course    = course;
		this.institute = institute;
	}
	
	public String getCourse ()
	{
		return course;
	}
	
	public void setCourse (String course)
	{
		this.course = course;
	}
	
	public String getInstitute ()
	{
		return institute;
	}
	
	public void setInstitute (String institute)
	{
		this.institute = institute;
	}
	
}
