package eggplant.People.Info;

import java.util.HashMap;
import java.util.TreeMap;

public class State {

	private String stateCode;
	private String stateDescripton;
	
	private HashMap<String, String> stateHset;
	private TreeMap<Integer, HashMap<String, String>> stateTmap;
	
	public State() {
		
	}
	
	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
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
		result = stateCode;
		return result;
	}
	
	
	
}
