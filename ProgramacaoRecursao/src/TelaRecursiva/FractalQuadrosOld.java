package TelaRecursiva;

public class FractalQuadrosOld {
	public static void fazQuadro(Tela a) {

		fazQuadro(a, 0, 0, a.getCanvasWidth(), a.getCanvasHeight(), 1);
	}

	private static void fazQuadro(Tela a, int dHoriz, int dVert, int x2, int y2, int quadrante) {
		if (x2 > a.getCanvasWidth() / 32) {
			if (quadrante == 1) {
				a.mudaCor(100, 0, 0);
				a.desenhaRetangulo(dHoriz, dVert, x2 / 2, y2 / 2);
				fazQuadro(a, dHoriz, dVert, x2, y2, ++quadrante);
			}
			if (quadrante == 2) {
				a.mudaCor(0, 100, 0);
				a.desenhaRetangulo(dHoriz + x2 / 2, dVert, x2 / 2, y2 / 2);
				fazQuadro(a, dHoriz, dVert, x2, y2, ++quadrante);
			}
			if (quadrante == 3) {
				a.mudaCor(100, 0, 0);
				a.desenhaRetangulo(dHoriz + x2 / 2, dVert + y2 / 2, x2 / 2, y2 / 2);
				fazQuadro(a, dHoriz, dVert, x2, y2, ++quadrante);
			}
			if (quadrante == 4) {
				a.mudaCor(0, 100, 0);
				a.desenhaRetangulo(dHoriz, dVert + y2 / 2, x2 / 2, y2 / 2);
				a.mudaCor(100, 0, 0);
				a.desenhaRetangulo(dHoriz, dVert, x2 / 2, y2 / 2);
				fazQuadro(a, dHoriz + x2 / 2 + 1, dVert + 1, x2 / 2 - 2, y2 / 2 - 2, 1);
				fazQuadro(a, dHoriz + 1, dVert + y2 / 2 + 1, x2 / 2 - 2, y2 / 2 - 2, 3);
			}

		}

	}
}
