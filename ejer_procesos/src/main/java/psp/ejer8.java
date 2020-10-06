package psp;

import java.io.File;
import java.io.IOException;

public class ejer8 {

	public static void main(String[] args) throws IOException {
		// Programa que ejecuta un “.bat” previamente preparado y recoge la salida en un archivo y los errores en otro.

ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "E:\\DESARROLLO DE APLICACIONES MULTIMEDIA\\2 ANYO\\PSP\\fitxeros\\bat.bat");
		
		File fitSalida = new File("E:\\DESARROLLO DE APLICACIONES MULTIMEDIA\\2 ANYO\\PSP\\fitxeros\\guardar salida2.txt");
		File fitError = new File("E:\\DESARROLLO DE APLICACIONES MULTIMEDIA\\2 ANYO\\PSP\\fitxeros\\guardar errores2.txt");
		
		
		pb.redirectOutput(fitSalida);//escribir en un fichero la salida del comando
		pb.redirectError(fitError);//escribir errores en otro fichero
		pb.start();
		
	}

}
