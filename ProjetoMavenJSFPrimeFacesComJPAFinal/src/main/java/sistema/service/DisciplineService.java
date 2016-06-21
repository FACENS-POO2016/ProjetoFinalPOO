package sistema.service;

import java.util.List;

import sistema.dao.DisciplineDAO;
import sistema.modelos.Contents;
import sistema.modelos.Disciplines;

public class DisciplineService {

	DisciplineDAO disciplinaDAO = new DisciplineDAO();
	
	public Disciplines save(Disciplines discipline){		
		discipline = disciplinaDAO.save(discipline);
		disciplinaDAO.closeEntityManager();
		return discipline;		
	}
	
	public List<Disciplines> getAllDisciplines() {
		List<Disciplines> lstDisciplines = disciplinaDAO.getAll(Disciplines.class);
		disciplinaDAO.closeEntityManager();
		return lstDisciplines;
	}
	
	public void changeDiscipline(Disciplines discipline){
		disciplinaDAO.save(discipline);
		disciplinaDAO.closeEntityManager();
	}
	
	public List<Contents> searchContentDisciplines(Disciplines discipline) {
		List<Contents> lstContents;
		discipline = disciplinaDAO.getById(Disciplines.class, discipline.getIdDiscipline() );
		lstContents = discipline.getLstContents();
		return lstContents;
	}
	
	public void remove(Disciplines discipline) {		
		discipline = disciplinaDAO.getById(Disciplines.class, discipline.getIdDiscipline());
		disciplinaDAO.remove(discipline);
		disciplinaDAO.closeEntityManager();
	}
	
	public Disciplines search(Disciplines discipline) {
		discipline = disciplinaDAO.getById(Disciplines.class, discipline.getIdDiscipline());
		disciplinaDAO.closeEntityManager();
		return discipline;
	}
	

}
