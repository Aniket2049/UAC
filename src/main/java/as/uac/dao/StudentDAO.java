package as.uac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import as.uac.bean.PreferenceListOption;
import as.uac.entity.Institute;
import as.uac.utility.Utility;

@Repository
public class StudentDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private Environment environment;
	
	@Transactional
	public List<String> GetInstitueNames()
	{
		Session				session				= sessionFactory.getCurrentSession();
		Query<Institute>	institutes_query	= session.createQuery("from Institute", Institute.class);
		List<Institute>		institutes			= null;
		List<String>		instituteNames		= null;
		
		try
		{
			institutes		= institutes_query.getResultList();
			instituteNames	= new ArrayList<String>();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("\nTOTAL INSTITUTES EXTRACTED FROM DB --> " + institutes.size());
		for (int i = 0; i < institutes.size(); i++)
		{
			Institute institute = institutes.get(i);
			System.out.println((i + 1) + " --> " + institute.getName());
			instituteNames.add(institute.getName());
		}
		
		return instituteNames;
	}
	
	public String GetAdmission(List<PreferenceListOption> preferenceList, int rank)
	{
		String admissionResult = "You failed to secure a seat";
		
		try
		{
			String	jdbcDriver	= environment.getProperty("jdbc.driver");
			String	jdbcURL		= environment.getProperty("jdbc.url");
			String	db_username	= environment.getProperty("jdbc.user");
			String	db_password	= environment.getProperty("jdbc.password");
			
			Class.forName(jdbcDriver);
			Connection	connection	= DriverManager.getConnection(jdbcURL, db_username, db_password);
			Statement	statement	= connection.createStatement();
			String		query		= "";
			int			dbCutOff	= 0;
			
			System.out.println("\nCHECKING PREFERNCE LIST OPTIONS FOR DB MATCH");
			for (int i = 0; i < preferenceList.size(); i++)
			{
				PreferenceListOption	pListOption		= preferenceList.get(i);
				String					dbCourseColName	= Utility.MapCourseNameToDBColumnName(pListOption.getCourse());
				
				System.out.println((i + 1) + "\nCOURSE --> 		" + pListOption.getCourse());
				System.out.println("INSTITUTION --> " + pListOption.getInstitute());
				
				query = "SELECT " + dbCourseColName + " FROM `uac_db1`.`cutoff` WHERE `name` = '"
						+ pListOption.getInstitute() + "';";
				ResultSet resultSet = statement.executeQuery(query);
				System.out.println("\nQUERY EXECUTED SUCCESSFULLY");
				System.out.println("QUERY --> " + query);
				
				if (resultSet.next())
				{
					dbCutOff = resultSet.getInt(1);
					System.out.println("\nDATABASE CUTOFF FOR ABOVE PREFERNCE LIST OPTION --> " + dbCutOff);
					System.out.println("RANK IS --> " + rank);
				}
				if (dbCutOff >= rank)
				{
					System.out.println("ADMISSION SUCCESSFUL FOR " + pListOption.getCourse() + " AT "
							+ pListOption.getInstitute());
					
					query = "UPDATE `uac_db1`.`seats` SET " + dbCourseColName + " = " + dbCourseColName
							+ " - 1 WHERE `name` = '" + pListOption.getInstitute() + "';";
					int dbSeatUpdateStatus = statement.executeUpdate(query);
					if (dbSeatUpdateStatus > 0)
					{
						System.out.println("\nQUERY EXECUTED SUCCESSFULLY");
						System.out.println("QUERY --> " + query);
					}
					else
					{
						System.out.println("!!! COULD NOT UPDATE SEAT AFTER SUCCESSFUL ADMISSION IN "
								+ pListOption.getInstitute() + " WITH COURSE " + pListOption.getCourse());
					}
					
					admissionResult = "ADMISSION SUCCESSFUL with " + pListOption.getCourse() + " AT "
							+ pListOption.getInstitute();
					break;
				}
				
			}
			
			connection.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return admissionResult;
	}
	
}
