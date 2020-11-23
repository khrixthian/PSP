package pruebaCronometroDecrecente;

import javax.swing.JLabel;

public class RelojThread2 extends Thread {
	JLabel etiketa = new JLabel();
	String hora = "", min = "", seg = "";
	boolean cronoact = true;
	boolean cronoparado = false;
	int horas = 1, minutos = 30, segundos = 0, aux = 0;

	public RelojThread2(JLabel etiketa, boolean cronoact) {
		super();
		this.etiketa = etiketa;
		this.cronoact = cronoact;
		this.setName("Reloj");
		this.setPriority(5);

	}

	String crono;

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

				segundos -= 1;

				if (segundos == 00) {
					segundos = 59;
					minutos--;
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
				if (minutos == 00) {
					minutos = 59;
					horas = 0;
				}

				crono = horas + ":" + min + ":" + seg;
				this.etiketa.setText(crono);
			} // if
		} // while
		System.out.println("El hilo " + this.getName() + " ha terminado.");

	}// fin run

	public void reiniciar() {
		horas = 1;
		minutos = 30;
		segundos = 0;
	}

	public void cerrarHilo() {
		this.cronoact = false;
	}

	public void pausar() {
		this.cronoparado = !this.cronoparado;

	}
}
