package as.uac.service;

import as.uac.dao.RegisterDAO;
import as.uac.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterService
{
	@Autowired
	RegisterDAO registerDAO;
	
	@Transactional
	public void SaveUser (User user)
	{
		registerDAO.SaveUser(user);
	}
}
