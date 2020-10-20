package EjercicioReloj;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class VentanaContadorReloj extends JFrame{
	
	private JPanel contentPane;
	private Thread t1 = new Thread();
	private Thread t2 = new Thread();
	boolean SalirPresionado = false;
	boolean IniciarOk = false;
	
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
		adelante.setBounds(429, 66, 115, 61);
		contentPane.add(adelante);
		
		JLabel reloj = new JLabel("00:00");
		reloj.setFont(new Font("Tahoma", Font.PLAIN, 46));
		reloj.setBounds(128, 66, 308, 61);
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
		
		//Cambiar el color de las flechas cada 2 segundos mientras no se de a salir
		//solo lo cambia una vez y cuando salta la ventana ya viene cambiado el color de la 1 label
		do {
			EtiketaThread ColorR1 = new EtiketaThread(atras);
			EtiketaThread ColorR2 = new EtiketaThread(adelante);				
			Thread Colort1 = new Thread(ColorR1);
			Thread Colort2 = new Thread(ColorR2);
			Colort1.setPriority(Colort1.MIN_PRIORITY);
			Colort2.setPriority(Colort2.MIN_PRIORITY);
				
				try {
					Thread.sleep(2000);
					Colort1.start();
					Thread.sleep(2000);
					Colort2.start();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}while(SalirPresionado = false);
		
		iniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				pausar.setVisible(true);
				parar.setVisible(true);
				reiniciar.setVisible(true);
				String aux = reloj.getText();
				char[] caracteres = aux.toCharArray();
				int seg = 1;
				int aumseg=1;
				int cero= 0;
				int aunmin=1;
				int aunmin2=1;
				for (int i=0; i<100;i++) {
					
						caracteres[4]=(char) seg;
						seg += 1;
						//Thread.sleep(1000);
						if(caracteres[4]>9) {
							caracteres[3]=(char) aumseg;
							caracteres[4]= (char) cero;
							seg=0;
							aumseg +=1;
							reloj.setText(String.valueOf(caracteres));
							System.out.println("en el 1 if: " + caracteres[3] + " " + caracteres[4]);
							if(caracteres[3]>5) {
								caracteres[1]= (char) aunmin;
								caracteres[3]= (char) cero;
								aumseg=0;
								aunmin +=1;
								reloj.setText(String.valueOf(caracteres));
								System.out.println("en el 2 if: " + caracteres[1] + " " + caracteres[3]);
								if(caracteres[1]>9) {
									caracteres[0]= (char)aunmin2;
									caracteres[1]= (char) cero;
									aunmin2 +=1;
									reloj.setText(String.valueOf(caracteres));
									System.out.println("en el 3 if: " + caracteres[0] + " " + caracteres[1]);
								}//3if
							}//2if
						}//1if
						
						//reloj.setText(String.valueOf(caracteres));	
					
				}
			}//fin void

		});//fin boton
		
		pausar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}

		});//fin boton
		
		parar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}

		});//fin boton
		
		reiniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}

		});//fin boton
		
		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SalirPresionado = true;
				System.exit(0);
			}

		});//fin boton
	}
	
	
}
