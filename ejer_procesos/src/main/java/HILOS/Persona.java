package HILOS;

public class Persona extends Thread {
	
	private Cuenta c;
	String nombre;
	
	public Persona(Cuenta c, String nombre) {
		
		this.c = c;
		this.nombre = nombre;
	}
	
	public void run() {
		
		for(int i=0; i<4; i++) {
			c.retirarDinero(10, nombre);
		}
	}
}


