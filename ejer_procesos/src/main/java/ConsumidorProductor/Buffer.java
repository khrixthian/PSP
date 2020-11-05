package ConsumidorProductor;

public class Buffer {
	boolean bufferLleno;
	char contenido;
	boolean lleno;

	public synchronized void poner(char c) {
		this.contenido = c;
		this.bufferLleno = true;
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}

	public synchronized char recoger() throws InterruptedException {

		while (this.bufferLleno == true) {
			this.notify();
			bufferLleno = false;
			return this.contenido;
		}
		return (36);

	}

	public boolean estaLlena() throws InterruptedException {
		while (bufferLleno = true) {
			return true;
		}
		return false;
	}
}
