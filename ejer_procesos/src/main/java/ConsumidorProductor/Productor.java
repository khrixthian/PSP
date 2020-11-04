package ConsumidorProductor;

public class Productor extends Thread {
	private Buffer bProd;

	public Productor(Buffer bProd) {
		super();
		this.bProd = bProd;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			int x = (int) ((Math.random() * (97 - 122)) + 97);
			char letra = (char) (x);
			bProd.poner(letra);
			System.out.print("Prod: " + letra + " ");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
