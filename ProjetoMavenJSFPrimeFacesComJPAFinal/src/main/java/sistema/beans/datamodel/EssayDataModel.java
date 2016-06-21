package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import sistema.modelos.Essay;
import sistema.service.EssayService;

public class EssayDataModel extends ListDataModel<Essay> implements SelectableDataModel<Essay> {
	

    private EssayService eService = new EssayService();
	
	public EssayDataModel(){		
	}

	public EssayDataModel(List <Essay> lstEssays){
	   super(lstEssays);	
	}

	
	@Override
	public Essay getRowData(String rowKey) {		
		for(Essay es: eService.getAllEssays())
		   if(Integer.parseInt(rowKey) ==  es.getIdQuest())
			   return eService.search(es);		
		return null;
	}

	@Override
	public Object getRowKey(Essay essay) {
		return essay.getIdQuest();
	}

}
