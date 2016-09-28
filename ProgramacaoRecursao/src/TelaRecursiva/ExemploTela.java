package TelaRecursiva;
public class ExemploTela {

	public static void main(String[] args) {
		long t1 = 0;
	
		Tela tela = new Tela();
		tela.mudaCor(100, 0, 0);
		tela.limpar(tela.getCanvasWidth(),tela.getCanvasHeight());
		FractalQuadros.fazQuadro(tela);
		System.out.println(t1/10000);
	}


	}	
