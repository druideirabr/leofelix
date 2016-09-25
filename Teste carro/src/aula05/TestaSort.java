package aula05;

import java.util.Arrays;

public class TestaSort {

	public static void main(String[] args) {
		Veiculo[] v = {
				new Veiculo("HBC-1234", "preto", "fusca", 4, 4, 19.3, 0.1),
				new Veiculo("HBC-2234", "azul", "gol", 4, 4, 539.45, 0.08),
				new Veiculo("JBC-1234", "amarelo", "troller", 4, 4, 237.12, 0.2),
				new Veiculo("HBC-3534", "vermelho", "bmw", 4, 4, 128.99, 0.15),
				new Veiculo("XKC-1234", "verde", "palio", 4, 4, 85.67, 0.08) };

		Arrays.sort(v);		
		for (int i=0; i<v.length; i++) { System.out.println(v[i]);	}
		System.out.println("-----");
		
		Arrays.sort(v, new ComparadorVeiculoPorPlaca());		
		for (int i=0; i<v.length; i++) { System.out.println(v[i]);	}
		System.out.println("-----");
		
		Arrays.sort(v, new ComparadorVeiculoPorModelo());		
		for (int i=0; i<v.length; i++) { System.out.println(v[i]);	}
		System.out.println("-----");

	}

}
