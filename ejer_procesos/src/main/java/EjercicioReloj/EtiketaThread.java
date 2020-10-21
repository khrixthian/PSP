package EjercicioReloj;

import java.awt.Color;
import java.util.Random;

import javax.swing.JLabel;

public class EtiketaThread implements Runnable{
	
	JLabel Etiketa = new JLabel();
	Color colorinicial = new Color(0,0,0);
	
	@Override
	public void run() {

		 int aux =0;
		this.Etiketa.setForeground(colorinicial);
		
		do {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				Random rand = new Random(); 
				float r = rand.nextFloat();
				float g = rand.nextFloat(); 
				float b = rand.nextFloat();
				
				Color color = new Color(r,g,b);
				
				this.Etiketa.setForeground(color);

			
		}while(aux == 0);
		
		
	}

	public EtiketaThread(JLabel etiketa) {
		super();
		this.Etiketa = etiketa;
	}
}
