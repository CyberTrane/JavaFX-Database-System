package eggplant.People.Info;

public class Name {

	private String firstName;
	private String lastName;
	private String middleInitial;
	
	public Name() {
		
	}
	
	public String getFirstName() {
		
		String capitalLetter = (Character.toString(firstName.charAt(0))).toUpperCase();
		firstName = firstName.replace(firstName.charAt(0), capitalLetter.charAt(0));
		
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		
		String capitalLetter = (Character.toString(lastName.charAt(0))).toUpperCase();
		lastName = lastName.replace(lastName.charAt(0), capitalLetter.charAt(0));
		
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleInitial() {		
		return middleInitial.toUpperCase();
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String toString() {
		String result;
		if (!getMiddleInitial().equals("")) {
			result = getFirstName() + " " + getMiddleInitial() + ". " + getLastName();
			return result;
		} else {
			result = getFirstName() + " " + getLastName();
			return result;
		}	
	}
}
