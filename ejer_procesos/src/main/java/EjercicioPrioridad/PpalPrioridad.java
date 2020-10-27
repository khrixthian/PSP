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
	JButton btnMenos3;
	JButton btnMenos2;
	JButton btnMenos1;
	JButton btnMas3;
	JButton btnMas2;
	JButton btnMas1;
	JButton btnFin1;
	JButton btnFin2;
	JButton btnFin3;
	JLabel lblContHilo1;
	JLabel lblContHilo2;
	JLabel lblContHilo3;
	JLabel lblPrioHilo1;
	JLabel lblPrioHilo2;
	JLabel lblPrioHilo3;
	int prioridad;
	String auxprio;

	public PpalPrioridad() {
		setSize(450, 600);
		getContentPane().setLayout(null);
		getContentPane().setSize(550, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Ejercicio Prioridad");

		// iniciar los hilos
		hilo1 = new HiloContador(lblContHilo1, lblPrioHilo1, 5);
		hilo2 = new HiloContador(lblContHilo2, lblPrioHilo2, 5);
		hilo3 = new HiloContador(lblContHilo3, lblPrioHilo3, 5);
		hilo1.start();
		hilo2.start();
		hilo3.start();

		JButton btnFinTodos = new JButton("Finalizar todos");
		btnFinTodos.setBounds(173, 224, 117, 23);
		btnFinTodos.setVisible(true);
		getContentPane().add(btnFinTodos);

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
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		Object obj1 = evt.getSource();
		boolean activo = true;

		if (obj1 == btnFin1) {

			hilo1.fin1Hilo();
		} else if (obj1 == btnFin2) {
			hilo2.fin1Hilo();
		} else
			hilo3.fin1Hilo();

		if (obj1 == btnMenos1) {
			auxprio = lblPrioHilo1.getText();
			prioridad = Integer.parseInt(auxprio);
			if (prioridad == 10) {
				prioridad = 5;
			} else if (prioridad == 5) {
				prioridad = 0;
			} else
				prioridad = 0;
			hilo1.cambioPrioridad(lblPrioHilo1, prioridad);
		}

		if (obj1 == btnMenos2) {
			auxprio = lblPrioHilo1.getText();
			prioridad = Integer.parseInt(auxprio);
			if (prioridad == 10) {
				prioridad = 5;
			} else if (prioridad == 5) {
				prioridad = 0;
			} else
				prioridad = 0;
			hilo2.cambioPrioridad(lblPrioHilo1, prioridad);
		}

		if (obj1 == btnMenos3) {
			auxprio = lblPrioHilo1.getText();
			prioridad = Integer.parseInt(auxprio);
			if (prioridad == 10) {
				prioridad = 5;
			} else if (prioridad == 5) {
				prioridad = 0;
			} else
				prioridad = 0;
			hilo3.cambioPrioridad(lblPrioHilo1, prioridad);
		}

	}

	public static void main(String[] args) {
		PpalPrioridad aaa = new PpalPrioridad();
		aaa.setVisible(true);

	}
}
