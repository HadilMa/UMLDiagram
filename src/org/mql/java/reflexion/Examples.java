package org.mql.java.reflexion;

import java.util.List;

import org.mql.java.models.Entity;
import org.mql.java.models.Project;
import org.mql.java.xml.XmlFormater;

public class Examples {

	public Examples() {
		exp01();
	}
	public void exp01() {
		ProjetExplorer projetExplorer = new ProjetExplorer("MAMOUNI Hadil ( Reflexion-Annotation)");
		List<Entity> entities = projetExplorer.getAllEntities();
		
		Project project = new Project("Demo project", entities);
		XmlFormater.persist("C:\\Users\\Hadil\\Desktop\\MQL\\S1\\Java\\xmlFiles\\p4.xml", project);
		
	}
	public void exp02() {
		
	}
	
	public static void main(String[] args) {
		new Examples();
	}

}
