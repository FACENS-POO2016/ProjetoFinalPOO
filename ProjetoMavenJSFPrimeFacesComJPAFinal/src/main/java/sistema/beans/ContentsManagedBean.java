package sistema.beans;

import java.io.Serializable;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;
import sistema.modelos.Contents;
import sistema.modelos.Disciplines;
import sistema.modelos.Questions;
import sistema.service.ContentService;
import sistema.service.DisciplineService;
import sistema.service.QuestionService;

@ManagedBean(name = "contentManagedBean")
@ViewScoped
public class ContentsManagedBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Contents content = new Contents();
	private List<Contents> lstContents;
	private List<Questions> lstQuestions;
	private List<Questions> lstQuestionsSelected;
	private Disciplines discipline;
	private ContentService cService = new ContentService();
	private QuestionService qService = new QuestionService();
	private DisciplineService dService = new DisciplineService();
	
	
	public void save(){
		discipline.addContents(content);;
		content.setObjDiscipline(discipline);
		content = cService.save(content);
		if (lstContents != null)
			lstContents.add(content);
		content = new Contents();
		discipline = null;
	}

	public List<Disciplines> getAllDisciplines(){
		return dService.getAllDisciplines();
	}

	public Disciplines getDiscipline(){
		return discipline;
	}

	public void remove(Contents content){
		cService.remover(content);
		lstContents.remove(content);
	}

	public void setDiscipline(Disciplines discipline) 
	{
		this.discipline = discipline;
	}

	public Contents getContent() 
	{
		return content;
	}

	public void setContent(Contents content) 
	{
		this.content = content;
	}
	
	public void setLstQuestions(List<Questions> questions) 
	{
		this.lstQuestions = questions;
	}

	public List<Questions> getLstQuestionsSelected() {
		return lstQuestionsSelected;
	}

	public void setLstQuestionsSelected(List<Questions> questionsSelected) {
		this.lstQuestionsSelected = questionsSelected;
	}

	public List<Contents> getLstContents() {
		if (lstContents == null)
			lstContents = cService.getContents();
		return lstContents;
	}
	
	public List<Questions> getLstQuestions() {
		if (lstQuestions == null)	
			return qService.getAllQuestions();
		return lstQuestions;
	}

	public void onRowEdit(RowEditEvent event) {
		Contents c = ((Contents) event.getObject());
		cService.changeContent(c);
	}

}
