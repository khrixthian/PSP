package ejerComprimir;

public class Ejecutable {
	static String rutadestino;
	static String rutaobjeto;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZipFichero.zipIt(rutadestino, rutaobjeto);
		//el 1 parametos es como y donde se va llamar/guardar el fichero comprimido y el 2 es lo que va a comprimir
	}

}
