package HilosPildorasInformaticas;

public class BancosinSincronizarWaitNotify {
	public static void main(String[] args) {
		Banco2 b = new Banco2();

		for (int i = 0; i < 100; i++) {

			EjecucionTransferencias2 r = new EjecucionTransferencias2(b, i, 2000);

			Thread t = new Thread(r);
			t.start();
		}

	}
}

class Banco2 {
	private final double[] cuentas;

	public Banco2() {
		cuentas = new double[100];

		for (int i = 0; i < cuentas.length; i++) {
			cuentas[i] = 2000;
		}

	}

	public synchronized void transferencias(int cuentaOrigen, int cuentaDestino, double cantidad)
			throws InterruptedException {

		while (cuentas[cuentaOrigen] < cantidad) {

			System.out.println("hilo en espera");
			wait();
		}

		System.out.println(Thread.currentThread());// imprime el hilo que va a hacer la transferencia

		cuentas[cuentaOrigen] -= cantidad; // resta la cantidad a la cuenta de origen

		System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);

		cuentas[cuentaDestino] += cantidad; // suma la cantidad a la cuenta destino

		System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal());

		notifyAll();

	}

	public double getSaldoTotal() {
		double suma_cuentas = 0;
		for (double a : cuentas) {
			suma_cuentas += a;
		}
		return suma_cuentas;
	}

}

class EjecucionTransferencias2 implements Runnable {

	public EjecucionTransferencias2(Banco2 b, int ctaDe, double max) {
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

	private Banco2 banco;
	private int ctaOrigen;
	private double cantidadMax;

}
