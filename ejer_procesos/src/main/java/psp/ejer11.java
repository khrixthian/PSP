package psp;

import java.io.InputStream;

public class ejer11 {

	public static void main(String[] args) {
		// Haz un programa que obtenga la dirección MAC y la muestre por pantalla
		
		ProcessBuilder test = new ProcessBuilder();
		test = test.command("CMD", "/C", "ipconfig /all | find \"física\"");
		
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