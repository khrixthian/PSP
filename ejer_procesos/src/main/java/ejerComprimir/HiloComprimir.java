package ejerComprimir;


public class HiloComprimir implements Runnable {
	//ZipFichero.zipIt("E:\\DESARROLLO DE APLICACIONES MULTIMEDIA\\2 ANYO\\PSP\\pspdiario\\PSP\\ejer_procesos\\src\\main\\java\\ejerComprimir\\ficheros\\comprimido.zip", "E:\\DESARROLLO DE APLICACIONES MULTIMEDIA\\2 ANYO\\PSP\\pspdiario\\PSP\\ejer_procesos\\src\\main\\java\\ejerComprimir\\Ejecutable.java");
	String rutadestino;
	String rutaobjeto;
	
	@Override
	public void run() {
		ZipFichero aux = new ZipFichero();
		aux.zipIt(rutadestino,rutaobjeto);
		
	}

	public HiloComprimir(String rutadestino, String rutaobjeto) {
		super();
		this.rutadestino = rutadestino;
		this.rutaobjeto = rutaobjeto;
	}

}
