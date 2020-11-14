package HiloRunnable;

public class PpalHiloRunnable {
	// FUNCIONA
	public static void main(String[] args) {

		HiloRunnable1 hilo1 = new HiloRunnable1();
		HiloRunnable2 hilo2 = new HiloRunnable2();

		Thread t1 = new Thread(hilo1);
		Thread t2 = new Thread(hilo2);

		t1.start();
		t2.start();

		System.out.println("t1 antes del bucle " + t1.isAlive());
		System.out.println("t2 antes del bucle " + t2.isAlive());

		for (int x = 0; x < 5; x++) {
			System.out.println("desde el ppal.");
		}

		System.out.println("t1 despues del bucle " + t1.isAlive());
		System.out.println("t2 despues del bucle " + t2.isAlive());

	}

}
