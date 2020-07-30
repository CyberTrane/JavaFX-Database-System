package eggplant.People.Info;

public class Address {

	private int streetNum;
	private String streetName;
	private String streetType;
	private String city;
	private int zipCode;
	private State state;
	
	public Address() {
		
	}
	
	public int getStreetNum() {
		return streetNum;
	}

	public void setStreetNum(int streetNum) {
		this.streetNum = streetNum;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetType() {
		return streetType;
	}

	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String toString() {
		String result;
		result = streetNum + " " + streetName + " " + streetType + "\n" + city + ", " + state + " " + zipCode;
		return result;
	}
	
	public String addressString() {
		String result;
		result = streetNum + " " + streetName + " " + streetType;
		return result;
	}
	
}
