package EjercicioPrioridad;

import javax.swing.JLabel;

public class HiloContador extends Thread {
	int prioridad = 5;
	boolean activo = true;
	JLabel etiketa = new JLabel();
	JLabel etiketa2 = new JLabel();
	int contador = 1;
	String auxcontador, auxprioridad;

	public HiloContador(JLabel etiketa, JLabel etiketa2, int prioridad) {
		super();
		this.etiketa = etiketa;
		this.etiketa2 = etiketa2;
		this.prioridad = prioridad;
		this.activo = activo;
	}

	public void run() {

		while (activo == true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			contador += 1;
			auxcontador = contador + "";
			auxprioridad = prioridad + "";
			this.etiketa2.setText(auxprioridad);
			this.etiketa.setText(auxcontador);

		} // while

		System.out.println("El hilo " + this.getName() + " ha terminado.");
	}

	public void fin1Hilo() {
		this.activo = false;
	}

	public void cambioPrioridad(JLabel etiketa2, int prioridad) {
		this.prioridad = prioridad;
		this.etiketa2 = etiketa2;
		System.out.println(prioridad);
	}
}
