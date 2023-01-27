package org.mql.java.xml;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.mql.java.models.Entity;
import org.mql.java.models.Project;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParser {
	private Node root;
	private Document document;
	
	public  XmlParser(String source){
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
		 try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(source);
			root = document.getDocumentElement();
		} catch (ParserConfigurationException e) {
			System.out.println("erreur: " + e.getMessage());
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	 
	}
	
	
	public  String getAttributeValue(Node node, String name) {
		NamedNodeMap atts = node.getAttributes();
		return atts.getNamedItem(name).getNodeValue();
	}
	
	
	public  List<Entity> getEntities(){
		List<Entity> list = new Vector<Entity>();
		String name = "";
		Vector<String> fields = new Vector<String>();
		Vector<String> methods = new Vector<String>();
		String f2[];
		String m2[];
				
		NodeList entities = document.getElementsByTagName("entity");
		NodeList f, f1;
		NodeList m, m1;
		
		for (int i = 0; i < entities.getLength(); i++) {
			name = getAttributeValue(entities.item(i), "name");
			f = entities.item(i).getChildNodes();
			for (int j = 0; j < f.getLength(); j++) {
				if(f.item(j).getNodeType() == Node.ELEMENT_NODE && f.item(j).getNodeName() == "fields") {
					f1 = f.item(j).getChildNodes();
					for (int j2 = 0; j2 < f1.getLength(); j2++) {
						if(f1.item(j2).getNodeType() == Node.ELEMENT_NODE && f1.item(j2).getNodeName() == "field") {
							fields.add(getAttributeValue(f1.item(j2), "info"));
						}
					}
				}
			}
			
			m = entities.item(i).getChildNodes();
			for (int j = 0; j < m.getLength(); j++) {
				if(m.item(j).getNodeType() == Node.ELEMENT_NODE && m.item(j).getNodeName() == "methods") {
					m1 = m.item(j).getChildNodes();
					for (int j2 = 0; j2 < m1.getLength(); j2++) {
						if(m1.item(j2).getNodeType() == Node.ELEMENT_NODE && m1.item(j2).getNodeName() == "method") {
							methods.add(getAttributeValue(m1.item(j2), "info"));
						}
					}
				}
			}
			
			
			f2 = new String[fields.size()];
			fields.toArray(f2);
			
			m2= new String[methods.size()];
			methods.toArray(m2);
			
			
			list.add(new Entity(name, f2, m2));
		
		}
		
		return list;
		
	}
	
	public Project xmlToProject() {
		String name = getAttributeValue(root, "name");
		List<Entity> entities = getEntities();
		
		return new Project(name, entities);
	}

}
