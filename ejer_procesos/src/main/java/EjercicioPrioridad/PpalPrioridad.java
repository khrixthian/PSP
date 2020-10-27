package EjercicioPrioridad;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PpalPrioridad extends JFrame {

	public PpalPrioridad() {
		setSize(600, 500);
		getContentPane().setLayout(null);
		getContentPane().setSize(400, 300);

		JLabel lblHilo1 = new JLabel("");
		lblHilo1.setBounds(10, 11, 414, 60);
		getContentPane().add(lblHilo1);

		JLabel lblHilo2 = new JLabel("");
		lblHilo2.setBounds(10, 70, 414, 60);
		getContentPane().add(lblHilo2);

		JLabel lblHilo3 = new JLabel("");
		lblHilo3.setBounds(10, 141, 414, 60);
		getContentPane().add(lblHilo3);

		JButton btnFinTodos = new JButton("Finalizar todos");
		btnFinTodos.setBounds(173, 224, 89, 23);

		JLabel lblFinTodos = new JLabel("");
		lblFinTodos.setBounds(10, 212, 414, 45);
		lblFinTodos.add(btnFinTodos);
		getContentPane().add(lblFinTodos);

		JLabel lblContHilo1 = new JLabel("Hilo 1: 0");
		lblContHilo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblContHilo1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblContHilo1.setBounds(10, 268, 207, 68);
		getContentPane().add(lblContHilo1);

		JLabel lblPrioHilo1 = new JLabel("Pri: 0");
		lblPrioHilo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrioHilo1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPrioHilo1.setBounds(221, 268, 197, 68);
		getContentPane().add(lblPrioHilo1);

		JLabel lblContHilo2 = new JLabel("Hilo 2: 0");
		lblContHilo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblContHilo2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblContHilo2.setBounds(10, 347, 207, 60);
		getContentPane().add(lblContHilo2);

		JLabel lblPrioHilo2 = new JLabel("Pri: 0");
		lblPrioHilo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrioHilo2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPrioHilo2.setBounds(221, 347, 203, 60);
		getContentPane().add(lblPrioHilo2);

		JLabel lblContHilo3 = new JLabel("Hilo 3: 0");
		lblContHilo3.setHorizontalAlignment(SwingConstants.CENTER);
		lblContHilo3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblContHilo3.setBounds(10, 410, 207, 60);
		getContentPane().add(lblContHilo3);

		JLabel lblPrioHilo3 = new JLabel("Pri: 0");
		lblPrioHilo3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrioHilo3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPrioHilo3.setBounds(221, 410, 203, 60);
		getContentPane().add(lblPrioHilo3);
	}

	public static void main(String[] args) {
		PpalPrioridad aaa = new PpalPrioridad();
		aaa.setVisible(true);

	}
}
