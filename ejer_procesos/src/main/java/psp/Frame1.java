package psp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame1 extends JFrame {

	public JPanel panel;
	public JButton boton;
	
	public Frame1() {
		
		setSize(300, 200);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); 
		setLocationRelativeTo(null);
		
		boton = new JButton("Cerrar");
		boton.setBounds(100, 66, 100, 25);
		panel.add(boton);
	
	
	boton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();//cerrar la ventana
		}
	});
}
	
	public static void main(String[] args) {
		new Frame1();
		new Frame1().setVisible(true);	
	}

}
