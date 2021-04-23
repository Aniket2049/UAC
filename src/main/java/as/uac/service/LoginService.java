package as.uac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import as.uac.dao.LoginDAO;

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
