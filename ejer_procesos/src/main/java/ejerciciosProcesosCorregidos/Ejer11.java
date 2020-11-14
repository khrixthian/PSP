package ejerciciosProcesosCorregidos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejer11 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ProcessBuilder test = new ProcessBuilder("CMD", "/C", "ipconfig /all");

		Process p = test.start();
		InputStream is = p.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String c;
		while ((c = br.readLine()) != null) {

			if (c.contains("Direcci¢n f¡sica")) {

				System.out.println(c.split(":")[1]);

			}
		}

	}

}
