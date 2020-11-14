package psp;

import java.io.File;
import java.io.IOException;

public class ejer7 {
	// FUNCIONA
	public static void main(String[] args) throws IOException {
		// Programa que recoge la salida en un archivo y también los posibles errores.
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "helpp");

		File fitSalida = new File("E:\\DAM\\PSP\\fitxeros\\guardar salida.txt");// abrir con bloc de notas
		File fitError = new File("E:\\DAM\\PSP\\fitxeros\\guardar errores.txt");

		pb.redirectOutput(fitSalida);// escribir en un fichero la salida del comando
		pb.redirectError(fitError);// escribir errores en otro fichero
		pb.start();

	}

}
