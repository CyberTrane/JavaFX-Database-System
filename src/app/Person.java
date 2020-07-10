package app;

abstract public class Person {

	Name1 name;
	Address1 address;
	private String dob;
	private char gender;
	private boolean smoker;
	
	public Person() {}
	
	public Name1 getName() {
		return name;
	}

	public void setName(Name1 name) {
		this.name = name;
	}

	public Address1 getAddress() {
		return address;
	}

	public void setAddress(Address1 address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public boolean isSmoker() {
		return smoker;
	}

	public void setSmoker(boolean smoker) {
		this.smoker = smoker;
	}

	public String toString() {
		String result;
		result = "";
		return result;
	}
	
	public class Name1 {

		private String firstName;
		private String lastName;
		private char middleInitial;
		
		public Name1() {
			
		}
		
		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public char getMiddleInitial() {
			return middleInitial;
		}

		public void setMiddleInitial(char middleInitial) {
			this.middleInitial = middleInitial;
		}

		public String toString() {
			String result;
			result = "";
			return result;
		}
	}
	
	public class Address1 {

		private int streetNum;
		private String streetName;
		private String streetType;
		private String city;
		private int zipCode;
		State1 stateCode;
		
		public Address1() {
			
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

		public State1 getStateCode() {
			return stateCode;
		}

		public void setStateCode(State1 stateCode) {
			this.stateCode = stateCode;
		}

		public String toString() {
			String result;
			result = "";
			return result;
		}
		
		public class State1 {

			private int stateCode;
			private String stateDescripton;
			
			public State1() {
				
			}
			
			public int getStateCode() {
				return stateCode;
			}

			public void setStateCode(int stateCode) {
				this.stateCode = stateCode;
			}

			public String getStateDescripton() {
				return stateDescripton;
			}

			public void setStateDescripton(String stateDescripton) {
				this.stateDescripton = stateDescripton;
			}

			public String toString() {
				String result;
				result = "";
				return result;
			}
		}
	}
}
