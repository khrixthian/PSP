package psp;

import java.io.InputStream;

public class Procesos_V_AveriguarIfRun {
	// FUNCIONA
	public static void main(String[] args) {
		// Haz un programa llamado Procesos_V_AveriguarIfRun que muestre los procesos en
		// ejecución
		// y añade aquí el código java que lo implementa.

		ProcessBuilder test = new ProcessBuilder();
		test = test.command("CMD", "/C", "tasklist");
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
