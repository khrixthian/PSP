package ejerciciosProcesosCorregidos;

import java.io.IOException;

public class Ejer1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ProcessBuilder pb = new ProcessBuilder("notepad");
		Process p = pb.start();
		System.out.println(p.pid());
		System.out.println(p.toHandle().parent().get().pid());

	}

}
