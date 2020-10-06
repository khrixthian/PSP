package psp;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class ejer3_2 {

	public static void main(String[] args) throws IOException {

		ProcessBuilder pb = new ProcessBuilder();
		pb.directory(new File("bin"));
		Process p= pb.start();
		
		OutputStream os = p.getOutputStream();
		String texto = "hola";
		os.write(b);
	}

}
