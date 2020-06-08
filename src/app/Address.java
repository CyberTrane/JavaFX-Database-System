package app;

public class Address {

	private int streetNum;
	private String streetName;
	private String streetType;
	private String city;
	private int zipCode;
	State stateCode;
	
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

	public State getStateCode() {
		return stateCode;
	}

	public void setStateCode(State stateCode) {
		this.stateCode = stateCode;
	}

	public String toString() {
		String result;
		result = "";
		return result;
	}
}
