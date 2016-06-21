package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import sistema.modelos.Contents;
import sistema.service.ContentService;


public class ContentDataModel extends ListDataModel<Contents> implements SelectableDataModel<Contents> 
{
	private ContentService cService = new ContentService();
	
	public ContentDataModel(){		
	}

	public ContentDataModel(List <Contents> lstContents){
	   super(lstContents);	
	}
	
	@Override
	public Contents getRowData(String rowKey) {		
		for(Contents co: cService.getContents())
		   if(Integer.parseInt(rowKey) ==  co.getIdContent())
			   return co;		
		return null;
	}

	@Override
	public Object getRowKey(Contents content) {
		return content.getIdContent();
	}	
}