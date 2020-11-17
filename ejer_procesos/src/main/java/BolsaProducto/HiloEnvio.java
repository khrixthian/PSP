package BolsaProducto;

import java.util.ArrayList;

public class HiloEnvio extends Thread {
	ArrayList<Producto> guardarProductos = new ArrayList<Producto>();
	private Bolsa bolsa = new Bolsa();
	private boolean aux = bolsa.isLlena();

	public HiloEnvio(Bolsa bolsa) {
		super();
		this.bolsa = bolsa;
		System.out.println("Soy el hilo de envio y empiezo");
	}

	@Override
	public void run() {

		// para que lo haga de continuo:
		while (true) {
			// las acciones

			try {
				guardarProductos = bolsa.getListaproductos();
			} catch (InterruptedException e) {
				// TODO Bloque catch generado autom�ticamente
				e.printStackTrace();
			}

			if (guardarProductos.size() == 5) {
				System.out.println("Recibo la bolsa.");
				System.out.println("Recorro la bolsa llena");
				for (int i = 0; i < guardarProductos.size(); i++) {
					System.out.println(
							"Soy hilo envio y ense�o el producto " + i + ": " + guardarProductos.get(i).getNombre());
				}
			} else
				System.out.println("error");
		}
	}

}
