package procesos_completo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ventana extends JFrame {

	private JPanel panel;
	private JButton boton1;	
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JButton boton3;
	JTextPane panel2;
	
	public ventana() {
		
		setSize(800, 600);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); 
		setLocationRelativeTo(null);
		
		boton1 = new JButton("Start");
		boton1.setBounds(80, 52, 100, 25);
		panel.add(boton1);
		
		tf1 = new JTextField();
		tf1.setBounds(80, 11, 130, 20);
		panel.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(284, 11, 138, 20);
		panel.add(tf2);
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setBounds(494, 11, 145, 20);
		panel.add(tf3);
		tf3.setColumns(10);
		
		JButton boton2 = new JButton("Start");
		boton2.setBounds(284, 53, 89, 23);
		panel.add(boton2);
		
		boton3 = new JButton("Start");
		boton3.setBounds(494, 53, 89, 23);
		panel.add(boton3);
		
		JLabel labelPid = new JLabel("PID");
		labelPid.setBounds(28, 110, 46, 14);
		panel.add(labelPid);
		
		JLabel labelPidPadre = new JLabel("PID Padre");
		labelPidPadre.setBounds(28, 153, 72, 14);
		panel.add(labelPidPadre);
		
		JLabel labelResul = new JLabel("Resultado:");
		labelResul.setBounds(28, 216, 72, 14);
		panel.add(labelResul);
		
		JTextPane panel1 = new JTextPane();
		panel1.setBounds(136, 216, 276, 308);
		panel.add(panel1);
		
		panel2 = new JTextPane();
		panel2.setBounds(444, 216, 297, 308);
		panel.add(panel2);
		
		JLabel resPid1 = new JLabel("");
		resPid1.setBounds(110, 110, 46, 14);
		panel.add(resPid1);
		
		JLabel resPidPadre1 = new JLabel("");
		resPidPadre1.setBounds(110, 153, 46, 14);
		panel.add(resPidPadre1);
		
		JLabel resPid2 = new JLabel("");
		resPid2.setBounds(284, 110, 46, 14);
		panel.add(resPid2);
		
		JLabel resPidPadre2 = new JLabel("");
		resPidPadre2.setBounds(284, 153, 46, 14);
		panel.add(resPidPadre2);
		
		JLabel resPid3 = new JLabel("");
		resPid3.setBounds(494, 110, 268, 14);
		panel.add(resPid3);
		
		JLabel resPidPadre3 = new JLabel("");
		resPidPadre3.setBounds(494, 153, 46, 14);
		panel.add(resPidPadre3);
	
	
	boton1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String prog = tf1.getText();
			ProcessBuilder pb = new ProcessBuilder(prog); 
			Process p;
			
			try {
				p = pb.start();
				
				resPid1.setText(String.valueOf(p.pid()));
				resPidPadre1.setText(String.valueOf(p.toHandle().parent().get().pid()));
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
	});
	
	boton3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e)  {
			String acum ="";
			ProcessBuilder pb = new ProcessBuilder("java", "E:\\DESARROLLO DE APLICACIONES MULTIMEDIA\\2 ANYO\\PSP\\pspdiario\\PSP\\ejer_procesos\\src\\main\\java\\procesos_completo\\Programa.java");
			pb.directory(new File("bin"));//importante poner esto que es donde estan los ejecutables de java
			Process p = null;	
			String pidaux ="";
			for (int x=0; x<5; x++) {
			try {
				p = pb.start();		
				OutputStream os = p.getOutputStream();
				String res = tf3.getText() + "\n";//importante el salto de linea
				os.write(res.getBytes());
				os.flush();
				
				InputStream is = p.getInputStream();
				
				pidaux += p.pid() + " ";
				resPidPadre3.setText(String.valueOf(p.toHandle().parent().get().pid()));
				resPid3.setText(pidaux);
				int c;
				while((c = is.read()) != -1) {
					acum +=(char) c;
				}
				
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			}
			
			panel2.setText(acum);
		}
	});
	
	boton2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			ProcessBuilder test = new ProcessBuilder("CMD", "/C", tf2.getText());
			
			String res = test.toString();
			String salida = null, acum = "";
			
			try {
				
				Process p = test.start();

				resPid2.setText(String.valueOf(p.pid()));
				resPidPadre2.setText(String.valueOf(p.toHandle().parent().get().pid()));
				
				InputStreamReader entrada = new InputStreamReader(p.getInputStream());
				BufferedReader BR = new BufferedReader(entrada);

				if((salida=BR.readLine()) != null){
		        	System.out.println("Comando ejecutado Correctamente");
		        	while ((salida=BR.readLine()) != null){
		        		acum+=(salida+"\n");	        		
		        	}
					
					panel1.setText(acum);
		        }else{
		        	System.out.println("No se a producido ninguna salida");
		        }			
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	});
}
	
	public static void main(String[] args) {
		new ventana();
		new ventana().setVisible(true);	
	}
}
