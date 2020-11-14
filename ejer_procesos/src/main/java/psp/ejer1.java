package psp;

import java.io.IOException;

public class ejer1 {
	// FUNCIONA
	public static void main(String[] args) throws IOException, InterruptedException {
		// ejercicio 1 abrir un documento de texto
		ProcessBuilder pb = new ProcessBuilder("notepad");
		Process p = pb.start();

		// pb.start();
		// p.waitFor();
		System.out.println("Nº del proceso " + p.pid());// pid del proceso
		System.out.println("Nº del proceso del padre " + p.toHandle().parent().get().pid());// esto nos da el pid del
																							// padre

	}

}
