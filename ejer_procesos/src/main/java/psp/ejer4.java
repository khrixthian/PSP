package psp;

import java.io.InputStream;

public class ejer4 {
	// NO FUNCIONA
	public static void main(String[] args) {
		// Cambiar la fecha del sistema a través de un proceso en java.
		ProcessBuilder test = new ProcessBuilder();
		test = test.command("CMD", "/C", "date");
		try {
			Process p1 = test.start();
			InputStream is = p1.getInputStream();
			System.out.println();
			int c;
			while ((c = is.read()) != -1)
				System.out.print((char) c);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
