package sistema.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class TrueOrFalse extends Questions {
	
	private static final long serialVersionUID = 1L;
	private int count;
	private String answer;
	private List<String> lstOptions = new ArrayList<String>();
	private String TO1;
	private String TO2;
	private String TO3;
	private String TO4;
	private String TO5;		
	
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

	public List<String> getLstOptions() {
		return lstOptions;
	}

	public void setLstOptions(List<String> lstOptions) {
		this.lstOptions = lstOptions;
	}

	public String getTO1() {
		return TO1;
	}

	public void setTO1(String tO1) {
		TO1 = tO1;
	}

	public String getTO2() {
		return TO2;
	}

	public void setTO2(String tO2) {
		TO2 = tO2;
	}

	public String getTO3() {
		return TO3;
	}

	public void setTO3(String tO3) {
		TO3 = tO3;
	}

	public String getTO4() {
		return TO4;
	}

	public void setTO4(String tO4) {
		TO4 = tO4;
	}

	public String getTO5() {
		return TO5;
	}
	
	public void setTO5(String tO5) {
		TO5 = tO5;
	}

	public void addAllChoices(){
		if(TO1 != "")
		   lstOptions.add(TO1);
		if(TO2 != "")
			lstOptions.add(TO2);
		if(TO3 != "")
			lstOptions.add(TO3);
		if(TO4 != "")
			lstOptions.add(TO4);
		if(TO5 != "")
			lstOptions.add(TO5);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((TO1 == null) ? 0 : TO1.hashCode());
		result = prime * result + ((TO2 == null) ? 0 : TO2.hashCode());
		result = prime * result + ((TO3 == null) ? 0 : TO3.hashCode());
		result = prime * result + ((TO4 == null) ? 0 : TO4.hashCode());
		result = prime * result + ((TO5 == null) ? 0 : TO5.hashCode());
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
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
		TrueOrFalse other = (TrueOrFalse) obj;
		if (TO1 == null) {
			if (other.TO1 != null)
				return false;
		} else if (!TO1.equals(other.TO1))
			return false;
		if (TO2 == null) {
			if (other.TO2 != null)
				return false;
		} else if (!TO2.equals(other.TO2))
			return false;
		if (TO3 == null) {
			if (other.TO3 != null)
				return false;
		} else if (!TO3.equals(other.TO3))
			return false;
		if (TO4 == null) {
			if (other.TO4 != null)
				return false;
		} else if (!TO4.equals(other.TO4))
			return false;
		if (TO5 == null) {
			if (other.TO5 != null)
				return false;
		} else if (!TO5.equals(other.TO5))
			return false;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (count != other.count)
			return false;
		return true;
	}
	
	
}
