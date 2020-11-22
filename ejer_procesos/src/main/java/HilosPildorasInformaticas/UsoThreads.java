package HilosPildorasInformaticas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UsoThreads { // video 168

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame marco = new MarcoRebote();

		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		marco.setVisible(true);

	}

}

//EMPIEZA EL VIDEO A PROGRAMAR
class PelotaHilos implements Runnable {

	public PelotaHilos(Pelota unaPelota, Component uncomponente) {
		pelota = unaPelota;
		componente = uncomponente;
	}

	@Override
	public void run() {
		// para ver si el hilo esta vivo
		System.out.println("Inicio " + Thread.currentThread().isInterrupted());

		// traigo el for de abajo
		// for (int i = 1; i <= 3000; i++) {
		// while (!Thread.interrupted()) {
		while (!Thread.currentThread().isInterrupted()) {
			pelota.mueve_pelota(componente.getBounds());

			componente.paint(componente.getGraphics());
			// pausa de 4 ms
			// comento el sleep para que no se pare ademas de cambiar el for por un while
			// para usar el interrupted()
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}

		}
		System.out.println("Final " + Thread.currentThread().isInterrupted());
	}

	private Pelota pelota;
	private Component componente;

}
//FIN EMPIEZA EL VIDEO A PROGRAMAR

//Movimiento de la pelota-----------------------------------------------------------------------------------------

class Pelota {

	// Mueve la pelota invirtiendo posición si choca con límites

	public void mueve_pelota(Rectangle2D limites) {

		x += dx;

		y += dy;

		if (x < limites.getMinX()) {

			x = limites.getMinX();

			dx = -dx;
		}

		if (x + TAMX >= limites.getMaxX()) {

			x = limites.getMaxX() - TAMX;

			dx = -dx;
		}

		if (y < limites.getMinY()) {

			y = limites.getMinY();

			dy = -dy;
		}

		if (y + TAMY >= limites.getMaxY()) {

			y = limites.getMaxY() - TAMY;

			dy = -dy;

		}

	}

	// Forma de la pelota en su posición inicial

	public Ellipse2D getShape() {

		return new Ellipse2D.Double(x, y, TAMX, TAMY);

	}

	private static final int TAMX = 15;

	private static final int TAMY = 15;

	private double x = 0;

	private double y = 0;

	private double dx = 1;

	private double dy = 1;

}

// Lámina que dibuja las pelotas----------------------------------------------------------------------

class LaminaPelota extends JPanel {

	// Añadimos pelota a la lámina

	public void add(Pelota b) {

		pelotas.add(b);
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		for (Pelota b : pelotas) {

			g2.fill(b.getShape());
		}

	}

	private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
}

//Marco con lámina y botones------------------------------------------------------------------------------

class MarcoRebote extends JFrame {

	public MarcoRebote() {

		setBounds(600, 300, 400, 350);

		setTitle("Rebotes");

		lamina = new LaminaPelota();

		add(lamina, BorderLayout.CENTER);

		JPanel laminaBotones = new JPanel();

		// comento los 3 de abajo de poner boton para el video 170 parar hilos
		// independientemente
//		ponerBoton(laminaBotones, "Dale!", new ActionListener() {
//
//			public void actionPerformed(ActionEvent evento) {
//
//				comienza_el_juego();
//			}
//
//		});
//
//		ponerBoton(laminaBotones, "Salir", new ActionListener() {
//
//			public void actionPerformed(ActionEvent evento) {
//
//				System.exit(0);
//
//			}
//
//		});
//
//		ponerBoton(laminaBotones, "Parar", new ActionListener() {
//
//			public void actionPerformed(ActionEvent evento) {
//
//				detener();
//
//			}
//
//		});
		arranca1 = new JButton("Hilo1");
		arranca1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				comienza_el_juego(evento);
			}
		});
		laminaBotones.add(arranca1);

		arranca2 = new JButton("Hilo2");
		arranca2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				comienza_el_juego(evento);
			}
		});
		laminaBotones.add(arranca2);

		arranca3 = new JButton("Hilo3");
		arranca3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				comienza_el_juego(evento);
			}
		});
		laminaBotones.add(arranca3);

		detener1 = new JButton("Parar1");
		detener1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				detener(evento);
			}
		});
		laminaBotones.add(detener1);

		detener2 = new JButton("Parar2");
		detener2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				detener(evento);
			}
		});
		laminaBotones.add(detener2);

		detener3 = new JButton("Parar3");
		detener3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				detener(evento);
			}
		});
		laminaBotones.add(detener3);

		add(laminaBotones, BorderLayout.SOUTH);
	}

	// Ponemos botones este metodo lo comento para el video 170

//	public void ponerBoton(Container c, String titulo, ActionListener oyente) {
//
//		JButton boton = new JButton(titulo);
//
//		c.add(boton);
//
//		boton.addActionListener(oyente);
//
//	}

	// Añade pelota y la bota 1000 veces

	public void comienza_el_juego(ActionEvent e) {

		Pelota pelota = new Pelota();

		lamina.add(pelota);
//vengo de arriba una vez que ya he hecho la clase runnable
		Runnable r = new PelotaHilos(pelota, lamina);
		if (e.getSource().equals(arranca1)) {
			th1 = new Thread(r);
			th1.start();
		} else if (e.getSource().equals(arranca2)) {
			th2 = new Thread(r);
			th2.start();
		} else if (e.getSource().equals(arranca3)) {
			th3 = new Thread(r);
			th3.start();
		}
//me llevo el for al run
//		for (int i = 1; i <= 3000; i++) {
//
//			pelota.mueve_pelota(lamina.getBounds());
//
//			lamina.paint(lamina.getGraphics());
//			// pausa de 4 ms
//			try {
//				Thread.sleep(4);
//			} catch (InterruptedException e) {
//				// TODO Bloque catch generado automáticamente
//				e.printStackTrace();
//			}
//
//		}

		// video 170 parar el hilo que queramos no el ultimo que es lo que se consigue
		// con el video 169
		// que es el de uso de interrupted() o isInterrupted

	}

	public void detener(ActionEvent e) {
		// th.stop();// metodo obsoleto
		// th1.interrupt(); // no lo para por que tiene un sleep
		if (e.getSource().equals(detener1)) {
			th1.interrupt();
		} else if (e.getSource().equals(detener2)) {
			th2.interrupt();
		} else if (e.getSource().equals(detener3)) {
			th3.interrupt();
		}
	}

	Thread th1, th2, th3;
	JButton arranca1, arranca2, arranca3, detener1, detener2, detener3;
	private LaminaPelota lamina;

}
