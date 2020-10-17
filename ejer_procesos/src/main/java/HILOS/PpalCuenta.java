package HILOS;

public class PpalCuenta {

	public static void main(String[] args) {

		Cuenta c = new Cuenta(40);
		Persona p1 = new Persona(c, "Maria");
		Persona p2 = new Persona(c, "Juana");
		
		p1.start();
		p2.start();
	}

}
/* A MI ME EJECUTA ESTO NO LO QUE DICE EN EL PDF 2.5
 * Se va a retirar saldo (Actual=40)
Maria retira 10(Actual=)30)
Se va a retirar saldo (Actual=30)
Maria retira 10(Actual=)20)
Se va a retirar saldo (Actual=20)
Maria retira 10(Actual=)10)
Se va a retirar saldo (Actual=10)
Maria retira 10(Actual=)0)
Juana no puede retirar dinero (Actual=)0)
Juana no puede retirar dinero (Actual=)0)
Juana no puede retirar dinero (Actual=)0)
Juana no puede retirar dinero (Actual=)0)
 */

//EL PDF 2.7 NO LO ENTIENDO MUY BIEN