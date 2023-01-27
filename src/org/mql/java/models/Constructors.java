package org.mql.java.models;

public class Constructors {
	private String visibility;
	private String name;
	private String[] params;
	
	public Constructors(String visibility, String name, String[] params) {
		super();
		this.visibility = visibility;
		this.name = name;
		this.params = params;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}
	
	
	
}
