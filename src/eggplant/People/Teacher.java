package eggplant.People;

public class Teacher extends Person {

	private String subject;
	private int numOfClasses;
	private String officeNum;
	
	public Teacher() {
		
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getNumOfClasses() {
		return numOfClasses;
	}

	public void setNumOfClasses(int numOfClasses) {
		this.numOfClasses = numOfClasses;
	}

	public String getOfficeNum() {
		return officeNum;
	}

	public void setOfficeNum(String officeNum) {
		this.officeNum = officeNum;
	}
	
	public String toString() {
		String result;
		result = "";
		return result;
	}
	
	public boolean equals(Teacher obj) {
		boolean result = false;
		
		if (obj.getNumOfClasses() > getNumOfClasses()) {
			result = true;
		}
		
		return result;
	}
	
}






