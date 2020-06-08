package app;

public class Student extends Person {

	private String major;
	private double gpa;
	private int credits;
	
	public Student() {
		
	}
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String toString() {
		String result;
		result = "";
		return result;
	}
}
