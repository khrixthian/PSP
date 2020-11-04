package EjercicioPrioridad;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PpalPrioridad extends JFrame implements ActionListener {

	private HiloContador hilo1;
	private HiloContador hilo2;
	private HiloContador hilo3;
	private JButton btnMenos3;
	private JButton btnMenos2;
	private JButton btnMenos1;
	private JButton btnMas3;
	private JButton btnMas2;
	private JButton btnMas1;
	private JButton btnFin1;
	private JButton btnFin2;
	private JButton btnFin3;
	private JButton btnFinTodo;
	private JLabel lblContHilo1;
	private JLabel lblContHilo2;
	private JLabel lblContHilo3;
	private JLabel lblPrioHilo1;
	private JLabel lblPrioHilo2;
	private JLabel lblPrioHilo3;
	int prioridad;
	String auxprio;
	private boolean activo = true;

	public PpalPrioridad() {
		setSize(450, 600);
		getContentPane().setLayout(null);
		getContentPane().setSize(550, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Ejercicio Prioridad");

		lblContHilo1 = new JLabel("Hilo 1: 0");
		lblContHilo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblContHilo1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblContHilo1.setBounds(10, 268, 207, 68);
		getContentPane().add(lblContHilo1);

		lblPrioHilo1 = new JLabel("Pri: 0");
		lblPrioHilo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrioHilo1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPrioHilo1.setBounds(221, 268, 197, 68);
		getContentPane().add(lblPrioHilo1);

		lblContHilo2 = new JLabel("Hilo 2: 0");
		lblContHilo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblContHilo2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblContHilo2.setBounds(10, 347, 207, 60);
		getContentPane().add(lblContHilo2);

		lblPrioHilo2 = new JLabel("Pri: 0");
		lblPrioHilo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrioHilo2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPrioHilo2.setBounds(221, 347, 203, 60);
		getContentPane().add(lblPrioHilo2);

		lblContHilo3 = new JLabel("Hilo 3: 0");
		lblContHilo3.setHorizontalAlignment(SwingConstants.CENTER);
		lblContHilo3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblContHilo3.setBounds(10, 410, 207, 60);
		getContentPane().add(lblContHilo3);

		lblPrioHilo3 = new JLabel("Pri: 0");
		lblPrioHilo3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrioHilo3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPrioHilo3.setBounds(221, 410, 203, 60);
		getContentPane().add(lblPrioHilo3);

		btnFin3 = new JButton("Fin hilo 3");
		btnFin3.setBounds(185, 172, 89, 23);
		getContentPane().add(btnFin3);

		btnFin2 = new JButton("Fin hilo 2");
		btnFin2.setBounds(185, 107, 89, 23);
		getContentPane().add(btnFin2);

		btnFin1 = new JButton("Fin hilo 1");
		btnFin1.setBounds(185, 46, 89, 23);
		getContentPane().add(btnFin1);

		btnMas1 = new JButton("++");
		btnMas1.setBounds(336, 46, 49, 23);
		getContentPane().add(btnMas1);

		btnMas2 = new JButton("++");
		btnMas2.setBounds(336, 107, 49, 23);
		getContentPane().add(btnMas2);

		btnMas3 = new JButton("++");
		btnMas3.setBounds(336, 172, 49, 23);
		getContentPane().add(btnMas3);

		btnMenos1 = new JButton("--");
		btnMenos1.setBounds(71, 46, 49, 23);
		getContentPane().add(btnMenos1);

		btnMenos2 = new JButton("--");
		btnMenos2.setBounds(71, 107, 49, 23);
		getContentPane().add(btnMenos2);

		btnMenos3 = new JButton("--");
		btnMenos3.setBounds(71, 172, 49, 23);
		getContentPane().add(btnMenos3);

		btnFinTodo = new JButton("Fin todos");
		btnFinTodo.setBounds(185, 237, 89, 23);
		getContentPane().add(btnFinTodo);

		// iniciar los hilos
		hilo1 = new HiloContador(lblContHilo1, lblPrioHilo1, 5);
		hilo2 = new HiloContador(lblContHilo2, lblPrioHilo2, 5);
		hilo3 = new HiloContador(lblContHilo3, lblPrioHilo3, 5);

		hilo1.start();
		hilo2.start();
		hilo3.start();

		// escutxadores
		btnFin1.addActionListener(this);
		btnFin2.addActionListener(this);
		btnFin3.addActionListener(this);
		btnMenos1.addActionListener(this);
		btnMenos2.addActionListener(this);
		btnMenos3.addActionListener(this);
		btnMas1.addActionListener(this);
		btnMas2.addActionListener(this);
		btnMas3.addActionListener(this);
		btnFinTodo.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		Object obj1 = evt.getSource();

		if (obj1 == btnFinTodo) {
			hilo1.fin1Hilo();
			hilo2.fin1Hilo();
			hilo3.fin1Hilo();
		}

		if (obj1 == btnFin1) {
			hilo1.fin1Hilo();
		} else if (obj1 == btnFin2) {
			hilo2.fin1Hilo();
		} else if (obj1 == btnFin3) {
			hilo3.fin1Hilo();
		}

		if (obj1 == btnMenos1) {
			auxprio = lblPrioHilo1.getText();
			prioridad = Integer.parseInt(auxprio);
			if (prioridad == 10) {
				prioridad = 5;
			} else if (prioridad == 5) {
				prioridad = 1;
			} else if (prioridad == 1) {
				prioridad = 1;
			}
			hilo1.setPriority(prioridad);
			hilo1.cambioPrioridad(lblPrioHilo1, prioridad);
		}

		if (obj1 == btnMenos2) {
			auxprio = lblPrioHilo2.getText();
			prioridad = Integer.parseInt(auxprio);
			if (prioridad == 10) {
				prioridad = 5;
			} else if (prioridad == 5) {
				prioridad = 1;
			} else if (prioridad == 1) {
				prioridad = 1;
			}
			hilo2.setPriority(prioridad);
			hilo2.cambioPrioridad(lblPrioHilo2, prioridad);

		}

		if (obj1 == btnMenos3) {
			auxprio = lblPrioHilo3.getText();
			prioridad = Integer.parseInt(auxprio);
			if (prioridad == 10) {
				prioridad = 5;
			} else if (prioridad == 5) {
				prioridad = 1;
			} else if (prioridad == 1) {
				prioridad = 1;
			}
			hilo3.setPriority(prioridad);
			hilo3.cambioPrioridad(lblPrioHilo3, prioridad);
		}

		if (obj1 == btnMas1) {
			auxprio = lblPrioHilo1.getText();
			prioridad = Integer.parseInt(auxprio);
			if (prioridad == 10) {
				prioridad = 10;
			} else if (prioridad == 5) {
				prioridad = 10;
			} else if (prioridad == 1) {
				prioridad = 5;
			}
			hilo1.setPriority(prioridad);
			hilo1.cambioPrioridad(lblPrioHilo1, prioridad);
		}

		if (obj1 == btnMas2) {
			auxprio = lblPrioHilo2.getText();
			prioridad = Integer.parseInt(auxprio);
			if (prioridad == 10) {
				prioridad = 10;
			} else if (prioridad == 5) {
				prioridad = 10;
			} else if (prioridad == 1) {
				prioridad = 5;
			}
			hilo2.setPriority(prioridad);
			hilo2.cambioPrioridad(lblPrioHilo2, prioridad);
		}

		if (obj1 == btnMas3) {
			auxprio = lblPrioHilo3.getText();
			prioridad = Integer.parseInt(auxprio);
			if (prioridad == 10) {
				prioridad = 10;
			} else if (prioridad == 5) {
				prioridad = 10;
			} else if (prioridad == 1) {
				prioridad = 5;
			}
			hilo3.setPriority(prioridad);
			hilo3.cambioPrioridad(lblPrioHilo3, prioridad);
		}

	}

	public static void main(String[] args) {
		PpalPrioridad aaa = new PpalPrioridad();
		aaa.setVisible(true);

	}
}
