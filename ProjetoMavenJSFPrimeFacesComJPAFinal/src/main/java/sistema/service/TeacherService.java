package sistema.service;

import java.util.List;

import sistema.dao.TeacherDAO;
import sistema.modelos.Disciplines;
import sistema.modelos.Teacher;

public class TeacherService {
			
	    TeacherDAO teachDAO = new TeacherDAO();
		
		public Teacher salvar(Teacher teach){			
			teach = teachDAO.save(teach);
			teachDAO.closeEntityManager();
			return teach;
			
		}
		public List <Teacher> getAllTeachers(){
			List <Teacher> lstTeachers = teachDAO.getAll(Teacher.class);
			teachDAO.closeEntityManager();
			return lstTeachers;
		}
		
		public void changeTeacher(Teacher teach){
			teachDAO.save(teach);
			teachDAO.closeEntityManager();
		}
		
		public void remove(Teacher teach){			
			teach = teachDAO.getById(Teacher.class, teach.getIdTeacher());
			teachDAO.remove(teach);
			teachDAO.closeEntityManager();
		}
		public Teacher search(Teacher teach){
			teach = teachDAO.getById(Teacher.class, teach.getIdTeacher());
			teachDAO.closeEntityManager();
			return teach;
		}
		
		public List<Disciplines> searchDisciplineTeacher(Teacher teach){
			List<Disciplines> lstDisc;
			teach = teachDAO.getById(Teacher.class, teach.getIdTeacher());
			lstDisc = teach.getLstDisciplines();
			return lstDisc;
		}
			
			
		

	


}
