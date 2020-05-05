package edu.ucam.tools;

public class ProjectPath {
	public static String getPathWindowsVersion() {
		java.net.URL url = ProjectPath.class.getProtectionDomain().getCodeSource().getLocation();
  		String path = url.toString() + "";
  		String [] splitedPath = path.split("/"); 
		
		String finalPath = "";
		int continueLoop = 0;
		for (int i = 1; i < (splitedPath.length-2); ++i) {
			finalPath += splitedPath[i] + "/";
			if(splitedPath[i].equals("eclipse-workspace") || splitedPath[i].equals("Java")) {
				continueLoop = i;
				break;
			}			
		}
		
		for(int i = continueLoop; i < (splitedPath.length-2); ++i) {
			if(splitedPath[i].equals("Practica_DAD_2")) {
				finalPath += splitedPath[i] + "/";
				break;
			}
		}
		
		return finalPath;
	}
	
	public static String getPathLinuxVersion() {
		java.net.URL url = ProjectPath.class.getProtectionDomain().getCodeSource().getLocation();
  		String path = url.toString() + "";
  		String [] splitedPath = path.split("\\"); 
		
		String finalPath = "";
		for (int i = 1; i < (splitedPath.length-2); ++i) {
			finalPath += splitedPath[i] + "\\";
		}
		
		return finalPath;
	}
}
