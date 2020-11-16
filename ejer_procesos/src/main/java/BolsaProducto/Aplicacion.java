package BolsaProducto;

public class Aplicacion {

	public static void main(String[] args) {
		Bolsa bolsa = new Bolsa();
		Thread hilo1 = new HiloRellena(bolsa);
		Thread hilo2 = new HiloEnvio(bolsa);
		hilo1.start();
		hilo2.start();
	}

}
