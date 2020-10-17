package HILOS;

import java.lang.Thread;

public class MiThread1 extends Thread {
	
	
	
	public MiThread1() {
		this.start();//con esto se ejecuta esta clase en cuanto se la instancie.
		this.setName("NombreHilo");
	}

	public void run() {
		System.out.println("hilo creado. Contar");
		for (int x=1; x<=10; x++) {
			System.out.print(x + " ");
		}
	}
}
