package sistema.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sistema.modelos.Disciplines;
import sistema.service.DisciplineService;

@FacesConverter("converterDiscipline")
public class DisciplineConverter implements Converter 
{
	private DisciplineService dService = new DisciplineService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value){		
		if (value != null && !value.isEmpty()) {			
			  for(Disciplines d : dService.getAllDisciplines())
				 if(d.getName().equals(value))
				  	return d;					
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object discipline) {
		if (discipline == null || discipline.equals("")) {
			return null;
		} else {
			return ((Disciplines) discipline).getName();
		}
	}
}