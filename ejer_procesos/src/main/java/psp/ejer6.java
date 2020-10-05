package psp;

import java.util.*;

public class ejer6 {

	public static void main(String[] args) {
		// Ejecutar ProcessBuilder obteniendo variables de entorno, argumentos, buffer y comandos.
		ProcessBuilder test = new ProcessBuilder();
		Map entorno = test.environment(); 
		System.out.println("Variables de entorno:"); 
		System.out.println(entorno); 
		test = new ProcessBuilder("CMD", "/C", "dir"); 
		List l = test.command(); 
		Iterator iter = l.iterator(); 
		System.out.println("\nArgumentos del comando:"); 
		while (iter.hasNext()) 
		System.out.println(iter.next()); 

	}

}
