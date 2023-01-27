package org.mql.java.models;

public class Relation {
	private String classA;
	private String classB;
	private String type; 

	public Relation(String classA, String classB, String type) {
		super();
		this.classA = classA;
		this.classB = classB;
		this.type = type;
	}

	public String getClassA() {
		return classA;
	}

	public void setClassA(String classA) {
		this.classA = classA;
	}

	public String getClassB() {
		return classB;
	}

	public void setClassB(String classB) {
		this.classB = classB;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
