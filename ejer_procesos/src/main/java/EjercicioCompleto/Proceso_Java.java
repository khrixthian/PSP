package EjercicioCompleto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Proceso_Java extends JFrame {

	private JPanel contentPane;
	private JTextField TextEjecProgram;
	private JTextField TextEjecCmd;
	private JTextField TextLlamar5;
	JTextPane textoIzquierda;
	JTextPane textoDerecha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proceso_Java frame = new Proceso_Java();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Proceso_Java() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 538);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPid = new JLabel("PID");
		lblPid.setBounds(20, 166, 23, 14);
		contentPane.add(lblPid);

		JLabel lblPidPadre = new JLabel("PID Padre");
		lblPidPadre.setBounds(20, 208, 58, 14);
		contentPane.add(lblPidPadre);

		JLabel lblReultado = new JLabel("Resultado");
		lblReultado.setBounds(20, 306, 58, 14);
		contentPane.add(lblReultado);

		textoIzquierda = new JTextPane();
		textoIzquierda.setBackground(Color.WHITE);
		textoIzquierda.setBounds(88, 236, 206, 228);
		contentPane.add(textoIzquierda);

		textoDerecha = new JTextPane();
		textoDerecha.setBackground(Color.WHITE);
		textoDerecha.setBounds(301, 236, 206, 228);
		contentPane.add(textoDerecha);

		JLabel PIDProgram = new JLabel("");
		PIDProgram.setBounds(108, 166, 46, 14);
		contentPane.add(PIDProgram);

		JLabel PIDCmd = new JLabel("");
		PIDCmd.setBounds(237, 166, 46, 14);
		contentPane.add(PIDCmd);

		JLabel PIDLLamar5 = new JLabel("");
		PIDLLamar5.setBounds(333, 166, 174, 14);
		contentPane.add(PIDLLamar5);

		JLabel PadreProgram = new JLabel("");
		PadreProgram.setBounds(108, 208, 46, 14);
		contentPane.add(PadreProgram);

		JLabel Padrecmd = new JLabel("");
		Padrecmd.setBounds(237, 208, 46, 14);
		contentPane.add(Padrecmd);

		JLabel PadreLLamar5 = new JLabel("");
		PadreLLamar5.setBounds(376, 208, 46, 14);
		contentPane.add(PadreLLamar5);

		JButton btnEjecProgram = new JButton("START");
		btnEjecProgram.setBackground(Color.WHITE);
		btnEjecProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProcessBuilder pb = new ProcessBuilder("CMD", "/C", TextEjecProgram.getText());
				System.out.println(TextEjecProgram.getText());
				try {
					Process pro = pb.start();
					PIDProgram.setText("" + pro.pid());// pid
					PadreProgram.setText("" + pro.toHandle().parent().get().pid());// Version del padre
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnEjecProgram.setBounds(85, 121, 89, 23);
		contentPane.add(btnEjecProgram);

		JButton btnEjecCmd = new JButton("START");
		btnEjecCmd.setBackground(Color.WHITE);
		btnEjecCmd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String salida = null, acumulador = "";
				ProcessBuilder pb = new ProcessBuilder("CMD", "/C", TextEjecCmd.getText());
				try {
					Process pro = pb.start();
					PIDCmd.setText("" + pro.pid());// pid
					Padrecmd.setText("" + pro.toHandle().parent().get().pid());// Version del padre
					InputStreamReader entrada = new InputStreamReader(pro.getInputStream());
					BufferedReader BR = new BufferedReader(entrada);

					if ((salida = BR.readLine()) != null) {
						System.out.println("Comando ejecutado Correctamente");
						while ((salida = BR.readLine()) != null) {
							acumulador += (salida + "\n");
						}
						textoIzquierda.setText(acumulador);
					} else {
						System.out.println("No se a producido ninguna salida");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnEjecCmd.setBounds(216, 121, 89, 23);
		contentPane.add(btnEjecCmd);

		JButton btnLlamar5 = new JButton("START");
		btnLlamar5.setBackground(Color.WHITE);
		btnLlamar5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String acumulador = "", PID = "";
				ProcessBuilder pb = new ProcessBuilder("java",
						"E:\\DAM\\PSP\\pspdiario\\PSP\\ejer_procesos\\src\\main\\java\\procesos_completo\\Programa.java");
				pb.directory(new File("bin"));
				Process p = null;
				for (int x = 0; x < 5; x++) {
					try {
						p = pb.start();
						OutputStream os = p.getOutputStream();
						String dato = TextLlamar5.getText() + "\n";
						os.write(dato.getBytes());
						os.flush();
						InputStream is = p.getInputStream();
						InputStreamReader isr = new InputStreamReader(is);
						BufferedReader bf = new BufferedReader(isr);
						String c;
						PID += p.pid() + " ";// pid
						PadreLLamar5.setText("" + p.toHandle().parent().get().pid());// Version del padre
						while ((c = bf.readLine()) != null)
							acumulador += c;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				PIDLLamar5.setText(PID);
				textoDerecha.setText(acumulador);
			}
		});

		btnLlamar5.setBounds(352, 121, 89, 23);
		contentPane.add(btnLlamar5);

		TextEjecProgram = new JTextField();
		TextEjecProgram.setBounds(85, 81, 89, 20);
		contentPane.add(TextEjecProgram);
		TextEjecProgram.setColumns(10);

		TextEjecCmd = new JTextField();
		TextEjecCmd.setBounds(216, 81, 89, 20);
		contentPane.add(TextEjecCmd);
		TextEjecCmd.setColumns(10);

		TextLlamar5 = new JTextField();
		TextLlamar5.setColumns(10);
		TextLlamar5.setBounds(352, 81, 89, 20);
		contentPane.add(TextLlamar5);

	}
}
