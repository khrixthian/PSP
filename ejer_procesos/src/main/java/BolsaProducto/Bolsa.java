package BolsaProducto;

import java.util.ArrayList;

public class Bolsa {
	private ArrayList<Producto> listaproductos;
	private int tamanyo;
	private boolean llena = false;

	public Bolsa() {

		super();
	}

	public synchronized ArrayList<Producto> getListaproductos() throws InterruptedException {
		while (this.llena == false) {
			this.wait();
		}
		this.llena = false;
		this.notify();
		return listaproductos;
	}

	public void anyadirProducto(Producto prod) {
		listaproductos.add(prod);
	}

	public synchronized void setListaproductos(ArrayList<Producto> listaproductos) throws InterruptedException {
		while (this.llena == true) {
			this.wait();
		}
		this.listaproductos = listaproductos;
		this.llena = true;
		this.notify();
	}

	public int getTamanyo() {
		return tamanyo;
	}

	public void setTamanyo(int tamanyo) {
		this.tamanyo = tamanyo;
	}

	public boolean isLlena() {
		return llena;
	}

	public void setLlena(boolean llena) {
		this.llena = llena;
	}

	public Boolean estaLlena() throws InterruptedException {
		while (llena == true) {
			// this.wait();
			tamanyo = 5;
			llena = true;
			return llena;
		}
		llena = false;
		return llena;

	}
}
