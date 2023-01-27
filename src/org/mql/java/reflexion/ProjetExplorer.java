package org.mql.java.reflexion;

import java.io.File;
import java.util.List;
import java.util.Vector;

import org.mql.java.models.Entity;
import org.mql.java.models.Project;


public class ProjetExplorer {
	private String projectName;

	public ProjetExplorer(String projectName) {
		this.projectName = projectName;
	}
	
	public String getClassPath() {
		String classPath = System.getProperty("java.class.path");
		String t[] = classPath.split("\\\\");
		String newClassPath = new String("");
		for (int i = 0; i < t.length - 2; i++) {
			newClassPath = newClassPath + t[i];
			if (i < t.length- 3) newClassPath += "\\"; 
		}
		newClassPath += "\\" + projectName + "\\bin";
		return newClassPath;
	}
	
	public String[] getPackageList() {
		String classPath = getClassPath();
		String packageName = new String("");
		File dir = new File(classPath);
		File f[] = dir.listFiles();
		if(f!=null) {
			packageName +=  f[0].getName();//pour annuler le premier \ 
			f = f[0].listFiles();
			while(f.length == 1 && f[0].isDirectory()) {
				packageName += "." + f[0].getName();
				f = f[0].listFiles();
			}
			
			Vector<String> packageList= new Vector<String>();
			for(int i = 0; i < f.length; i++) {
				//System.out.println(packageName + "\\" + f[i].getName());
				packageList.add(packageName + "." + f[i].getName());
			}
			String t[] = new String[packageList.size()];
			packageList.toArray(t);
			return t;
		}
		return null;
	}
	
	public String[] getClassesName(){
		List<String> allClassesName = new Vector<String>();
		PackageExplorer p = new PackageExplorer("");
		String[] packageList = getPackageList();
		for(int i = 0; i < packageList.length; i++) {
			for(int j = 0; j < p.getClassList(packageList[i]).length; j++) {
				allClassesName.add(p.getClassList(packageList[i])[j]);
			}
		}
		String t[] = new String[allClassesName.size()];
		allClassesName.toArray(t);
		return t;
	}
	public List<Entity> getAllEntities(){
		
		String[] list = getClassesName();
		EntityExplorer e = new EntityExplorer(list);
		return e.getEntityList();
	}
	
	public Project getProject() {
		
		return new Project(projectName, getAllEntities());
		
	}
		
}
