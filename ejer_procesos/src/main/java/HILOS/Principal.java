package HILOS;

public class Principal {

	public static void main(String[] args) throws InterruptedException {

		MiThread1 t1 = new MiThread1();
		//t1.start();//para iniciar la clase MiThread, tb se puede iniciar desde la misma clase
		System.out.println("Principal");
		System.out.println(t1.getName());
		t1.setName("OtroNombre");
		System.out.println(t1.getName());
		//ver la prioridad de un hilo
		System.out.println("prioridad: " + t1.getPriority());
		//variar la prioridad
		t1.setPriority(t1.MAX_PRIORITY);
		System.out.println("prioridadMax: " + t1.getPriority());
		t1.setPriority(t1.MIN_PRIORITY);
		System.out.println("prioridadMin: " + t1.getPriority());

		t1.sleep(55555555);
		t1.join();//no veo lo que hace
	}

}
