package EjercicioPrioridad;

public class HiloContador extends Thread {
	int prioridad = 5;
	boolean activo = true;

	public HiloContador(int prioridad) {
		super();
		this.prioridad = prioridad;
		this.activo = activo;
	}

	public void fin1Hilo(boolean activo) {
		this.activo = false;
	}

	public void cambioPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
}
