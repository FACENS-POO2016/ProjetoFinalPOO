package sistema.service;

import java.util.List;

import sistema.dao.ContentDAO;
import sistema.modelos.Contents;

public class ContentService {	
	ContentDAO contentDAO = new ContentDAO();
	
	public Contents searchContent(Contents content) {
		content = contentDAO.getById(Contents.class, content.getIdContent());
		contentDAO.closeEntityManager();
		return content;
	}
	
	public Contents save(Contents content){		
		content = contentDAO.save(content);
		contentDAO.closeEntityManager();
		return content;		
	}	
	
	
	public List<Contents> getContents() {
		List<Contents> list = contentDAO.getAll(Contents.class);
		contentDAO.closeEntityManager();
		return list;
	}
	
	
	public void remover(Contents content) {		
		content = contentDAO.getById(Contents.class, content.getIdContent());
		contentDAO.remove(content);
		contentDAO.closeEntityManager();
	}
	
	public void changeContent(Contents content){
		contentDAO.save(content);
		contentDAO.closeEntityManager();
	}
}
