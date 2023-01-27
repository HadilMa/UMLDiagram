package org.mql.java.reflexion;

import java.io.File;
import java.util.Vector;

public class PackageExplorer {
	public PackageExplorer(String packageName) {
	}
	public String[] getClassList(String packageName) {
		String classpath = System.getProperty("java.class.path"); //recupérer la valeur d'une propriété systeme en connaissant son nom
		String packagepath = packageName.replace(".", "/");
		//System.out.println(classpath);
		File dir = new File(classpath + "/" + packagepath) ;
		File f[] = dir.listFiles();
		Vector<String> packageContent = new Vector<String>();
		for (int i = 0; i < f.length; i++) {
			String fileName = f[i].getName();
			if(f[i].isFile() && fileName.endsWith(".class")) {
				String name = fileName.replace(".class", "");
				packageContent.add(packageName + "." + name);
			}
		}
		
		String t[] = new String[packageContent.size()];
		packageContent.toArray(t);
		
		return t;
	}
	
}
