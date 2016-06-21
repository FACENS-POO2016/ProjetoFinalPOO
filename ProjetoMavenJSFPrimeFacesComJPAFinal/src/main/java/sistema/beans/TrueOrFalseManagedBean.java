package sistema.beans;

import sistema.service.ContentService;
import sistema.service.TrueOrFalseService;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;


import sistema.beans.datamodel.TrueOrFalseDataModel;
import sistema.modelos.Contents;
import sistema.modelos.TrueOrFalse;

@ManagedBean(name="tofManagedBean")
public class TrueOrFalseManagedBean {

	private TrueOrFalse tof = new TrueOrFalse();
	private TrueOrFalseService tofService = new TrueOrFalseService();
	private ContentService cService = new ContentService();
	private List<TrueOrFalse> lstTofs;
	private Contents content = new Contents();
	private TrueOrFalse tofSelected;
	private List<String> lstOptions = new ArrayList<String>();	
	
	public void save() {			
		tof.addAllChoices();
		content.addQuestions(tof);
		tof.addContents(content);		
		tofService.save(tof);		
			if(lstTofs != null)
				lstTofs.add(tof);		
		
		tof = new TrueOrFalse();
		content = null;		
	}
		
	
	public TrueOrFalse getTofSelected() {
		return tofSelected;
	}

	public void setTofSelected(TrueOrFalse tofSelected) {
		this.tofSelected = tofSelected;
	}

	public List<Contents> getAllContents() {
		return cService.getContents();
	}
	
	public Contents getContent() {
		return content;
	}
	
	public void remove(TrueOrFalse tof) {
		tofService.remove(tof);
		lstTofs.remove(tof);
	}
	
	public void setContent(Contents content) {
		this.content = content;
	}

	public TrueOrFalse getTof() {
		return tof;
	}

	public void setTof(TrueOrFalse tof) {
		this.tof = tof;
	}
	
	public DataModel<TrueOrFalse> getDisciplinesDataModel() {
		if (lstTofs == null)
			lstTofs = tofService.getAllTrueOrFalse();
		return new TrueOrFalseDataModel(lstTofs);
	}

	public List<TrueOrFalse> getLstTofs(){
		if (lstTofs == null)
			lstTofs = tofService.getAllTrueOrFalse();
		return lstTofs;
	}

	public void onRowEdit(RowEditEvent event) {
		TrueOrFalse t = ((TrueOrFalse) event.getObject());
		tofService.changeTrueOrFalse(t);
	}
	
}
