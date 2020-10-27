package EjercicioReloj;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaContadorReloj extends JFrame implements ActionListener {

	private JPanel contentPane;
	private RelojThread rel = null;
	private RelojThread rel2 = null;
	boolean Presionado = false;
	boolean IniciarOk = false;
	private boolean cronoact;
	private int onoff = 0;
	private boolean auxpausar = false;
	JButton iniciar;
	JButton parar;
	JButton pausar;
	JButton reiniciar;
	JButton salir;
	Thread Colort1;
	Thread Colort2;

	JLabel reloj = new JLabel("00:00");

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

		iniciar = new JButton("INICIAR");
		iniciar.setBounds(28, 191, 89, 23);
		contentPane.add(iniciar);

		pausar = new JButton("PAUSAR");
		pausar.setBounds(128, 191, 89, 23);
		contentPane.add(pausar);
		pausar.setVisible(false);

		parar = new JButton("PARAR");
		parar.setBounds(227, 191, 89, 23);
		contentPane.add(parar);
		parar.setVisible(false);

		reiniciar = new JButton("REINICIAR");
		reiniciar.setBounds(326, 191, 89, 23);
		contentPane.add(reiniciar);
		reiniciar.setVisible(false);

		salir = new JButton("SALIR");
		salir.setBounds(425, 191, 89, 23);
		contentPane.add(salir);

		EtiketaThread ColorR1 = new EtiketaThread(atras);
		EtiketaThread ColorR2 = new EtiketaThread(adelante);
		Colort1 = new Thread(ColorR1);
		Colort2 = new Thread(ColorR2);
		Colort1.setName("Etiketa atras");
		Colort2.setName("Etiketa adelante");
		Colort1.setPriority(Colort1.MIN_PRIORITY);
		Colort2.setPriority(Colort2.MIN_PRIORITY);
		Colort1.start();
		Colort2.start();

		// escuchadores
		iniciar.addActionListener(this);
		pausar.addActionListener(this);
		parar.addActionListener(this);
		reiniciar.addActionListener(this);
		salir.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		Object obj = evt.getSource();
		if (obj == iniciar) {
			reiniciar.setVisible(true);
			parar.setVisible(true);
			pausar.setVisible(true);
			iniciar.setEnabled(false);
			reiniciar.setEnabled(true);
			parar.setEnabled(true);
			pausar.setEnabled(true);
			cronoact = true;
			rel = new RelojThread(reloj, cronoact);
			rel.start();
		}

		if (obj == pausar) {

			iniciar.setEnabled(auxpausar);
			reiniciar.setEnabled(auxpausar);
			parar.setEnabled(auxpausar);
			auxpausar = !auxpausar;
			rel.pausar();
		}
		if (obj == parar) {
			rel.cambiarFalse();
			iniciar.setEnabled(true);
			reiniciar.setEnabled(false);
			pausar.setEnabled(false);
		}
		if (obj == reiniciar) {
			rel.reiniciar();
		}
		if (obj == salir) {
			rel.cerrarHilo();
			System.out.println("El hilo " + Colort1.getName() + " ha terminado.");
			System.out.println("El hilo " + Colort2.getName() + " ha terminado.");
			System.exit(0);
		}
	}
}
