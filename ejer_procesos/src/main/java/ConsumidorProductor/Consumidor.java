package ConsumidorProductor;

public class Consumidor extends Thread {
	private Buffer bConsum;

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			char x;
			try {
				x = bConsum.recoger();
				System.out.print("Cons: " + x + " ");
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Consumidor(Buffer b) {
		this.bConsum = b;
	}

}
