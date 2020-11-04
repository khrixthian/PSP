package ConsumidorProductor;

public class Buffer {
	boolean bufferLleno;
	char contenido;
	boolean lleno;

	public synchronized void poner(char c) {
		this.contenido = c;
		this.bufferLleno = true;
	}

	public synchronized char recoger() throws InterruptedException {
		while (this.bufferLleno == true) {
			bufferLleno = false;
			this.notify();
			return this.contenido;
		}
		return (36);

	}

	public boolean estaLlena() throws InterruptedException {
		while (bufferLleno = true) {
			this.notify();
			return true;
		}
		this.wait();
		return false;
	}
}
