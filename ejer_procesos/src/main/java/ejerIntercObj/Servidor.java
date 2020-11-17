package ejerIntercObj;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	static final int PUERTO = 5000;
	private Persona persona;

	public Servidor() {
		ServerSocket skServidor;
		try {
			skServidor = new ServerSocket(PUERTO);
			Socket sk = skServidor.accept();// krea el obj cliente

			persona.setNif("16078123X");
			persona.setNombre("Periko");
			persona.setApellido("Durruti");
			persona.setFechaNacimiento("1/1/1990");
			persona.setGenero('M');
			// https://www.dokry.com/19380
			ObjectOutputStream paraEnviar = new ObjectOutputStream(sk.getOutputStream());
			paraEnviar.writeObject(persona);
			paraEnviar.flush();

			sk.close();
			skServidor.close();

		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}

	public static void main(String[] arg) {
		new Servidor();
	}
}
