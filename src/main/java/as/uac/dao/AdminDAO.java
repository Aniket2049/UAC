package as.uac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import as.uac.entity.Institute;
import as.uac.utility.Utility;

@Repository
public class AdminDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private Environment environment;
	
	public List<Institute> GetAllInstitutes()
	{
		Session				session				= sessionFactory.getCurrentSession();
		Query<Institute>	institutes_query	= session.createQuery("from Institute", Institute.class);
		List<Institute>		institutes			= institutes_query.getResultList();
		
		System.out.println("\nTOTAL INSTITUTES EXTRACTED FROM DB --> " + institutes.size());
		for (int i = 0; i < institutes.size(); i++)
		{
			Institute institute = institutes.get(i);
			System.out.println((i + 1) + " --> " + institute.getName());
		}
		
		return institutes;
		
	}
	
	public int GetInstituteID(String institute)
	{
		int instituteID = 0;
		
		String			query		= "from Institute i where i.name = '" + institute + "'";
		List<Institute>	institutes	= sessionFactory.getCurrentSession().createQuery(query).list();
		
		if (institutes.size() > 1)
		{
			System.out.println("MORE THAN SINGLE INSTITUTE WITH NAME --> " + institute + " FOUND. CHECK QUERY!");
			return instituteID;
		}
		else
		{
			instituteID = institutes.get(0).getId();
			System.out.println("\nINSTITUTE ID RECOVERED FOR :");
			System.out.println("INSTITUTE    --> " + institute);
			System.out.println("INSTITUTE ID --> " + instituteID);
		}
		
		return instituteID;
	}
	
	public int SeatOperation(String institute, String branch, String operation, String magnitude)
	{
		int status = 0;
		
		try
		{
			String	jdbcDriver	= environment.getProperty("jdbc.driver");
			String	jdbcURL		= environment.getProperty("jdbc.url");
			String	db_username	= environment.getProperty("jdbc.user");
			String	db_password	= environment.getProperty("jdbc.password");
			
			branch = Utility.MapCourseNameToDBColumnName(branch);
			
			Class.forName(jdbcDriver);
			Connection	connection	= DriverManager.getConnection(jdbcURL, db_username, db_password);
			Statement	statement	= connection.createStatement();
			String		query		= null;
			int			instituteID	= GetInstituteID(institute);
			
			if (operation.equals("Add"))
			{
				query = "UPDATE `uac_db1`.`seats` SET " + branch + " = " + branch + " + " + magnitude + " WHERE `id` = "
						+ instituteID + ";";
			}
			else if (operation.equals("Subtract"))
			{
				query = "UPDATE `uac_db1`.`seats` SET " + branch + " = " + branch + " - " + magnitude + " WHERE `id` = "
						+ instituteID + ";";
			}
			
			status = statement.executeUpdate(query);
			System.out.println("\nQUERY EXECUTED SUCCESSFULLY");
			System.out.println("QUERY --> " + query);
			connection.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
}
