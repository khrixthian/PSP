package EjercicioReloj;

import javax.swing.JLabel;

public class RelojThread extends Thread {
	JLabel etiketa = new JLabel();
	String min = "", seg = "";
	boolean cronoact = true;
	boolean cronoparado = false;
	int minutos = 0, segundos = 0, aux = 0;

	public RelojThread(JLabel etiketa, boolean cronoact) {
		super();
		this.etiketa = etiketa;
		this.cronoact = cronoact;
		this.setName("Reloj");
		this.setPriority(5);

	}

	String hora;

	public void cambiarFalse() {
		this.cronoact = false;
	}

	public void cambiarTrue() {
		this.cronoact = true;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		while (cronoact) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!cronoparado) {

				segundos += 1;

				if (segundos == 60) {
					segundos = 0;
					minutos++;
				}

				if (minutos < 10) {
					min = "0" + minutos;

				} else {
					min = Integer.toString(minutos);
				}

				if (segundos < 10) {
					seg = "0" + segundos;
				} else {
					seg = Integer.toString(segundos);
				}
				if (minutos == 60) {
					minutos = 0;
				}

				hora = min + ":" + seg;
				this.etiketa.setText(hora);
			} // if
		} // while
		System.out.println("El hilo " + this.getName() + " ha terminado.");

	}// fin run

	public void reiniciar() {
		minutos = 0;
		segundos = 0;
	}

	public void cerrarHilo() {
		this.cronoact = false;
	}

	public void pausar() {

		this.cronoparado = !this.cronoparado;

	}
}
