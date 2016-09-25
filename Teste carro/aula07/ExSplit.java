package aula07;

public class ExSplit {

	public static void main(String[] args) {
		String linha = "Hoje é quarta-feira.";
		String[] partes = linha.split(" ");
		System.out.println(partes.length);
		System.out.println(partes[0]);
		System.out.println(partes[1]);
		System.out.println(partes[2]);
	}

}
