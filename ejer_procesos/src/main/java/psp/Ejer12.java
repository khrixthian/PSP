package psp;
import java.io.File;
import java.io.IOException;

public class Ejer12 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ProcessBuilder pb = new ProcessBuilder("java","Frame1");
		pb.directory(new File("bin"));
		Process p = pb.start();
		
		try {
			System.out.println(p.pid());
			int exitValue =   p.waitFor();
			System.out.println("Valor de salida: " + exitValue);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
