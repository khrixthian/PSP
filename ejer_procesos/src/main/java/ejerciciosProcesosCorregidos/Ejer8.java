package ejerciciosProcesosCorregidos;

import java.io.File;
import java.io.IOException;

public class Ejer8 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ProcessBuilder pb = new ProcessBuilder("CMD");
		File bat = new File("fichero.bat");
		File fOut = new File("salida.txt");
		File fErr = new File("error.txt");
		pb.redirectInput(bat);
		pb.redirectOutput(fOut);
		pb.redirectError(fErr);
		pb.start();
	}

}
