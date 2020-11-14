package ejerciciosProcesosCorregidos;

import java.io.IOException;
import java.io.InputStream;

public class Ejer2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ProcessBuilder pb = new ProcessBuilder("cmd", "/C", "DIR");
		pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
		Process p = pb.start();

		InputStream is = p.getInputStream();
		int c;
		while ((c = is.read()) != -1)
			System.out.print((char) c);

	}

}
