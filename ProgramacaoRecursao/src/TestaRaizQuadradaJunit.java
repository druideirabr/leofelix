import static org.junit.Assert.*;

import org.junit.Test;

public class TestaRaizQuadradaJunit {
	private static final double ERRO = 0.001;
	private static final int N_TESTES = 1000;

	@Test
	public void testConstrutor() {
		RaizQuadrada rq = new RaizQuadrada(0.1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorParamInval() {
		RaizQuadrada rq = new RaizQuadrada(-0.1);
	}

	@Test
	public void testCalculaRaiz() {
		RaizQuadrada rq = new RaizQuadrada(0.001);
		for (int i=0; i<N_TESTES; i++) {
			double y = 10000*Math.random();
			double res = rq.calculaRaiz(y);
			assertTrue("y="+y+", res="+res,
					   Math.abs(y-res*res) < ERRO);
		}
	}

}