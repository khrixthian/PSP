package BolsaProducto;

import java.util.ArrayList;

public class Bolsa {
	private ArrayList<Producto> listaproductos;
	private Producto prod = new Producto("producto");
	private int tamanyo = 0;
	private boolean estallena = false;

	public ArrayList<Producto> getListaproductos() {
		return listaproductos;
	}

	public void setListaproductos(ArrayList<Producto> listaproductos) {
		this.listaproductos = listaproductos;
	}

	public Producto getProd() {
		return prod;
	}

	public void setProd(Producto prod) {
		this.prod = prod;
	}

	public int getTamaño() {
		return tamanyo;
	}

	public void setTamaño(int tamaño) {
		this.tamanyo = tamaño;
	}

	public boolean isEstallena() {
		return estallena;
	}

	public void setEstallena(boolean estallena) {
		this.estallena = estallena;
	}

	public void addProducto(Producto prod) {
		for (int i = 1; i < 5; i++) {
			prod.setNombre("producto" + i);
			System.out.println("La bolsa tiene " + i + " productos.");
			listaproductos.add(prod);
		}
		System.out.println("La bolsa está llena.");
	}

	public void estaLlena() {
		if (listaproductos.size() == 5) {
			estallena = true;
		}
	}

	public void devtamanyo() {
		tamanyo = listaproductos.size();
	}

}
