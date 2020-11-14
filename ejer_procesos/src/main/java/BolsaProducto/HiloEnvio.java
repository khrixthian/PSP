package BolsaProducto;

import java.util.ArrayList;

public class HiloEnvio extends Thread {
	ArrayList<Producto> guardarProdcutos = new ArrayList<Producto>();
	private boolean aux = Bolsa.isLlena();
	private Bolsa bolsa;

	public HiloEnvio(Bolsa bolsa) {
		super();
		this.bolsa = bolsa;
		System.out.println("Soy el hilo de envio y empiezo");
	}

	@Override
	public void run() {
		guardarProdcutos = Bolsa.getListaproductos();
		if (guardarProdcutos.size() == 5) {
			System.out.println("Envio la bolsa.");
			System.out.println("Recorro la bolsa llena");
			for (int i = 0; i < guardarProdcutos.size(); i++) {
				System.out.println("Soy hilo envio y enseño el producto " + guardarProdcutos.get(i).getNombre());
			}
		} else
			System.out.println("error");
	}

}
