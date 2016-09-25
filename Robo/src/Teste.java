public class Teste {

	public static void main(String[] args) {
		Display d1 = new Display1();
		Display d2 = new Display2();
		Robo r = new Robo("R2D2");
		r.cumprimentar(d1);
		r.cumprimentar(d2);

	}

}