package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.event.RowEditEvent;
import sistema.modelos.Contents;
import sistema.modelos.Essay;
import sistema.modelos.Test;
import sistema.service.ContentService;
import sistema.service.EssayService;

@ManagedBean(name="essayManagedBean")
public class EssayManagedBean {	
	private EssayService eService = new EssayService();
	private ContentService cService = new ContentService();
	private Essay essay = new Essay();
	private List<Essay> lstEssays;
	private Contents content = new Contents();
	private Test test;
	private Essay essaySelected;	
	
	public void save() {		
		content.addQuestions(essay);
		essay.addContents(content);		
		eService.save(essay);		
		if(lstEssays != null)
			lstEssays.add(essay);		
		essay = new Essay();
		content = null;		
	}
	
	public Essay getEssaySelected() {
		return essaySelected;
	}
	
	public void setEssaySelected(Essay essaySelected) {
		this.essaySelected = essaySelected;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
	
	public List<Contents> getAllContents() {
		return cService.getContents();
	}
	public Contents getContent() {
		return content;
	}
	
	public void remove(Essay essay) {
		eService.remove(essay);
		lstEssays.remove(essay);
	}
	
	public void setContent(Contents content) {
		this.content = content;
	}

	public Essay getEssay() {
		return essay;
	}

	public void setEssay(Essay essay) {
		this.essay = essay;
	}
	
	public List<Essay> getLstEssays(){
		if (lstEssays == null)
			lstEssays = eService.getAllEssays();
		return lstEssays;
	}

	public void onRowEdit(RowEditEvent event) {
		Essay e = ((Essay) event.getObject());
		eService.changeEssay(e);
	}
	
}
