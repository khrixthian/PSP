package psp;

import java.io.File;
import java.io.IOException;

public class Frame1 {

	public static void main(String[] args) {
		//Haz un programa llamado Frame1 que lance una ventana con un bot�n. Al pulsarlo finaliza el
		//programa.
		//Haz otro programa llamado Procesos_V_Tres que lance Frame1 y espere hasta que finalice,
		//cuando lo haga mostrar� por consola el valor devuelto por Frame1.
		
		ProcessBuilder pb = new ProcessBuilder();
		
		pb.directory(new File(".//bin"));
		pb = pb.command("java","ejer 12");
		
		try {
			Process pro = pb.start();
			int valorSalida = pro.waitFor();
			
		}catch(IOException e){
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}