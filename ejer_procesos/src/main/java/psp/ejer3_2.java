package psp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ejer3_2 {
	// NO FUNCIONA
	public static void main(String[] args) throws IOException {

		ProcessBuilder pb = new ProcessBuilder("java", "ejer3_1");
		pb.directory(new File("bin"));
		Process p = pb.start();

		OutputStream os = p.getOutputStream();
		String dato = "hola";
		os.write(dato.getBytes());
		os.flush();

		InputStream is = p.getInputStream();
		int c;
		while ((c = is.read()) != -1)
			System.out.print((char) c);

	}

}
