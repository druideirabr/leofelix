public class ArrayStats {

	public static int soma(int[] valores) {
		if (valores == null)
			throw new ArrayVazioException();
		int soma = 0;
		for (int i = 0; i < valores.length; i++) {
			soma += valores[i];
		}
		return soma;
	}

	public static int contar(int[] valores, int valor) {
		if(valores == null) throw new ArrayVazioException();
		int cont = 0;
		for (int i = 0; i < valores.length; i++) {
			if (valor == valores[i]) {
				cont++;
			}
		}
		return cont;
	}
}