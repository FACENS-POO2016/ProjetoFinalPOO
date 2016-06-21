package sistema.modelos;

import java.io.Serializable;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Questions implements Serializable {	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idQuest;	
	private String header;
	private int level;
	
	@Temporal(value = TemporalType.DATE)
	private Date creationDate;
	
	private int answerTime;	
	
	@ManyToMany
	@JoinTable(name="TableQuestionsTest", joinColumns={@JoinColumn(name="c_idQuest")}, inverseJoinColumns = {@JoinColumn(name="c_idTest")})
	private List<Test> lstTests = new ArrayList<Test>();
	private ArrayList<Byte> imageTest = new ArrayList<Byte>();	
	
	@ManyToMany
	@JoinTable(name="TableContentQuestion", joinColumns={@JoinColumn(name="c_idQuest")}, inverseJoinColumns = {@JoinColumn(name="c_idContent")})
	private List<Contents> lstContents = new ArrayList<Contents>();
	
	public int getIdQuest() {
		return idQuest;
	}

	public void setIdQuest(int idQuest) {
		this.idQuest = idQuest;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(int answerTime) {
		this.answerTime = answerTime;
	}

	public List<Test> getLstTests() {
		return lstTests;
	}

	public void setLstTests(List<Test> lstTests) {
		this.lstTests = lstTests;
	}

	public ArrayList<Byte> getImageTest() {
		return imageTest;
	}

	public void setImageTest(ArrayList<Byte> imageTest) {
		this.imageTest = imageTest;
	}

	public List<Contents> getLstContents() {
		return lstContents;
	}

	public void setLstContents(List<Contents> contents) {
		this.lstContents = contents;
	}

	public void addContents(Contents content)	{
		lstContents.add(content);		
	}		
	
	public void addTest(Test test)	{
		lstTests.add(test);		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + answerTime;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((header == null) ? 0 : header.hashCode());
		result = prime * result + idQuest;
		result = prime * result + ((imageTest == null) ? 0 : imageTest.hashCode());
		result = prime * result + level;
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
		Questions other = (Questions) obj;
		if (answerTime != other.answerTime)
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (header == null) {
			if (other.header != null)
				return false;
		} else if (!header.equals(other.header))
			return false;
		if (idQuest != other.idQuest)
			return false;
		if (imageTest == null) {
			if (other.imageTest != null)
				return false;
		} else if (!imageTest.equals(other.imageTest))
			return false;
		if (level != other.level)
			return false;
		return true;
	}	
	
	
}

