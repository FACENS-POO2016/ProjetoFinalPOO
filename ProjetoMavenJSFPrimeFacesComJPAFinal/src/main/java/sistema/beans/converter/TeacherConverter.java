package sistema.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.modelos.Teacher;
import sistema.service.TeacherService;

@FacesConverter("converterTeacher")
public class TeacherConverter implements Converter {

	private TeacherService tService = new TeacherService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {		
		if (value != null && !value.isEmpty()) {			
			  for(Teacher f : tService.getAllTeachers())
				 if(f.getName().equals(value))
				  	return f;					
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object teacher) {
		if (teacher == null || teacher.equals("")) {
			return null;
		} else {
			return ((Teacher) teacher).getName();
		}
	}
}

