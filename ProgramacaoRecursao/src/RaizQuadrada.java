
public class RaizQuadrada {
	public double margem;

	public RaizQuadrada(double margem) {
		this.margem = margem;

	}

	public double calculaRaiz(double valor) {
		double sup = valor;
		double inf = 0;
		double med = (sup + inf) / 2;
		while (Math.abs(valor-med*med) > margem) {
		 if (Math.pow(med, 2) > valor && Math.abs(valor-med*med) > margem ) {
			sup = med;
			med = (sup + inf) / 2;
	
		} else if (Math.pow(med, 2) < valor && Math.abs(valor-med*med) > margem ) {
			inf = med;
			med = (sup + inf) / 2;

		}
	
	}
		return med;
}
	public double calculaRaizRec(double valor){
		if (valor < 0){
			throw new NumberFormatException("Raiz quadrada de número negativo. IMPOSSIBRU");
		} return calculaRaizRec (valor,valor,0);
		}

	private double calculaRaizRec(double valor,double sup, double inf) {
		double med = (sup + inf) / 2;
		if (Math.pow(med, 2) > valor && Math.abs(valor-med*med) > margem ) {
			sup = med;
		return calculaRaizRec(valor,sup, inf);
	}
		else if (Math.pow(med, 2) < valor && Math.abs(valor-med*med) > margem ) {
			inf = med;
			return calculaRaizRec(valor, sup,inf);
		} return med;
	}
}