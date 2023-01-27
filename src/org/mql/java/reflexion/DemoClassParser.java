package org.mql.java.reflexion;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import java.util.List;
import java.util.Vector;

import org.mql.java.models.Constructors;
import org.mql.java.models.Fields;
import org.mql.java.models.Methods;

public class DemoClassParser {
	private Class<?> myClass;
	
	public DemoClassParser(String fullNameClasses)  {
		try {
			myClass = Class.forName(fullNameClasses);
			
		} catch (ClassNotFoundException e) {
			System.out.println("class not found");
		}
	} 
	
	public List<Fields> getFields() {
		Field[] fields = myClass.getDeclaredFields();
		String allVisibility;
		String visibility = "";
		String simpleType;
		String type;
		String name;
		List<Fields> fieldsList = new Vector<Fields>();
		int modifier;
	    for (int i = 0; i < fields.length; i++) {
	    
			modifier = fields[i].getModifiers();
			if(Modifier.isPublic(modifier)) visibility = "public";
			if(Modifier.isPrivate(modifier)) visibility = "private";
			if(Modifier.isProtected(modifier)) visibility = "protected";
			allVisibility = Modifier.toString(modifier);
			
			simpleType = fields[i].getType().getSimpleName();
			type = fields[i].getType().getName();
			name = fields[i].getName();
			fieldsList.add(new Fields(allVisibility, visibility, type, simpleType, name));
		}
	    return fieldsList;
			
	}
	
	public List<Methods> getMethods() {
		Method[] methods = myClass.getDeclaredMethods();
		String allVisibility;
		String visibility = "";
		String typeReturn;
		String name;
		Class<?>[] p;
		List<Methods> methodList = new Vector<Methods>();
		int modifier;
	    for (int i = 0; i < methods.length; i++) {
	    	p = methods[i].getParameterTypes();
	    	String[] params = new String[p.length];
	    	for (int j = 0; j < p.length; j++) {
				params[j] = p[j].getSimpleName();
			}
			modifier = methods[i].getModifiers();
			if(Modifier.isPublic(modifier)) visibility = "public";
			if(Modifier.isPrivate(modifier)) visibility = "private";
			if(Modifier.isProtected(modifier)) visibility = "protected";
			allVisibility = Modifier.toString(modifier);
			typeReturn = methods[i].getReturnType().getSimpleName();
			name = methods[i].getName();
			methodList.add(new Methods(allVisibility, visibility, typeReturn, name, params));
		}
	    return methodList;
			
	}
	
	public List<Constructors> getConstructors() {
		java.lang.reflect.Constructor<?>[] constructors = myClass.getConstructors();
		String visibility;
		String name;
		Class<?>[] p;
		List<Constructors> constructorList = new Vector<Constructors>();
		int modifier;
	    for (int i = 0; i < constructors.length; i++) {
	    	p = constructors[i].getParameterTypes();
	    	String[] params = new String[p.length];
	    	for (int j = 0; j < p.length; j++) {
				params[j] = p[j].getSimpleName();
			}
			modifier = constructors[i].getModifiers();
			visibility = Modifier.toString(modifier);
			name = constructors[i].getName();
			constructorList.add(new Constructors(visibility, name, params));
		}
	    return constructorList;
			
	}
	public String getName() {
		   return myClass.getName();
	   }
	public String getSimpleName() {
		   return myClass.getSimpleName();
	   }
	
	
	public Class<?> getSuperClass() {
		   Class<?> superClass = myClass.getSuperclass();
		   return superClass;
	   }
	   public Class<?>[] getSuperInterfaces() {
		   Class<?>[] superInterfaces = myClass.getInterfaces();
		   return superInterfaces;
	   }
	
	
	  
}
