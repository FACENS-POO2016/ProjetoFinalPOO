package sistema.service;

import java.util.List;

import sistema.dao.EssayDAO;
import sistema.modelos.Essay;

public class EssayService {
	
	EssayDAO eDAO = new EssayDAO();
	
	public Essay save(Essay essay){		
		essay = eDAO.save(essay);
		eDAO.closeEntityManager();
		return essay;
		
	}
	public List <Essay> getAllEssays()	{
		List <Essay> lstEssays = eDAO.getAll(Essay.class);
		eDAO.closeEntityManager();
		return lstEssays;
	}
	
	public void changeEssay(Essay essay) {
		eDAO.save(essay);
		eDAO.closeEntityManager();
	}
	
	public void remove(Essay essay) {		
		essay = eDAO.getById(Essay.class, essay.getIdQuest());
		eDAO.remove(essay);
		eDAO.closeEntityManager();
	}
	public Essay search(Essay essay) {
		essay = eDAO.getById(Essay.class, essay.getIdQuest());
		eDAO.closeEntityManager();
		return essay;
	}
	
}
