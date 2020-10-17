package HILOS;

public class RunClass implements Runnable {

	@Override
	public void run() {
		System.out.println("hilo creado. Contar");
		for (int x=1; x<=10; x++) {
			System.out.print(x + " ");
		
	}

}
}