package ConsumidorProductor;

public class Aplicacion {

	public static void main(String[] args) throws InterruptedException {
		Buffer b = new Buffer();
		Consumidor con = new Consumidor(b);
		Productor prod = new Productor(b);
		prod.start();
		Thread.sleep(1000);
		con.start();
	}

}
