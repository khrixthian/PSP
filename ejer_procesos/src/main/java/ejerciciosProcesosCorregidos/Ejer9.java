package ejerciciosProcesosCorregidos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejer9 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ProcessBuilder test = new ProcessBuilder("CMD", "/C", "tasklist");

		Process p = test.start();
		InputStream is = p.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String c;
		while ((c = br.readLine()) != null)
			System.out.println(c);

	}

}
