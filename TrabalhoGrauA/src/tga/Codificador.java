package tga;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Codificador implements HMEncoder {

	public String[][] arrayPalavras;

	public void load(File baseText) { // no metodo de getbaseText
		// cria um arrayList e vai adicionando as linhas na lista conforme vai
		// lendo;

		ArrayList<String[]> arrayListPalavras = new ArrayList<String[]>();
		String linha;
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(baseText));
			// come�a a ler o arquivo
			while ((linha = in.readLine()) != null) {
				// adiciona no arrayList de arrays de Strings
				arrayListPalavras.add(linha.split(" "));
			}
			// converte do arrayList de array de strings para um array
			// bidimensional
			arrayPalavras = (String[][]) arrayListPalavras.toArray();
			SortArray2D(arrayPalavras);

		} catch (IOException e) {// mudar pra metodo mais especifico
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {// mudar pra metodo mais especifico
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

	@Override
	public File getBaseText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IndexedWord lookup(String word) {
		// se a palavra n for um espa�o ou nula, chama o m�todo privado de
		// procurar pela palavra

		return lookup(word, 0, arrayPalavras.length, 0, 0);

	}

	private IndexedWord lookup(String word, int inf, int sup, int infLinha, int supLinha) {
		//n�o utilizei o m�todo padr�o de pesquisa bin�ria pq como eu extrai o array de um
		//arraylist, ent�o o tamanho das colunas nao � padr�o, vai depender do tamanho da frase.
		int med = (sup + inf) / 2;
		int medLinha = (supLinha + infLinha) / 2;
		//vai procurar no primeiro elemento das linhas
		// se o elemento requisitado vier depois do elemento [med][0], o inf vai ser acrescentado.
		//o m�todo sempre olha a pr�xima linha pra ver se j� n�o est� na linha certa
		if (arrayPalavras[med][0].compareToIgnoreCase(word) < 0
				&& arrayPalavras[med + 1][0].compareToIgnoreCase(word) < 0) {
			lookup(word, (inf = med + 1), sup, infLinha, supLinha);
			// se o elemento requisitado vier antes da linha que o med est�, o sup vai ser decrescido
		} else if (arrayPalavras[med][0].compareToIgnoreCase(word) > 0) {
			lookup(word, inf, sup = med - 1, infLinha, supLinha);
		}
		//se o primeiro elemento da linha em que procuro for menor do que o elemento que o procuro
		//e o primeiro elemento da pr�xima linha for maior, isso significa que o med est� na linha certa
		// ent�o mant�m se o med e se come�a a procurar na linha
		if (arrayPalavras[med][0].compareToIgnoreCase(word) < 0
				&& arrayPalavras[med + 1][0].compareToIgnoreCase(word) > 0) {
			supLinha = arrayPalavras[med].length;
			//agora segue o mesmo padr�o de pesquisa binaria, por�m dentro da linha
			if (arrayPalavras[med][medLinha].compareToIgnoreCase(word) < 0) {
				lookup(word, inf, sup, infLinha = medLinha + 1, supLinha);
			} else if (arrayPalavras[med][medLinha].compareToIgnoreCase(word) > 0) {
				lookup(word, inf, sup, infLinha, supLinha = medLinha - 1);
			}
		}
		return new IndexedWord (word, med, medLinha);
	}

	@Override
	public int[][] encode(String message) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void SortArray2D(String[][] a) {
		// cria um ArrayList
		ArrayList<String> ordenaTemp = new ArrayList<String>();
		// transforma o array bidimensional de strings em um arraylist de
		// strings.
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; i < a[i].length; i++) {
				ordenaTemp.add(a[i][j]);
			}
		} // ordena as strings
		Collections.sort(ordenaTemp);
		int k = 0;
		// devolve as strings pro array original, em ordem.
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; i < a[i].length; i++) {
				a[i][j] = ordenaTemp.get(k++);
			}
		}
	}


}
