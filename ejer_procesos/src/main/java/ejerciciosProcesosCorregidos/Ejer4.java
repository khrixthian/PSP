package ejerciciosProcesosCorregidos;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejer4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "date");
		Process p = pb.start();

		OutputStream os = p.getOutputStream();
		os.write("04-11-2020\n".getBytes());
		os.flush();

		InputStream is = p.getInputStream();
		int c;
		while ((c = is.read()) != -1)
			System.out.print((char) c);
	}

}
