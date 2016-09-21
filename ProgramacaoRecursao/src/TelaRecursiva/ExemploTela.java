package TelaRecursiva;
public class ExemploTela {

	public static void main(String[] args) {
		
		Tela tela = new Tela();
		tela.mudaCor(100, 0, 0);
		tela.limpar(tela.getCanvasWidth(),tela.getCanvasHeight());
		FractalQuadros.fazQuadro(tela);

//		tela.desenhaLinha(0, 0, 100, 100);
//		tela.mudaCor(255, 255, 255);
//		tela.desenhaRetangulo(100, 80, 200, 20);
	}	
}