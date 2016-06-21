package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Contents implements Serializable {	
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idContent;
	private String name;	
	@ManyToOne
	private Disciplines objDiscipline;	
	@ManyToMany(mappedBy="lstContents")
	private ArrayList<Questions> questions = new ArrayList<Questions>();
	
	public int getIdContent() {
		return idContent;
	}
	public void setIdContent(int idContent) {
		this.idContent = idContent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Disciplines getObjDiscipline() {
		return objDiscipline;
	}
	public void setObjDiscipline(Disciplines objDiscipline) {
		this.objDiscipline = objDiscipline;
	}
	
	public ArrayList<Questions> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<Questions> questions) {
		this.questions = questions;
	}
	
	public void addQuestions(Questions quest){
		questions.add(quest);
	
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idContent;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((objDiscipline == null) ? 0 : objDiscipline.hashCode());
		result = prime * result + ((questions == null) ? 0 : questions.hashCode());
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
		Contents other = (Contents) obj;
		if (idContent != other.idContent)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (objDiscipline == null) {
			if (other.objDiscipline != null)
				return false;
		} else if (!objDiscipline.equals(other.objDiscipline))
			return false;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		return true;
	}	
}
