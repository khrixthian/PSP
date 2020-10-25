package EjercicioReloj;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaContadorReloj extends JFrame {

	private JPanel contentPane;
	private Thread rel = new Thread();
	private Thread t2 = new Thread();
	boolean Presionado = false;
	boolean IniciarOk = false;
	private boolean cronoact;

	// para la prueba de agrupar botones
	JLabel reloj = new JLabel("00:00");
	int onoff = 0;
	// private JLabel reloj = new JLabel("00:00");

	public VentanaContadorReloj() {
		setSize(550, 300);
		contentPane = new JPanel();
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ejercicio Reloj");
		setResizable(false);
		setLocationRelativeTo(null);

		JLabel atras = new JLabel("<<");
		atras.setFont(new Font("Tahoma", Font.PLAIN, 76));
		atras.setBounds(10, 66, 115, 61);
		contentPane.add(atras);

		JLabel adelante = new JLabel(">>");
		adelante.setFont(new Font("Tahoma", Font.PLAIN, 76));
		adelante.setBounds(419, 66, 115, 61);
		contentPane.add(adelante);

		// JLabel reloj = new JLabel("00:00");
		reloj.setFont(new Font("Tahoma", Font.PLAIN, 76));
		reloj.setBounds(165, 66, 213, 61);
		contentPane.add(reloj);

		JButton iniciar = new JButton("INICIAR");
		iniciar.setBounds(28, 191, 89, 23);
		contentPane.add(iniciar);

		JButton pausar = new JButton("PAUSAR");
		pausar.setBounds(128, 191, 89, 23);
		contentPane.add(pausar);
		pausar.setVisible(false);

		JButton parar = new JButton("PARAR");
		parar.setBounds(227, 191, 89, 23);
		contentPane.add(parar);
		parar.setVisible(false);

		JButton reiniciar = new JButton("REINICIAR");
		reiniciar.setBounds(326, 191, 89, 23);
		contentPane.add(reiniciar);
		reiniciar.setVisible(false);

		JButton salir = new JButton("SALIR");
		salir.setBounds(425, 191, 89, 23);
		contentPane.add(salir);

		EtiketaThread ColorR1 = new EtiketaThread(atras);
		EtiketaThread ColorR2 = new EtiketaThread(adelante);
		Thread Colort1 = new Thread(ColorR1);
		Thread Colort2 = new Thread(ColorR2);
		Colort1.setPriority(Colort1.MIN_PRIORITY);
		Colort2.setPriority(Colort2.MIN_PRIORITY);
		Colort1.start();
		Colort2.start();

		iniciar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reiniciar.setVisible(true);
				parar.setVisible(true);
				pausar.setVisible(true);
				cronoact = true;
				if (cronoact = true) {
					rel = new RelojThread(reloj, cronoact);
					rel.start();

				} else
					cronoact = false;

			}// fin void

		});// fin boton

		pausar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cronoact = false;

			}

		});// fin boton

		parar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});// fin boton

		reiniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cronoact = true;
				if (Presionado = true) {
					rel.interrupt();
					JLabel newreloj = new JLabel();
					newreloj = reloj;
					reloj.setVisible(false);
					newreloj.setVisible(true);
					newreloj.setText("00:00");
					RelojThread rel = new RelojThread(reloj, cronoact);
					rel.start();

				}
			}

		});// fin boton

		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Presionado = true) {
					Colort1.interrupt();
					Colort2.interrupt();
					System.exit(0);
				}

			}

		});// fin boton

	}

	/*
	 * prueba para acciones de los botones // Esto es para el boton iniciar y
	 * reiniciar
	 * 
	 * public void actionPerformed(ActionEvent evt) { Object o = evt.getSource(); if
	 * (o instanceof JButton) { JButton btn = (JButton) o; if
	 * (btn.getText().equals("INICIAR")) { if (onoff == 0) { onoff = 1;
	 * reiniciar.setVisible(true); parar.setVisible(true); pausar.setVisible(true);
	 * RelojThread rel = new RelojThread(reloj, cronoact); rel.start();
	 * System.out.println("entro aaaaaaaaaaaaa"); } } if
	 * (btn.getText().equals("PARAR")) { if (onoff == 1) { onoff = 0; cronoact =
	 * false; System.out.println("entro bbbbbbbbbbbbbbbbbb"); } } } }
	 * 
	 */// fin prueba

}
