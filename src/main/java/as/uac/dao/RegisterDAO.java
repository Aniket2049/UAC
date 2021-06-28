package as.uac.dao;

import as.uac.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void SaveUser(User user)
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}
}
