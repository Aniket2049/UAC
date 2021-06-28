package as.uac.service;

import as.uac.dao.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService
{
	@Autowired
	LoginDAO loginDAO;
	
	@Transactional
	public String AuthenticateUser(String username, String password)
	{
		return loginDAO.AuthenticateUser(username, password);
	}
}
