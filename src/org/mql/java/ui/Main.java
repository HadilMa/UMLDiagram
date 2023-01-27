package org.mql.java.ui;

import javax.swing.JFrame;

import org.mql.java.models.Project;
import org.mql.java.xml.XmlParser;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;

	public Main() {
		
		XmlParser xml = new XmlParser("resources/p5.xml");
		Project project = xml.xmlToProject();
		
		setContentPane(new ClassDiagram(project));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack(); // setSize();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}

}
