
public class PesquisaArray {

	public static void main(String[] args) {
		int[][] a = new int[500][500];
		int cont = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = cont;
				cont += 5;

			}
		}
		pesquisaBinaria(a, 1000010);

	}

	public static void pesquisaBinaria(int[][] a, int arg) {
		int inf = 0;
		int sup = (a.length * a[a.length - 1].length) - 1;
		int med = (sup + inf) / 2;

		try {
			while (inf <= sup) {
				if (arg == a[med / (a[0].length)][med % (a[0].length)]) {
					System.out.println(med / (a[0].length) + "  " + (med % (a[0].length)));
					inf = sup + 1;
				} else if (arg < a[(med / a[0].length)][med % (a[0].length)]) {
					sup = med - 1;
					med = (sup + inf) / 2;
				} else if (arg > a[med / (a[0].length)][med % (a[0].length)]) {
					inf = med + 1;
					med = (sup + inf) / 2;
				}
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Valor inexistente no array");


		}
	}
}
