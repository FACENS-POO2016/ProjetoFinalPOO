package sistema.beans.datamodel;



import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import sistema.modelos.Choice;
import sistema.service.ChoiceService;

public class ChoiceDataModel extends ListDataModel<Choice> implements SelectableDataModel<Choice> {
    private ChoiceService cService = new ChoiceService();
	
	public ChoiceDataModel(){		
	}

	public ChoiceDataModel(List <Choice> lstChoices){
	   super(lstChoices);	
	}
	
	@Override
	public Choice getRowData(String rowKey) {		
		for(Choice ch: cService.getAllChoices())
		   if(Integer.parseInt(rowKey) ==  ch.getIdQuest())
			   return cService.search(ch);		
		return null;
	}

	@Override
	public Object getRowKey(Choice ch) {
		return ch.getIdQuest();
	}
}
