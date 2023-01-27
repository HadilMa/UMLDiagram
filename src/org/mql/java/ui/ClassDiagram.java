package org.mql.java.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.Box;
import javax.swing.JPanel;

import org.mql.java.models.Entity;
import org.mql.java.models.Project;

public class ClassDiagram extends JPanel {
	private static final long serialVersionUID = 1L;

	public ClassDiagram(Project project) {
		setBackground(new Color(223, 249, 251));
		setPreferredSize(new Dimension(900, 500));
		List<Entity> list = project.getEntities();
		
		for (Entity entity : list) {
			addUMLClass(entity);
		}
		int i;
		
	}
	
	private void addUMLClass(Entity entity) {
		UMLClass classUML = new UMLClass(entity);
		add(classUML);
		add(Box.createHorizontalStrut(40));
	}

}
