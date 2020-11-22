package HilosPildorasInformaticas;

public class SincronizarHilos {

	public static void main(String[] args) {
		HilosVarios hilo1 = new HilosVarios();
		HilosVarios2 hilo2 = new HilosVarios2(hilo1);
		hilo2.start();
		hilo1.start();
		// como empieza el hilo2 1º y este no se ejecuta hasta que el hilo1 se ejecute,
		// el hilo del main
		// keda liberado y se ejecuta. Luego el hilo1 y al final hilo2

//		try {
//			hilo1.join();// hasta que no muera este hilo no empieza el otro
//		} catch (InterruptedException e) {
//			// TODO Bloque catch generado automáticamente
//			e.printStackTrace();
//		}
//
//		hilo2.start();
//		try {
//			hilo2.join();// hasta que no muera este hilo no empieza el otro
//		} catch (InterruptedException e) {
//			// TODO Bloque catch generado automáticamente
//			e.printStackTrace();
//		}
		System.out.println("terminadas las tareas");// esto se ejecuta en medio o antes del hilo2
		// porque pertenece al hilo del main, si le ponemos join al 2 se ejecuta el del
		// main al final del hilo2

	}

}

class HilosVarios extends Thread {

	public void run() {
		for (int i = 0; i < 15; i++) {
			System.out.println("Ejecutando hilo " + getName());
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
		}
	}
}

//hasta que no termine el hilo que le entra por parametro no empezara este
class HilosVarios2 extends Thread {

	public HilosVarios2(Thread hilo) {
		this.hilo = hilo;
	}

	public void run() {

		try {
			hilo.join();
		} catch (InterruptedException e1) {
			// TODO Bloque catch generado automáticamente
			e1.printStackTrace();
		}

		for (int i = 0; i < 15; i++) {
			System.out.println("Ejecutando hilo " + getName());
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
		}
	}

	private Thread hilo;
}