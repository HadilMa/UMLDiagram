package org.mql.java.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.mql.java.models.Entity;
import org.mql.java.models.Project;

public class XmlFormater {

	public XmlFormater() {
		
	}
	public static String entityToXml(Entity entity) {
		String xml = "<entity name=" ;
		
		xml += "\"" + entity.getName() + "\">";
		xml += "<fields>";
		for (int i = 0; i < entity.getFields().length; i++) {
			xml += "<field info=\"" + entity.getFields()[i] + "\"/>";			
		}
		xml += "</fields>";
		xml += "<methods>";
		for (int i = 0; i < entity.getMethods().length; i++) {
			xml += "<method info=\"" + entity.getMethods()[i] + "\"/>";
		}
		xml += "</methods>";
		xml += "</entity>";
		
		return xml;
		
	}
	public static String projectToXml(Project project) {
		String xml = "<project name=" ;
		
		xml += "\"" + project.getName() + "\">";
		xml += "<entities>";
		
		for (Entity entity : project.getEntities()) {
			xml += entityToXml(entity);
		}
		xml += "</entities>";
		xml += "</project>";
		
		return xml;		
	}
	
	public static void persist(String filePath, Project project) {
		try {
			File file = new File(filePath);
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			writer.write(projectToXml(project));
			writer.close();
		} catch (IOException e) {
			System.out.println("erreur: " + e.getMessage());
		}
	}
}
