package BolsaProducto;

import java.util.ArrayList;

public class Bolsa {
	private static ArrayList<Producto> listaproductos;
	private int tamanyo;
	private static boolean llena = false;

	public Bolsa() {
		super();
	}

	public static ArrayList<Producto> getListaproductos() {
		return listaproductos;
	}

	public void setListaproductos(ArrayList<Producto> listaproductos) {
		this.listaproductos = listaproductos;
	}

	public int getTamanyo() {
		return tamanyo;
	}

	public void setTamanyo(int tamanyo) {
		this.tamanyo = tamanyo;
	}

	public static boolean isLlena() {
		return llena;
	}

	public void setLlena(boolean llena) {
		this.llena = llena;
	}

	public void estaLlena() throws InterruptedException {
		if (this.isLlena() == true) {
			this.tamanyo = 5;
			listaproductos = HiloRellena.devBolsa();
			this.notify();
		}

	}
}
