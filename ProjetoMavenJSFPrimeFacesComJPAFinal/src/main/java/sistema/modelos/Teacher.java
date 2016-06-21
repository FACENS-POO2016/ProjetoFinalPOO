package sistema.modelos;


import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher {	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTeacher;
	private String name;
	private String email;	
	@OneToMany(mappedBy="objTeacher")
	private ArrayList<Disciplines> lstDisciplines = new ArrayList<Disciplines>();
	
	public void addDisciplines(Disciplines disc){
		lstDisciplines.add(disc);
	}

	public int getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Disciplines> getLstDisciplines() {
		return lstDisciplines;
	}

	public void setLstDisciplines(ArrayList<Disciplines> lstDisciplines) {
		this.lstDisciplines = lstDisciplines;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idTeacher;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Teacher other = (Teacher) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idTeacher != other.idTeacher)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
