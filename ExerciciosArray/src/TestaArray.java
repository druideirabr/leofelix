// os exerc�cios que foram feito no testezinho eu n�o refiz (1,2,4,5,7,8,9
public class TestaArray {

	public static void main(String[] args) {
		double[][] d = new double[17][34];
		preencheMatrizRandom(d);
		System.out.println(recebeMatrizBidimensionalDoubleRetornaStringDela(d));


	}
	/* exerc�cio 3 */
//	Teclado t = new Teclado();
//	double[][] matriz2por5 = new double[2][5];
//	for (int i = 0; i < matriz2por5.length; i++) {
//		for (int j = 0; j < matriz2por5[i].length; j++) {
//			matriz2por5[i][j] = t.leDouble("Insira um n�mero aqui: ");
//		}
//	}

	// exercicio 6
	public static String recebeMatrizBidimensionalDoubleRetornaStringDela(double[][] a) {
		String ret = "";
		for (int i = 0; i < a.length; i++) {
			ret += "\n";
			for (int j = 0; j < a[i].length; j++) {
				ret += "|" + a[i][j] + " |";
			}
		}
		return ret;
	}

	// m�todo criado s� pra preencher os n�meros no array instanciado; Tamb�m � o exercicio 2.
	private static void preencheMatrizRandom(double[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = (int) (Math.random() * 100) ;
			}
		}
	}
	//exercicio 10
	public static int[] retornaMatrizLidaDoTeclado(){
		Teclado t = new Teclado();
		int a[] = new int[t.leInt("Insira o tamanho da matriz aqui: ")];
		for (int i = 0;i< a.length;i++){
			a[i] = t.leInt("N�meros v�o aqui, de prefer�ncia");
		}
		return a;
	}
	//exercicio 11
	public static void mudaPraUmOuMenosUm(int[]a){
		for (int i = 0;i <a.length;i++){
		if (a[i] < 0) throw new NumberFormatException();
		}
			for (int i = 0;i<a.length;i++){
				if (a[i]%2 == 0){
					a[i] = 1;
				}
					else a[i] = -1;
		}
		}
		
	}

