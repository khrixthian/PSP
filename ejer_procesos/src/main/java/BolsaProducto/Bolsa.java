package BolsaProducto;

import java.util.ArrayList;

public class Bolsa {
	private ArrayList<Producto> listaproductos;
	private int tamanyo;
	private static boolean llena = false;

	public Bolsa() {

		super();
	}

	public ArrayList<Producto> getListaproductos() throws InterruptedException {
		llena = false;
		return listaproductos;
	}

	public void anyadirProducto(Producto prod) {
		listaproductos.add(prod);
	}

	public synchronized void setListaproductos(ArrayList<Producto> listaproductos) {
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

	public Boolean estaLlena() throws InterruptedException {
		while (llena == true) {
			//this.wait();
			tamanyo = 5;
			llena = true;
			return llena;
		}
		llena = false;
		return llena;

	}
}
