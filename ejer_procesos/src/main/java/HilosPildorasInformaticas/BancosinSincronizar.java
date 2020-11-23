package HilosPildorasInformaticas;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BancosinSincronizar {

	public static void main(String[] args) {
		Banco b = new Banco();

		for (int i = 0; i < 100; i++) {

			EjecucionTransferencias r = new EjecucionTransferencias(b, i, 2000);

			Thread t = new Thread(r);
			t.start();
		}

	}
}

class Banco {
	private final double[] cuentas;

	public Banco() {
		cuentas = new double[100];

		for (int i = 0; i < cuentas.length; i++) {
			cuentas[i] = 2000;
		}
		saldoSuficiente = cierreBanco.newCondition(); // el bloqueo se realiza en funcion de una condicion

	}

	public void transferencias(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {
		// para blokear el codigo para cada hilo
		cierreBanco.lock();

		try {
			// video 176 y 177
			// poner un hilo a la espera y liberar el codigo con el metodo await(). cuando
			// entra otro hilo y recorre todo el codigo, cuando acaba
			// avisa a todos los hilos en espera para que comprueben a ver si pueden
			// realizar sus funciones
			// cambio el if por un while
			while (cuentas[cuentaOrigen] < cantidad) {
				saldoSuficiente.await(); // ke mientras se cumpla la condicion del while, el hilo permanece a la espera
				System.out.println("hilo en espera");
				// if (cuentas[cuentaOrigen] < cantidad) {// evalua que el saldo es mayor que la
				// cantidad
//				System.out.println("-------------------Cantidad insuficiente en la cuenta: " + cuentaOrigen + " saldo: "
//						+ cuentas[cuentaOrigen] + " cantidad: " + cantidad);
				// return;
			} // else {
//				System.out.println("-----cantidad ok " + cuentaOrigen);
//			}

			System.out.println(Thread.currentThread());// imprime el hilo que va a hacer la transferencia

			cuentas[cuentaOrigen] -= cantidad; // resta la cantidad a la cuenta de origen

			System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);

			cuentas[cuentaDestino] += cantidad; // suma la cantidad a la cuenta destino

			System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal());

			// para cuando entren otros hilos que si cumplan la condicion antes de
			// desbloquear el codigo avisa a los hilos en espera que miren a ver si cumplen
			// la condicion
			saldoSuficiente.signalAll();
		} // fin try
			// para desblokear el codigo para cada hilo
		finally {
			cierreBanco.unlock();
		}
	}

	public double getSaldoTotal() {
		double suma_cuentas = 0;
		for (double a : cuentas) {
			suma_cuentas += a;
		}
		return suma_cuentas; // devuelve el saldo total de todas las cuentas
	}

	// para evitar que varios hilos entren a la vez a realizar transferencias
	private Lock cierreBanco = new ReentrantLock();
	// video 176-177
	private Condition saldoSuficiente;

}

class EjecucionTransferencias implements Runnable {

	public EjecucionTransferencias(Banco b, int ctaDe, double max) {
		banco = b;
		ctaOrigen = ctaDe;
		cantidadMax = max;
	}

	@Override
	public void run() {
		try {
			while (true) {

				int paraLaCta = (int) (100 * Math.random());

				double cantidad = cantidadMax * Math.random();

				banco.transferencias(ctaOrigen, paraLaCta, cantidad);

				Thread.sleep((int) (Math.random() * 10));

			}
		} catch (InterruptedException e) {
		}

	}

	private Banco banco;
	private int ctaOrigen;
	private double cantidadMax;

}
