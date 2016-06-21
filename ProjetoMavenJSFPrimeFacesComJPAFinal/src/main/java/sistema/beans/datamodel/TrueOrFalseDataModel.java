package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import sistema.modelos.TrueOrFalse;
import sistema.service.TrueOrFalseService;

public class TrueOrFalseDataModel extends ListDataModel<TrueOrFalse> implements SelectableDataModel<TrueOrFalse> {

	private TrueOrFalseService tofService = new TrueOrFalseService();
	
	public TrueOrFalseDataModel(){		
	}

	public TrueOrFalseDataModel(List <TrueOrFalse> lstTOFS){
	   super(lstTOFS);	
	}
	
	@Override
	public TrueOrFalse getRowData(String rowKey) {		
		for(TrueOrFalse tof: tofService.getAllTrueOrFalse())
		   if(Integer.parseInt(rowKey) ==  tof.getIdQuest())
			   return tofService.search(tof);		
		return null;
	}

	@Override
	public Object getRowKey(TrueOrFalse tof) {
		return tof.getIdQuest();
	}
}
