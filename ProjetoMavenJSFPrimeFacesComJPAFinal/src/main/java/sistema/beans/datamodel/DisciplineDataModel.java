package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import sistema.modelos.Disciplines;
import sistema.service.DisciplineService;


public class DisciplineDataModel extends ListDataModel<Disciplines> implements SelectableDataModel<Disciplines> 
{
	private DisciplineService dService = new DisciplineService();
	
	public DisciplineDataModel(){		
	}

	public DisciplineDataModel(List <Disciplines> lstDisciplines){
	   super(lstDisciplines);	
	}
	
	@Override
	public Disciplines getRowData(String rowKey) {		
		for(Disciplines di: dService.getAllDisciplines())
		   if(Integer.parseInt(rowKey) ==  di.getIdDiscipline())
			   return dService.search(di);		
		return null;
	}

	@Override
	public Object getRowKey(Disciplines disc) {
		return disc.getIdDiscipline();
	}	
}