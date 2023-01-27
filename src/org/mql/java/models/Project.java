package org.mql.java.models;

import java.util.List;

public class Project {
	private String name;
	private List<Entity> entities;
	
	public Project(String name, List<Entity> entities) {
		this.entities = entities;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}
	
	
	

}

