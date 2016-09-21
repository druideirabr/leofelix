package Formatacao;

public class IntegerFormat {
	static final char[] DIGITOS = "0123456789ABCDEFGHIJ".toCharArray();

	public static String format(int base, int valor) {
		if (base == 1) return String.valueOf(valor);
		char[] digitos;
		String resultado = "";
		digitos = new char[base];
		char c = '0';
		for (int i = 0; i < digitos.length; c++) {
			if (c >= '0' && c <= '9' || c >= 'A' && c <= 'Z') {
				digitos[i] = c;
				i++;
			}
		}
		while (valor >0){
		resultado += digitos[valor%base];
		valor = valor/base;
		}
		resultado = new StringBuilder(resultado).reverse().toString();
		return resultado;	
		}
	public static String formatRec(int base, int valor){
		if (base == 1) return String.valueOf(valor);
		return formatRec(base, valor, "");
	}
	private static String formatRec(int base, int valor, String resultado){
		if (valor == 0) {
			resultado = new StringBuilder(resultado).reverse().toString();
			return resultado;
		}
			resultado += DIGITOS[valor%base];
			return formatRec(base,valor/base,resultado);
		}
		
	}
	


// x ← valor da base de representação
// digitos ← [ array contendo os dígitos (caracteres) de 0 a x-1 ]
// n ← valor inteiro a ser a se representado na base X
// resultado ← “” // string vazio
// repetir:
// i ← resto da divisão de n por x
// resultado ← concatenacao(digitos[i],resultado)
// n ← quociente da divisao de n por x
// enquanto (n>0)
// retornar resultado
