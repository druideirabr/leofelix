package TelaRecursiva;

public class FractalQuadros {

	public static void fazQuadro(Tela a) {
		a.mudaCor(0, 100, 0);
		fazQuadro(a, 0, 0, a.getCanvasWidth(), a.getCanvasHeight());
	}
	private static void fazQuadro(Tela a, int dHoriz, int dVert, int x2, int y2) {
		if (x2 <= a.getCanvasWidth()/16){
			a.getOsg().fillRect(dHoriz+x2/2+1, dVert+1, x2/2-1, y2/2-1);
			a.getOsg().fillRect(dHoriz+1, dVert+y2/2+1, x2/2-1, y2/2-1);
		}
		if (x2 > a.getCanvasWidth() / 32) {
			a.desenhaRetangulo(dHoriz + x2 / 2, dVert, x2 / 2, y2 / 2);
			a.desenhaRetangulo(dHoriz, dVert + y2 / 2, x2 / 2, y2 / 2);
			fazQuadro(a, dHoriz + x2 / 2 + 1, dVert + 1, x2 / 2 - 1, y2 / 2 - 1);
			fazQuadro(a, dHoriz + 1, dVert + y2 / 2 + 1, x2 / 2 - 1, y2 / 2 - 1);
		}
	}
}
