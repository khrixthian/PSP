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
			try {
				bProd.poner(letra);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.print("Prod: " + letra + " ");

		}
	}
}
