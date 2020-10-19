package HiloThread;

public class KlaseHiloThread extends Thread{
	
	public KlaseHiloThread() {
		
		this.start();
		
	}
	
	public void run() {
		System.out.println("saludos desde la klase.");
	}

}
