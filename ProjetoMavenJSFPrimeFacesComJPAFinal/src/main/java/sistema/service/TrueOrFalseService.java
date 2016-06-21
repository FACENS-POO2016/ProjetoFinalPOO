package sistema.service;

import java.util.List;

import sistema.dao.TrueOrFalseDAO;
import sistema.modelos.TrueOrFalse;

public class TrueOrFalseService {
	
	TrueOrFalseDAO trueFalseDAO = new TrueOrFalseDAO();
	
	public TrueOrFalse save(TrueOrFalse tof){		
		tof = trueFalseDAO.save(tof);
		trueFalseDAO.closeEntityManager();
		return tof;		
	}
	
	public List <TrueOrFalse> getAllTrueOrFalse(){
		List <TrueOrFalse> lstTrueOrFalse = trueFalseDAO.getAll(TrueOrFalse.class);
		trueFalseDAO.closeEntityManager();
		return lstTrueOrFalse;
	}
	
	public void changeTrueOrFalse(TrueOrFalse tof) {
		trueFalseDAO.save(tof);
		trueFalseDAO.closeEntityManager();
	}
	
	public void remove(TrueOrFalse tof){		
		tof = trueFalseDAO.getById(TrueOrFalse.class, tof.getIdQuest());
		trueFalseDAO.remove(tof);
		trueFalseDAO.closeEntityManager();
	}
	public TrueOrFalse search(TrueOrFalse tof){
		tof = trueFalseDAO.getById(TrueOrFalse.class, tof.getIdQuest());
		trueFalseDAO.closeEntityManager();
		return tof;
	}
	

}
