public class TestaRaizQuadrada {
	private static final double ERRO = 0.001;
	private static final int N_TESTES = 1000;
	
	public static void main(String[] args) {
		RaizQuadrada rq = new RaizQuadrada(ERRO);
		
		for (int i=0; i<N_TESTES; i++) {
			double x = 10000*Math.random();
			
			double res = rq.calculaRaizRec(x);
			System.out.println("\nValor Obtido: "+res*res + "\nValor Real:"+x);

			// testar res n�o � aceit�vel e abortar a execu��o
			//if ( res*res > x+ERRO || res*res < x-ERRO) {
			if ( Math.abs(x - res*res) > ERRO) {
				System.out.println("Teste falhou: x="+x+", res="+res);
				System.exit(1);				
			}
		}
		System.out.println("Tudo parece funcionar!");
	}
}