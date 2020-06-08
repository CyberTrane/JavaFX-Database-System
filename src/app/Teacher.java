package app;

public class Teacher extends Person {

	private String subject;
	private int numOfClasses;
	private int officeNum;
	
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

	public int getOfficeNum() {
		return officeNum;
	}

	public void setOfficeNum(int officeNum) {
		this.officeNum = officeNum;
	}
	
	public String toString() {
		String result;
		result = "";
		return result;
	}
}
