package sistema.beans;

import sistema.service.ContentService;
import sistema.service.ChoiceService;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Contents;
import sistema.modelos.Choice;
import sistema.modelos.Test;

@ManagedBean(name="choiceManagedBean")
public class ChoiceManagedBean {	
	private Choice choice = new Choice();
	private List<Choice> lstChoices = new ArrayList<Choice>();
	private ChoiceService cService = new ChoiceService();
	private ContentService contentService = new ContentService();
	private Contents content = new Contents();
	private Test test;
	private Choice choiceSelected;
	private List<String> lstOptions = new ArrayList<String>();
	
	public void save() {
		choice.addAllChoices();
		choice.addContents(content);
		content.addQuestions(choice);			
		cService.save(choice);
		if (lstChoices != null)
			lstChoices.add(choice);
		choice = new Choice();		
	}

	public Choice getChoiceSelected() {
		return choiceSelected;
	}

	public void setChoiceSelected(Choice choiceSelected) {
		this.choiceSelected = choiceSelected;
	}

	public List<Contents> getAllContents() {
		return contentService.getContents();
	}
	
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public Choice getChoice() {
		return choice;
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
	} 
	
	public Contents getContent() {
		return content;
	}

	public void setContent(Contents content) {
		this.content = content;
	}

	public List<Choice> getLstChoices() {
		if (lstChoices == null)
			lstChoices = cService.getAllChoices();
		return lstChoices;
	}

	public void remove(Choice choice) {
		cService.remove(choice);
		lstChoices.remove(choice);
	}
	
	public void onRowEdit(RowEditEvent event) {
		Choice c = ((Choice) event.getObject());
		cService.changeChoice(c);
	}

}
