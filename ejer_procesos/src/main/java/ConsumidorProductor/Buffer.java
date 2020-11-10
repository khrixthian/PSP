package ConsumidorProductor;

public class Buffer {
	boolean bufferLleno;
	char contenido;

	public synchronized void poner(char c) throws InterruptedException {
		while (this.bufferLleno == true) {
			this.wait();
		}
		this.contenido = c;
		this.bufferLleno = true;
		this.notify();
	}

	public synchronized char recoger() throws InterruptedException {

		while (this.bufferLleno == false) {
			this.wait();
		}
		bufferLleno = false;
		this.notify();
		return (this.contenido);

	}

//	public boolean estaLlena() throws InterruptedException {
//		while (bufferLleno = true) {
//			return true;
//		}
//		return false;
//	}
}
