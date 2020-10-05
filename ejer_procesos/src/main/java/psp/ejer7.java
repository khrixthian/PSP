package psp;

import java.io.*;

public class ejer7 {

	public static void main(String[] args) throws IOException {
		// Programa que recoge la salida en un archivo y también los posibles errores.
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "help");
		
		File fitSalida = new File("E:\\DESARROLLO DE APLICACIONES MULTIMEDIA\\2 ANYO\\PSP\\fitxeros\\guardar salida.txt");
		File fitError = new File("E:\\DESARROLLO DE APLICACIONES MULTIMEDIA\\2 ANYO\\PSP\\fitxeros\\guardar errores.txt");
		
		pb.redirectOutput(fitSalida);//escribir en un fichero la salida del comando
		pb.redirectError(fitError);//escribir errores en otro fichero
		pb.start();
		
	}

}
