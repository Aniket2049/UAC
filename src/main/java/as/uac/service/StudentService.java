package as.uac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import as.uac.bean.PreferenceListOption;
import as.uac.dao.StudentDAO;

@Service
public class StudentService
{
	@Autowired
	StudentDAO studentDAO;
	
	@Transactional
	public List<String> GetInstitueNames()
	{
		return studentDAO.GetInstitueNames();
	}
	
	public String GetAdmission(List<PreferenceListOption> preferenceList, int rank)
	{
		return studentDAO.GetAdmission(preferenceList, rank);
	}
	
}
