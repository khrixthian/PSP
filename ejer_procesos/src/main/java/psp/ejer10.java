package psp;

import java.io.InputStream;

public class ejer10 {

	public static void main(String[] args) {
		// Modifica el programa anterior para que se mate el notepad en caso de que se detecte que está en ejecución.

		ProcessBuilder test = new ProcessBuilder();
		test = test.command("CMD", "/C", "taskkill /im notepad.exe"); // /im es para que busque el proceso por el nombre
		try { 
			Process p1 = test.start(); 
			InputStream is = p1.getInputStream(); 
			System.out.println(); 
			int c; 
			while ((c = is.read()) != -1) 
			System.out.print((char) c); is.close(); 
			} catch (Exception e) { 
			e.printStackTrace();
			}
		
	}

}
