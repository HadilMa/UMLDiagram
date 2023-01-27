package org.mql.java.models;

public class Entity {
	private String name;
	private String[] fields;
	private String[] methods;
	
	public Entity(String name, String[] fields, String[] methods) {
		super();
		this.name = name;
		this.fields = fields;
		this.methods = methods;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getFields() {
		return fields;
	}
	public void setFields(String[] fields) {
		this.fields = fields;
	}
	public String[] getMethods() {
		return methods;
	}
	public void setMethods(String[] methods) {
		this.methods = methods;
	}

	
	

}
