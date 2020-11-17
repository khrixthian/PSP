package ejerIntercObj;

import java.io.ObjectInputStream;
import java.net.Socket;

public class Cliente {
	static final String HOST = "localhost";
	static final int PUERTO = 5000;
	private Persona persona = new Persona();

	public Cliente() {
		try {
			Socket skCliente = new Socket(HOST, PUERTO);
			ObjectInputStream ois = new ObjectInputStream(skCliente.getInputStream());
			System.out.println(ois.readObject());
			persona = (Persona) ois.readObject();
			persona.setNombre("Makno");
			persona.setFechaNacimiento("2/2/2000");
			skCliente.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		new Cliente();
	}

}
