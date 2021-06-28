package as.uac.service;

import as.uac.dao.AdminDAO;
import as.uac.entity.Institute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService
{
	@Autowired
	AdminDAO adminDAO;
	
	@Transactional
	public List<Institute> GetAllInstitutes()
	{
		return adminDAO.GetAllInstitutes();
	}
	
	@Transactional
	public int SeatOperation(String institute, String branch, String operation, String magnitude)
	{
		return adminDAO.SeatOperation(institute, branch, operation, magnitude);
	}
}
