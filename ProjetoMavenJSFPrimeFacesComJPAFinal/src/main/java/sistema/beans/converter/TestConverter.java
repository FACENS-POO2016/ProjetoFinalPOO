package sistema.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.modelos.Test;
import sistema.service.TestService;

@FacesConverter("converterTest")
public class TestConverter implements Converter {
	private TestService tService = new TestService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value){
		if (value != null && !value.isEmpty()) {			
			  for(Test d : tService.getAllTests())
				 if(d.getNameTest().equals(value))
				  	return d;					
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object test) {
		if (test == null || test.equals("")) {
			return null;
		} else {
			return ((Test) test).getNameTest();

		}
	}
}

