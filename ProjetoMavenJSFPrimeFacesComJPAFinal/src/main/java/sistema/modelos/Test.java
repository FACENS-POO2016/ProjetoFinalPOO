package sistema.modelos;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Test {	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTest;
	
	private String nameTest;
	private String nameClass;
	private String nameColleague;
	
	
	private String course;	
	@Temporal(value = TemporalType.DATE)
	private Date testDate;
	
	private int levelTest;
	private int countQuestions;
	
	@ManyToMany(mappedBy = "lstTests")
	private ArrayList<Questions> lstQuestions = new ArrayList<Questions>();	
	private List<Contents> lstContents = new ArrayList<Contents>();		
	
	
	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	public String getNameClass() {
		return nameClass;
	}

	public void setNameClass(String nameClass) {
		this.nameClass = nameClass;
	}

	public String getNameColleague() {
		return nameColleague;
	}

	public void setNameColleague(String nameColleague) {
		this.nameColleague = nameColleague;
	}

	public String getNameTest() {
		return nameTest;
	}

	public void setNameTest(String nameTest) {
		this.nameTest = nameTest;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public int getLevelTest() {
		return levelTest;
	}

	public void setLevelTest(int levelTest) {
		this.levelTest = levelTest;
	}

	public int getCountQuestions() {
		return countQuestions;
	}

	public void setCountQuestions(int countQuestions) {
		this.countQuestions = countQuestions;
	}

	public ArrayList<Questions> getLstQuestions() {
		return lstQuestions;
	}

	public void setLstQuestions(ArrayList<Questions> lstQuestions) {
		this.lstQuestions = lstQuestions;
	}

	public List<Contents> getLstContents() {
		return lstContents;
	}

	public void setLstContents(List<Contents> lstContents) {
		this.lstContents = lstContents;
	}

	public void addContent(Contents content){
		lstContents.add(content);
	}
	
	public void addQuestion(Questions quest){
		lstQuestions.add(quest);
	}

	public void addEssayQuestion(Essay essay){
		lstQuestions.add(essay);
	}
	public void addChoice(Choice chc){
		lstQuestions.add(chc);
	}
	public void addTrueOrFalse(TrueOrFalse to){
		lstQuestions.add(to);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + countQuestions;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + idTest;
		result = prime * result + levelTest;
		result = prime * result + ((lstContents == null) ? 0 : lstContents.hashCode());
		result = prime * result + ((lstQuestions == null) ? 0 : lstQuestions.hashCode());
		result = prime * result + ((nameClass == null) ? 0 : nameClass.hashCode());
		result = prime * result + ((nameColleague == null) ? 0 : nameColleague.hashCode());
		result = prime * result + ((nameTest == null) ? 0 : nameTest.hashCode());
		result = prime * result + ((testDate == null) ? 0 : testDate.hashCode());
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
		Test other = (Test) obj;
		if (countQuestions != other.countQuestions)
			return false;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (idTest != other.idTest)
			return false;
		if (levelTest != other.levelTest)
			return false;
		if (lstContents == null) {
			if (other.lstContents != null)
				return false;
		} else if (!lstContents.equals(other.lstContents))
			return false;
		if (lstQuestions == null) {
			if (other.lstQuestions != null)
				return false;
		} else if (!lstQuestions.equals(other.lstQuestions))
			return false;
		if (nameTest == null) {
			if (other.nameTest != null)
				return false;		
		}else if (!nameTest.equals(other.nameTest))
			return false;		
		if (nameColleague == null) {
			if (other.nameColleague != null)
				return false;
		} else if (!nameColleague.equals(other.nameColleague))
			return false;
		if (nameClass == null) {
			if (other.nameClass != null)
				return false;
		} else if (!nameClass.equals(other.nameClass))
			return false;
		if (testDate == null) {
			if (other.testDate != null)
				return false;
		} else if (!testDate.equals(other.testDate))
			return false;
		return true;
	}

		
}
