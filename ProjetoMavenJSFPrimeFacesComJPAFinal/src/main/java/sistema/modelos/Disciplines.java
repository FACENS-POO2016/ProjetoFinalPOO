package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Disciplines implements Serializable  {	
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idDiscipline;
	private String name;	
	@OneToMany(mappedBy="objDiscipline")
	private ArrayList<Contents> lstContents = new ArrayList<Contents>();	
	@ManyToOne
	private Teacher objTeacher;	
	
	public int getIdDiscipline() {
		return idDiscipline;
	}

	public void setIdDiscipline(int idDiscipline) {
		this.idDiscipline = idDiscipline;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Contents> getLstContents() {
		return lstContents;
	}

	public void setLstContents(ArrayList<Contents> lstContents) {
		this.lstContents = lstContents;
	}

	public Teacher getObjTeacher() {
		return objTeacher;
	}

	public void setObjTeacher(Teacher objTeacher) {
		this.objTeacher = objTeacher;
	}

	public void addTeacher(Teacher teacher){
		if(teacher != null)
		  this.objTeacher = teacher;		
	}
	
	public void addContents(Contents content){
		if(content != null)
		  lstContents.add(content);	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDiscipline;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((objTeacher == null) ? 0 : objTeacher.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplines other = (Disciplines) obj;
		if (idDiscipline != other.idDiscipline)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (objTeacher == null) {
			if (other.objTeacher != null)
				return false;
		} else if (!objTeacher.equals(other.objTeacher))
			return false;
		return true;
	}
	
	
	

}
