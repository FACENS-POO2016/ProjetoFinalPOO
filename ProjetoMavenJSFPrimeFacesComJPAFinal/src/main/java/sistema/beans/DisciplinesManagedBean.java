package sistema.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;

import sistema.beans.datamodel.DisciplineDataModel;
import sistema.modelos.Contents;
import sistema.modelos.Disciplines;
import sistema.modelos.Teacher;
import sistema.service.ContentService;
import sistema.service.DisciplineService;
import sistema.service.TeacherService;

@ManagedBean(name = "disciplineManagedBean")
@ViewScoped
public class DisciplinesManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Teacher teacher;
	private Disciplines discipline = new Disciplines();
	private Disciplines disciplineSelected;
	private Contents contentSelected;
	private TeacherService tService = new TeacherService();
	private DisciplineService dService = new DisciplineService();
	private ContentService cService = new ContentService();
	private List<Disciplines> lstDisciplines;	
	
	public void save(){		
		teacher.addDisciplines(discipline);
		discipline.setObjTeacher(teacher);		
		discipline = dService.save(discipline);		
		if(lstDisciplines != null)
			lstDisciplines.add(discipline);		
		discipline = new Disciplines();
		teacher = null;
	}
	
	public List<Teacher> getAllTeachers() {
		return tService.getAllTeachers();
	}
	
	public Contents getContentSelected() {
		return contentSelected;
	}
	public void setContentSelected(Contents contentSelected) {
		this.contentSelected = cService.searchContent(contentSelected);
	}
	public Teacher getTeacher() {
		return teacher;
	}
	
	public Disciplines getDisciplineSelected() {
		return disciplineSelected;
	}
	public void setDisciplineSelected(Disciplines disciplineSelected) {
		this.disciplineSelected = dService.search(disciplineSelected);
	}
	
	public void remove(Disciplines discipline) {
		if (dService.searchContentDisciplines(discipline).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível remover discipline",
					"discipline possui conteudos!"));
		} else {
			dService.remove(discipline);
			lstDisciplines.remove(discipline);
		}
	}
	
	public List<Contents> getContentsDisciplines() {
		if (disciplineSelected != null) {
			return dService.searchContentDisciplines(disciplineSelected);
		} else
			return null;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Disciplines getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Disciplines discipline) {
		this.discipline = discipline;
	}
	
	public DataModel<Disciplines> getDisciplinesDataModel() {
		if (lstDisciplines == null)
			lstDisciplines = dService.getAllDisciplines();
		return new DisciplineDataModel(lstDisciplines);
	}

	public List<Disciplines> getDisciplines(){
		if (lstDisciplines == null)
			lstDisciplines = dService.getAllDisciplines();
		return lstDisciplines;
	}

	public void onRowEdit(RowEditEvent event) {
		Disciplines p = ((Disciplines) event.getObject());
		dService.changeDiscipline(p);
	}

}

