// os exercícios que foram feito no testezinho eu não refiz (1,2,4,5,7,8,9
public class TestaArray {

	public static void main(String[] args) {
		double[][] d = new double[17][34];
		preencheMatrizRandom(d);
		System.out.println(recebeMatrizBidimensionalDoubleRetornaStringDela(d));


	}
	/* exercício 3 */
//	Teclado t = new Teclado();
//	double[][] matriz2por5 = new double[2][5];
//	for (int i = 0; i < matriz2por5.length; i++) {
//		for (int j = 0; j < matriz2por5[i].length; j++) {
//			matriz2por5[i][j] = t.leDouble("Insira um número aqui: ");
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

	// método criado só pra preencher os números no array instanciado; Também é o exercicio 2.
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
			a[i] = t.leInt("Números vão aqui, de preferência");
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

