package sistema.service;

import java.util.List;

import sistema.dao.ChoiceDAO;
import sistema.modelos.Choice;

public class ChoiceService {	
	ChoiceDAO cDAO = new ChoiceDAO();
	
	public Choice save(Choice chc){		
		chc = cDAO.save(chc);
		cDAO.closeEntityManager();
		return chc;		
	}
	
	public List <Choice> getAllChoices(){
		List <Choice> lstChoices = cDAO.getAll(Choice.class);
		cDAO.closeEntityManager();
		return lstChoices;
	}
	
	public void changeChoice(Choice chc) {
		cDAO.save(chc);
		cDAO.closeEntityManager();
	}
	
	public void remove(Choice chc) {		
		chc = cDAO.getById(Choice.class, chc.getIdQuest());
		cDAO.remove(chc);
		cDAO.closeEntityManager();
	}
	
	public Choice search(Choice chc) {
		chc = cDAO.getById(Choice.class, chc.getIdQuest());
		cDAO.closeEntityManager();
		return chc;
	}
	
}
