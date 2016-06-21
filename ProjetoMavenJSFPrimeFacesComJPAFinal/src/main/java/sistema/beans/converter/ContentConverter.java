package sistema.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.modelos.Contents;
import sistema.service.ContentService;

@FacesConverter("converterContent")
public class ContentConverter implements Converter {

	private ContentService cService = new ContentService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {		
		if (value != null && !value.isEmpty()) {
			for(Contents c : cService.getContents())
				 if(c.getName().equals(value))
				  	return c;					
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object content) {
		if (content == null || content.equals("")) {
			return null;
		} else {
			return ((Contents) content).getName();

		}
	}

}

