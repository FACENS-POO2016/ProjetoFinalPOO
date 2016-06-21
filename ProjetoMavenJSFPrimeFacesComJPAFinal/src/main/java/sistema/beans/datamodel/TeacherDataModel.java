package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;
import sistema.modelos.Teacher;
import sistema.service.TeacherService;

public class TeacherDataModel extends ListDataModel<Teacher> implements SelectableDataModel<Teacher> {
	
    private TeacherService tService = new TeacherService();
	
	public TeacherDataModel(){		
	}

	public TeacherDataModel(List <Teacher> lstTeacher){
	   super(lstTeacher);	
	}
	
	@Override
	public Teacher getRowData(String rowKey) {		
		for(Teacher t: tService.getAllTeachers())
		   if(Integer.parseInt(rowKey) ==  t.getIdTeacher())
			   return tService.search(t);		   		
		return null;
	}

	@Override
	public Object getRowKey(Teacher teach) {
		return teach.getIdTeacher();
	}
}