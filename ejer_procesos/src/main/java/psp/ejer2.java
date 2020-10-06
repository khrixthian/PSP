package psp;

import java.io.IOException;
import java.io.InputStream;

public class ejer2 {

	public static void main(String[] args) throws IOException {
		
		// ejer 2 Ejecutar un comando de windows. (Dir, Task, ...) y mostrar su resultado por pantalla.
		ProcessBuilder test = new ProcessBuilder();
		test = test.command("CMD", "/C", "DIR");
		
		test.redirectOutput(ProcessBuilder.Redirect.INHERIT); //nuevo esto lleva a la consola
		test.start();
		
		//directamente el resultado
		
		//	try { 
		//	Process p1 = test.start(); 
		//	InputStream is = p1.getInputStream(); 
		//	System.out.println(); 
		//	int c; 
		//	while ((c = is.read()) != -1) 
		//	System.out.print((char) c); is.close(); 
		//	} catch (Exception e) { 
		//	e.printStackTrace();
		//	}

	}

}
