package BolsaProducto;

import java.util.ArrayList;

public class HiloRellena extends Thread {
	private static Bolsa bolsa;
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
			System.out.println("La bolsa tiene " + (i + 1) + " productos.");
			listaproductos.add(prod);
		}
		System.out.println("La bolsa está llena.");
		if (listaproductos.size() == 5) {
			bolsa.setListaproductos(listaproductos);
			bolsa.setTamanyo(5);
			bolsa.setLlena(true);
			// this.notify();// esto tiene que estar en la bolsa
		}
	}

	public static ArrayList<Producto> devBolsa() {
		return listaproductos;
	}
}
