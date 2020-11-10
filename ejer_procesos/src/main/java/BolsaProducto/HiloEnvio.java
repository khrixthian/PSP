package BolsaProducto;

import java.util.ArrayList;

public class HiloEnvio extends Thread {
	ArrayList<Producto> bolsa = new ArrayList<Producto>();
	private boolean aux = Bolsa.isLlena();

	@Override
	public void run() {
		bolsa = Bolsa.getListaproductos();
		if (bolsa.size() == 5) {
			System.out.println("Envio la bolsa.");
			System.out.println("Recorro la bolsa llena");
			for (int i = 0; i < bolsa.size(); i++) {
				System.out.println("Soy hilo envio y enseño el producto " + bolsa.get(i).getNombre());
			}
		} else
			System.out.println("error");
	}

	public HiloEnvio() {
		System.out.println("Soy el hilo de envio y empiezo");
	}

}
