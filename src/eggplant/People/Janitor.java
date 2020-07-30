package eggplant.People;

public class Janitor extends Person {
	
	private int yearsOfService;
	private double hourlyWage;
	
	public Janitor() {
		
	}
	
	public int getYearsOfService() {
		return yearsOfService;
	}

	public void setYearsOfService(int yearsOfService) {
		this.yearsOfService = yearsOfService;
	}

	public String getHourlyWage() {
		
		String payText = "$" + hourlyWage + "/hr";
		
		return payText;
	}

	public double getPayNumeric() {
		return hourlyWage;
	}
	
	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public String toString() {
		String result;
		result = "$" + hourlyWage + "/hr";
		return result;
	}
	
	public boolean equals(Janitor obj, String property) {
		boolean result = false;
		
		if (property.equals("years")) {
			if (obj.getYearsOfService() > getYearsOfService()) {
				result = true;
			}
		} else if (property.equals("pay")) {
			if (obj.getPayNumeric() > getPayNumeric()) {
				result = true;
			}
		}
	
		return result;
	}
	
}
