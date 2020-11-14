package ejerciciosProcesosCorregidos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Ejer6 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		ProcessBuilder test = new ProcessBuilder();
		Map entorno = test.environment();
		System.out.println("Variables de entorno:");
		System.out.println(entorno);
		test = new ProcessBuilder("java", "LeerNombre", "Maria Jesús");
		List l = test.command();
		Iterator iter = l.iterator();
		System.out.println("\nArgumentos del comando:");
		while (iter.hasNext())
			System.out.println(iter.next());
		test = test.command("CMD", "/C", "DIR");
		try {
			Process p = test.start();
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String c;
			while ((c = br.readLine()) != null)
				System.out.print(c);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
