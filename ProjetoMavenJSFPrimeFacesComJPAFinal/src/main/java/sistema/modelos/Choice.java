package sistema.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Choice extends Questions {

	private static final long serialVersionUID = 1L;
	private int count;
	private String answer;
	private List<String> lstChoices = new ArrayList<String>();
	private String choiceFirst;
	private String choiceTwo;
	private String choiceThree;
	private String choiceFour;
	private String choiceFive;	
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<String> getLstChoices() {
		return lstChoices;
	}

	public void setLstChoices(List<String> lstChoices) {
		this.lstChoices = lstChoices;
	}

	public String getChoiceFirst() {
		return choiceFirst;
	}

	public void setChoiceFirst(String choiceFirst) {
		this.choiceFirst = choiceFirst;
	}

	public String getChoiceTwo() {
		return choiceTwo;
	}

	public void setChoiceTwo(String choiceTwo) {
		this.choiceTwo = choiceTwo;
	}

	public String getChoiceThree() {
		return choiceThree;
	}

	public void setChoiceThree(String choiceThree) {
		this.choiceThree = choiceThree;
	}

	public String getChoiceFour() {
		return choiceFour;
	}

	public void setChoiceFour(String choiceFour) {
		this.choiceFour = choiceFour;
	}

	public String getChoiceFive() {
		return choiceFive;
	}

	public void setChoiceFive(String choiceFive) {
		this.choiceFive = choiceFive;
	}

	public void addAllChoices(){
		if(choiceFirst != "")
		  lstChoices.add(choiceFirst);
		if(choiceTwo != "")
		  lstChoices.add(choiceTwo);
		if(choiceThree != "")
		  lstChoices.add(choiceThree);
		if(choiceFour != "")
		  lstChoices.add(choiceFour);
		if(choiceFive != "")
		  lstChoices.add(choiceFive);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((choiceFirst == null) ? 0 : choiceFirst.hashCode());
		result = prime * result + ((choiceFive == null) ? 0 : choiceFive.hashCode());
		result = prime * result + ((choiceFour == null) ? 0 : choiceFour.hashCode());
		result = prime * result + ((choiceThree == null) ? 0 : choiceThree.hashCode());
		result = prime * result + ((choiceTwo == null) ? 0 : choiceTwo.hashCode());
		result = prime * result + count;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Choice other = (Choice) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (choiceFirst == null) {
			if (other.choiceFirst != null)
				return false;
		} else if (!choiceFirst.equals(other.choiceFirst))
			return false;
		if (choiceFive == null) {
			if (other.choiceFive != null)
				return false;
		} else if (!choiceFive.equals(other.choiceFive))
			return false;
		if (choiceFour == null) {
			if (other.choiceFour != null)
				return false;
		} else if (!choiceFour.equals(other.choiceFour))
			return false;
		if (choiceThree == null) {
			if (other.choiceThree != null)
				return false;
		} else if (!choiceThree.equals(other.choiceThree))
			return false;
		if (choiceTwo == null) {
			if (other.choiceTwo != null)
				return false;
		} else if (!choiceTwo.equals(other.choiceTwo))
			return false;
		if (count != other.count)
			return false;
		return true;
	}
	
	
	
	
	
}
