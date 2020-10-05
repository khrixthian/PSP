package psp;

import java.io.File;
import java.io.IOException;

public class Procesos_V_Tres {

	public static void main(String[] args) {
		//Haz un programa llamado Frame1 que lance una ventana con un botón. Al pulsarlo finaliza el
		//programa.
		//Haz otro programa llamado Procesos_V_Tres que lance Frame1 y espere hasta que finalice,
		//cuando lo haga mostrará por consola el valor devuelto por Frame1.
		
		//NO VA
		
		ProcessBuilder pb = new ProcessBuilder();
		
		pb.directory(new File(".//bin"));
		pb = pb.command("java","psp.Frame1");
		
		try {
			Process pro = pb.start();
			int valorSalida = pro.waitFor();
			System.out.println("Lo que devuelve al cerrar la ventana: " + valorSalida);
			
		}catch(IOException e){
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		

	}

}
