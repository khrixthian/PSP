package HiloThread;

public class PpalHiloThread {

	public static void main(String[] args) throws InterruptedException {

		KlaseHiloThread t1 = new KlaseHiloThread();
		KlaseHiloThread t2 = new KlaseHiloThread();
		
		t1.setName("hilo1");
		t2.setName("hilo2");
		System.out.println("Nombre del 1 hilo: " + t1.getName());
		System.out.println("Nombre del 2 hilo: " + t2.getName());

		System.out.println("t1 antes del bucle " + t1.isAlive());
		System.out.println("t2 antes del bucle " + t2.isAlive());
		
		for(int x=0; x<5;x++) {
			System.out.println("desde el ppal.");
		}
		Thread.sleep(1000);//esto duerme el hilo de ejecucion del programa main
		t2.sleep(9999);//si pongo sleep no escribe los ultimos sysos
		t1.sleep(19999);
		System.out.println("t1 despues del bucle " + t1.isAlive());
		System.out.println("t2 despues del bucle " + t2.isAlive());	
		t1.stop();//aunke ponga el stop
		t2.stop();
		//los hilos aparecen como no vivos y en el Process Explorer aparecen trabajando
		//y el programa no deja de trabajar en eclipse
	}

}
