package org.mql.java.ui;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import org.mql.java.models.Entity;

public class UMLClass extends JPanel {
	private static final long serialVersionUID = 1L;

	public UMLClass(Entity entity) {
		setBorder(new LineBorder(Color.BLACK, 1));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(new Color(253,248,128));

		JLabel title = new JLabel(entity.getName());
		title.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
		JPanel attributes = new JPanel();
		//attributes.setBorder(new MatteBorder(1, 0, 1, 0, Color.BLACK));
		
		attributes.setBackground(Color.white);
		attributes.setLayout(new BoxLayout(attributes, BoxLayout.Y_AXIS));
		
		for (int i = 0; i < entity.getFields().length; i++) {
			
			attributes.add(new JLabel(entity.getFields()[i]));
		}
		//attributes.add(new JLabel(" - attr1 : type"));
				
		JPanel methods = new JPanel();
		methods.setBackground(Color.white);
		methods.setBorder(new MatteBorder(1, 0, 0, 0, Color.BLACK));
		methods.setLayout(new BoxLayout(methods, BoxLayout.Y_AXIS));
		for (int i = 0; i < entity.getMethods().length; i++) {
			methods.add(new JLabel(entity.getMethods()[i]));
			
		}
		//methods.add(new JLabel(" + m2() : type"));
		
		add(title);
		add(attributes);
		add(methods);
	}

}
