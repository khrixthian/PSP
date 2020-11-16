package BolsaProducto;

import java.util.ArrayList;

public class HiloRellena extends Thread {
	private Bolsa bolsa;
	private static ArrayList<Producto> listaproductos = new ArrayList<Producto>();
	private Producto prod;

	public HiloRellena(Bolsa bolsa) {
		super();
		this.bolsa = bolsa;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			prod = new Producto("producto");
			prod.setNombre("producto " + i);
			System.out.println("La bolsa tiene " + (i + 1) + " productos. Y su nombre es: " + prod.getNombre());
			// bolsa.anyadirProducto(prod);
			listaproductos.add(prod);
		}
		System.out.println("La bolsa está llena.");
		try {
			bolsa.setListaproductos(listaproductos);
		} catch (InterruptedException e) {
		}
		bolsa.setTamanyo(5);
		bolsa.setLlena(true);
	}

	public ArrayList<Producto> enviarArray() {
		return listaproductos;
	}
}
