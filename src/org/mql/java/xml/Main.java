package org.mql.java.xml;

import org.mql.java.models.Project;
import org.mql.java.reflexion.ProjetExplorer;

public class Main {

	public Main() {
		exp02();
	}
	
	public void exp01() {
		XmlParser xml = new XmlParser("resources/p4.xml");
		Project project = xml.xmlToProject();
		System.out.println(project.getName());
	}

	public void exp02() {
		ProjetExplorer p = new ProjetExplorer("MAMOUNI Hadil ( Reflexion-Annotation)");		
		XmlFormater.persist("C:\\Users\\Hadil\\Desktop\\MQL\\S1\\Java\\xmlFiles\\p5.xml", p.getProject());
		
		
	}

	public static void main(String[] args) {
		new Main();
		
	}
}
