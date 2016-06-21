package sistema.service;

import java.util.List;

import sistema.dao.TestDAO;
import sistema.modelos.Test;

public class TestService {
	TestDAO tDAO = new TestDAO();
	
	public Test save(Test test){		
		test = tDAO.save(test);
		tDAO.closeEntityManager();
		return test;		
	}
	
	public List<Test> getAllTests() {
		List<Test> lstTests = tDAO.getAll(Test.class);
		tDAO.closeEntityManager();
		return lstTests;
	}

	public void changeTest(Test test){
		tDAO.save(test);
		tDAO.closeEntityManager();
	}
	
	public void remove(Test test) {		
		test = tDAO.getById(Test.class, test.getIdTest());
		tDAO.remove(test);
		tDAO.closeEntityManager();
	}
	public Test search(Test test) {
		test = tDAO.getById(Test.class, test.getIdTest());
		tDAO.closeEntityManager();
		return test;
	}
		

}
