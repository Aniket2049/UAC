package as.uac.dao;

import as.uac.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public String AuthenticateUser (String username, String password)
	{
		String result = "NoSuchUser";
		
		String     query = "from User u where u.username = '" + username + "' AND u.password = '" + password + "'";
		List<User> users = sessionFactory.getCurrentSession().createQuery(query).list();
		
		for (User user : users)
		{
			result = user.getPrivilege();
		}
		
		return result;
	}
}
