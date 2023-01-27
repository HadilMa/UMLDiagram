package org.mql.java.models;

public class Methods {
	private String allVisibility;
	private String visibility;
	private String typeReturn;
	private String name;
	private String[] params;
	public Methods(String allVisibility, String visibility, String typeReturn, String name, String[] params) {
		super();
		this.allVisibility = allVisibility;
		this.visibility = visibility;
		this.typeReturn = typeReturn;
		this.name = name;
		this.params = params;
	}
	public String getAllVisibility() {
		return allVisibility;
	}
	public void setAllVisibility(String allVisibility) {
		this.allVisibility = allVisibility;
	}
	public String[] getParams() {
		return params;
	}
	public void setParams(String[] params) {
		this.params = params;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public String getTypeReturn() {
		return typeReturn;
	}
	public void setTypeReturn(String typeReturn) {
		this.typeReturn = typeReturn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
