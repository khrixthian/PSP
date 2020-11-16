package BolsaProducto;

public class Aplicacion {

	public static void main(String[] args) {
		Bolsa bolsa = new Bolsa();
		Thread hilo1 = new HiloRellena(bolsa);
		hilo1.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread hilo2 = new HiloEnvio(bolsa);
		hilo2.start();
	}

}
