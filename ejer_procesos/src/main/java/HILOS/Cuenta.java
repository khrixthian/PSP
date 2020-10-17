package HILOS;

public class Cuenta {

	private int saldo;
	
	public Cuenta(int saldo) {
		this.saldo = saldo;
	}
	
	public void restar(int cantidad) {
		saldo -= cantidad;
	}
	
	public synchronized void retirarDinero(int cantidad, String nombre) {
		
		if(saldo >= cantidad) {
			System.out.println("Se va a retirar saldo (Actual=" + saldo + ")");
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {}
			
			restar(cantidad);
			System.out.println(nombre + " retira " + cantidad + "(Actual=)" + saldo + ")");
		}else {
			System.out.println(nombre + " no puede retirar dinero (Actual=)" + saldo + ")");
		}
		}
	
}
