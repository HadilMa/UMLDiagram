package org.mql.java.models;

public class Fields {
	private String allvisibility;
	private String visibility;
	private String simpleType;
	private String type;
	private String name;
	
	
	public Fields(String allvisibility, String visibility,String type, String simpleType, String name) {
		super();
		this.allvisibility = allvisibility;
		this.visibility = visibility;
		this.simpleType = simpleType;
		this.name = name;
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAllvisibility() {
		return allvisibility;
	}
	public void setAllvisibility(String allvisibility) {
		this.allvisibility = allvisibility;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public String getSimpleType() {
		return simpleType;
	}
	public void setSimpleType(String simplString) {
		this.simpleType = simplString;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
