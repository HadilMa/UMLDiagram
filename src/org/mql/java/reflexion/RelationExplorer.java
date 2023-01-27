package org.mql.java.reflexion;

import java.util.List;
import java.util.Vector;
import org.mql.java.models.Fields;
import org.mql.java.models.Relation;

public class RelationExplorer {
	private ProjetExplorer project;

	public RelationExplorer(String projectName) {
		super();
		project = new ProjetExplorer(projectName);
	}
	public List<Relation> getAggregationRelations(){
		List<Relation> relations = new Vector<Relation>();
		
		String[] classesName = project.getClassesName();
		
		for (int i = 0; i < classesName.length; i++) {
			DemoClassParser demoClassParser = new DemoClassParser(classesName[i]);
			List<Fields> fields = demoClassParser.getFields();
			for (int j = 0; j < fields.size(); j++) {
				
				for (int j2 = 0; j2 < classesName.length; j2++) {
					if (fields.get(j).getType() == classesName[j2]) {
						relations.add(new Relation(fields.get(j).getType(), classesName[i] , "aggregation"));
					}
					
				}
			}		
			
		} 
		
		return relations;		
	}
	
	public List<Relation> getImplementsRelations(){
		List<Relation> relations = new Vector<Relation>();
		
		String[] classesName = project.getClassesName();
		
		
		for (int i = 0; i < classesName.length; i++) {
			DemoClassParser demoClassParser = new DemoClassParser(classesName[i]);
			Class<?>[] superInterfaces = demoClassParser.getSuperInterfaces();
			for (int j = 0; j < superInterfaces.length; j++) {
				relations.add(new Relation(superInterfaces[j].getSimpleName(), classesName[i] , "implement"));
			}
						
		}
		return relations;		
	}
	
	
	public List<Relation> getExtendsRelations(){
		List<Relation> relations = new Vector<Relation>();		
		String[] classesName = project.getClassesName();
		
		for (int i = 0; i < classesName.length; i++) {
			DemoClassParser demoClassParser = new DemoClassParser(classesName[i]);
			Class<?> superClass = demoClassParser.getSuperClass();
			relations.add(new Relation(superClass.getSimpleName(), classesName[i] , "extends"));
			
		}
		
		return relations;		
	}
	public static void main(String[] args) {
		RelationExplorer r = new RelationExplorer("MAMOUNI Hadil ( Reflecxion-Annotation)");
		List<Relation> relations = r.getAggregationRelations();
		for (Relation relation : relations) {
			System.out.println(relation.getClassA());
			
		}
	}
	
}
