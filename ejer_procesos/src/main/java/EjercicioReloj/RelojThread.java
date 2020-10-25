package EjercicioReloj;

import javax.swing.JLabel;

public class RelojThread extends Thread {
	JLabel etiketa = new JLabel();
	String min = "", seg = "";
	boolean cronoact;

	public RelojThread(JLabel etiketa, boolean cronoact) {
		super();
		this.etiketa = etiketa;
		this.cronoact = cronoact;
		// h1.start();
	}

	Thread h1;
	String hora;

	@Override
	public void run() {
		int minutos = 0, segundos = 0, aux = 0;
		// try {
		while (this.cronoact == true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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

			hora = min + ":" + seg;
			this.etiketa.setText(hora);

		} // while (cronoact == true);

	}// fin iniciar

}