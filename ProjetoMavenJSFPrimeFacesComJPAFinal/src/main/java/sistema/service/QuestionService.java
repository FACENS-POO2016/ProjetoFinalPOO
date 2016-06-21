package sistema.service;

import java.util.List;

import sistema.dao.EssayDAO;
import sistema.dao.ChoiceDAO;
import sistema.dao.QuestionsDAO;
import sistema.dao.TrueOrFalseDAO;
import sistema.modelos.Choice;
import sistema.modelos.Essay;
import sistema.modelos.Questions;
import sistema.modelos.TrueOrFalse;

public class QuestionService {

	private QuestionsDAO questDAO = new QuestionsDAO();
	private EssayDAO eDAO = new EssayDAO();
	private ChoiceDAO cDAO = new ChoiceDAO();
	private TrueOrFalseDAO tDAO = new TrueOrFalseDAO();

	public Questions saveEssay(Essay essay){
		essay = eDAO.save(essay);
		eDAO.closeEntityManager();
		return essay;
	}
	
	public Questions saveChoice(Choice chc){
		chc = cDAO.save(chc);
		cDAO.closeEntityManager();
		return chc;
	}
	
	public Questions saveTrueOrFalse(TrueOrFalse tof){
		tof = tDAO.save(tof);
		tDAO.closeEntityManager();
		return tof;
	}
	public List<Questions> getAllQuestions(){
		List<Questions> lstQuestions = questDAO.getAll(Questions.class);
		questDAO.closeEntityManager();
		return lstQuestions;
	}

	public void changeQuestion(Questions quest){
		questDAO.save(quest);
		questDAO.closeEntityManager();
	}

	public void remove(Questions quest){
		quest = questDAO.getById(Questions.class,
				quest.getIdQuest());
		questDAO.remove(quest);
		questDAO.closeEntityManager();
	}
	public Questions search(Questions quest){
		quest = questDAO.getById(Questions.class, quest.getIdQuest());
		questDAO.closeEntityManager();
		return quest;
	}
	
}