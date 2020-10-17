package HILOS;

public class PpalRunClass {

	public static void main(String[] args) {

		RunClass r1 = new RunClass();
		//2 lineas de abajo tb se puede hacer desde el constructor de la clase RunClass
		Thread t2 = new Thread(r1);// hay que pasar el anterior por aki
		t2.start();
		System.out.println("desde el ppal");
		/*
		 * ¿Qué sucederá si en vez de invocar al método
	start invocamos directamente al método run?

	Que el programa será secuencial y los métodos run de
	cada hilo se ejecutarán secuencialmente en el orden
	que fueron invocados.
	
	si comento la linea t2.start(); solo se ejecuta lo ke hay en el main
		 */

	}

}
