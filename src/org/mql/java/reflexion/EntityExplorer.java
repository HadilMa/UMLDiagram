package org.mql.java.reflexion;

import java.util.List;
import java.util.Vector;

import org.mql.java.models.Entity;
import org.mql.java.models.Fields;
import org.mql.java.models.Methods;


public class EntityExplorer {
	List<Entity> entities;
	String[] classesName;
	
	public EntityExplorer(String[] classesName) {
		this.classesName = classesName;
		entities = new Vector<>();
	}
	
	public Entity getEntity(String fullNameClass) {	
		DemoClassParser demoClassParser = new DemoClassParser(fullNameClass);
		String name = demoClassParser.getSimpleName();
		List<Fields> fields = demoClassParser.getFields();
		String[] field = new String[fields.size()];
		List<Methods> methods = demoClassParser.getMethods();
		String[] method = new String[methods.size()];
		String[] param;
		for(int i = 0; i < fields.size(); i++) {
			
			if(fields.get(i).getVisibility() == "private") {
				field[i] = "+ ";
			}
			if(fields.get(i).getVisibility() == "public") {
				field[i] = "- ";
			}
			field[i] += fields.get(i).getName() + " : " + fields.get(i).getSimpleType(); 			
		} 
		for(int i = 0; i < methods.size(); i++) {
			if(methods.get(i).getVisibility() == "private") {
				method[i] = "+ ";
			}
			if(methods.get(i).getVisibility() == "public") {
				method[i] = "- ";
			}
			method[i] += methods.get(i).getName() + "( ";
			param = methods.get(i).getParams();
			for (int j = 0; j < param.length; j++) {
				method[i] += param[j];
				if(j < param.length - 1) {
					method[i] += ", ";
				}
			}
			method[i] += ") : " + methods.get(i).getTypeReturn();
		} 
		return new Entity(name, field, method);
	}
	
	public List<Entity> getEntityList() {	
		for (int i = 0; i < classesName.length; i++) {
			Entity e = getEntity(classesName[i]);
			entities.add(e);
		}
		
		return entities;
		
	}
	
}
