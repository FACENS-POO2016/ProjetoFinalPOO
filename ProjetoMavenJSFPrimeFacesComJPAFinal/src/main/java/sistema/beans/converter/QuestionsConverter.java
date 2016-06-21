package sistema.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.modelos.Questions;
import sistema.service.QuestionService;

@FacesConverter("converterQuestion")
public class QuestionsConverter implements Converter {

	private QuestionService qService = new QuestionService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {		
		if (value != null && !value.isEmpty()) {			
			  for(Questions q : qService.getAllQuestions())
				 if(q.getHeader().equals(value))
				  	return q;					
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object teacher) {
		if (teacher == null || teacher.equals("")) {
			return null;
		} else {
			return ((Questions) teacher).getHeader();
		}
	}
}

