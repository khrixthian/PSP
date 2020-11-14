package ejerciciosProcesosCorregidos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejer3 {

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub

		ProcessBuilder pb = new ProcessBuilder("java", "EjemploLectura");
		pb.directory(new File("bin"));
		Process p = pb.start();

		OutputStream os = p.getOutputStream();
		String dato = "IKER\\n";
		os.write(dato.getBytes());
		os.flush();

		InputStream is = p.getInputStream();
		int c;
		while ((c = is.read()) != -1)
			System.out.print((char) c);

	}

}
