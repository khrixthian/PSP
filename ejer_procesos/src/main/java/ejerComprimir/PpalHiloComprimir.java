package ejerComprimir;

public class PpalHiloComprimir {

	public static void main(String[] args) {
		String rutadestino = "E:\\DAM\\PSP\\pspdiario\\PSP\\ejer_procesos\\src\\main\\java\\ejerComprimir\\ficheros\\comprimido.zip";
		String rutaobjeto = "E:\\DAM\\PSP\\pspdiario\\PSP\\ejer_procesos\\src\\main\\java\\ejerComprimir\\Ejecutable.java";

		HiloComprimir h1 = new HiloComprimir(rutadestino, rutaobjeto);
		Thread t1 = new Thread(h1);
		t1.start();
		while (t1.isAlive()) {
			System.out.println("El hilo esta vivo");
		}
		System.out.println("El hilo ha terminado");
	}

}
