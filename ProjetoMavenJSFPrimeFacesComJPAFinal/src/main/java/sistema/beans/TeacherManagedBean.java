package sistema.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import org.primefaces.event.RowEditEvent;
import sistema.service.TeacherService;
import sistema.beans.datamodel.TeacherDataModel;
import sistema.modelos.Disciplines;
import sistema.modelos.Teacher;

@ManagedBean(name="teacherManagedBean")
@ViewScoped
public class TeacherManagedBean {
	
	private TeacherService tService = new TeacherService();
	private List<Teacher> lstTeachers;
	private Teacher teacher = new Teacher();
	private Teacher teacherSelected;
	
	
	public Teacher getTeacherSelected() {
		return teacherSelected;
	}

	public void setTeacherSelected(Teacher teacherSelected) {
		this.teacherSelected = tService.search(teacherSelected);
	}

	public void save() {
		teacher = tService.salvar(teacher);
		if (lstTeachers != null)
			lstTeachers.add(teacher);
		teacher = new Teacher();
	}

	public DataModel<Teacher> getLstTeachers() {
		if (lstTeachers == null)
			lstTeachers = tService.getAllTeachers();
		return new TeacherDataModel(lstTeachers);
	}
	
	public void remove(Teacher teacher) {
		if (tService.searchDisciplineTeacher(teacher).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível remover teacher",
					"Teacher possui disciplinas!"));
		} else {
			tService.remove(teacher);
			lstTeachers.remove(teacher);
		}
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}

	public List<Disciplines> getDisciplinesTeacher() {
		if (teacherSelected != null) {
			return tService.searchDisciplineTeacher(teacherSelected);
		} else
			return null;
	}

	public void onRowEdit(RowEditEvent event) {
		Teacher f = ((Teacher) event.getObject());
		tService.changeTeacher(f);
	}

}
