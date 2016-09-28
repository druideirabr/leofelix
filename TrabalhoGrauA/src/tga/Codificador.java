package tga;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Codificador implements HMEncoder {

	public ArrayList<IndexedWord> indiceReverso = new ArrayList<IndexedWord>();

	public void load(File baseText) {
		// declaraçao do que é usado no método
		String linha;
		BufferedReader in = null;
		String[] arrayDaLinha;
		// variável temporaria para
		IndexedWord palavraComIndex;
		try {
			// cria o leitor
			in = new BufferedReader(new FileReader(baseText));
			int j = 0;
			// enquanto nao chega no fim da arquivo , continua lendo
			while ((linha = in.readLine()) != null) {
				int i = 0;
				// divide o arquivo e cria um array de Strings da String
				// correspondente à linha
				arrayDaLinha = linha.split(" ");
				while (i < arrayDaLinha.length) {
					// enquanto não terminar esse array, vai adicionando no
					// indiceReverso
					// j = 0 (primeira linha). Adiciona todoos da çrimeira linha
					// com seus respectivos valores
					palavraComIndex = new IndexedWord(arrayDaLinha[i], j, i++);
					indiceReverso.add(palavraComIndex);
				}
				j++;
			}
			// sorteia o arrayList, usando a classe Comparador, que implementa
			// Comparator.
			Collections.sort(indiceReverso, new Comparador());
			// captura as checked exceptions
		} catch (IOException e) {
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
		// declaração do file
		File file = null;
		// declaração do JFileChooser que acessa os diretórios do sistema
		// operacional
		JFileChooser chooser = new JFileChooser();
		// filtro para aceitar apenas arquivos de texto
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo Texto", "txt", "rtf");
		chooser.setFileFilter(filter);
		// elimina a opção de escolher "Todos os arquivos", para não dar erro no
		// tempo de execução,
		// caso o usuario selecione um arquivo errado
		chooser.setAcceptAllFileFilterUsed(false);
		boolean ativo = true;
		// enquanto estiver ativo, ou seja, o programa não for fechado ou outro
		// arquivo escolhido, continua
		// pedindo entrada de dados.
		while (ativo) {
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				// se achar um arquivo válido, adiciona ao file;
				file = chooser.getSelectedFile().getAbsoluteFile();
				if (file.exists())
					ativo = false;
			} else {
				// confirmação de saída do programa
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja Sair do Programa?");
				if (resposta == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else
					ativo = true;

			}
		}
		// retorna o arquivo, caso o arquivo selecionado seja válido.
		return file;
	}

	@Override
	public IndexedWord lookup(String word) {
		// chama o método privado
		return lookup(word, 0, indiceReverso.size());
	}

	private IndexedWord lookup(String word, int inf, int sup) {
		// pesquisa binária simples
		int med = (inf + sup) / 2;
		if (inf <= sup && med < indiceReverso.size() - 1) {
			// se achar a palavra retorna o a IndexedWord correspondente dela.
			if (indiceReverso.get(med).getPalavra().compareTo(word) == 0)
				return indiceReverso.get(med);
			// se a palavra vier depois, aumenta o inf;
			else if (indiceReverso.get(med).getPalavra().compareTo(word) < 0) {
				return lookup(word, inf = med + 1, sup);
				// se vier antes , diminui o sup;
			} else if (indiceReverso.get(med).getPalavra().compareTo(word) > 0) {
				return lookup(word, inf, sup = med - 1);
			}
		}
		// se não tiver, retorna nulo.
		return null;

	}

	@Override
	public int[][] encode(String message) throws HMEncodingException {
		// divide a mensagem recebida em um string de palavras
		String[] mensagem = message.split(" ");
		// cria uma matriz com os indices
		int[][] retornoMatrizInt = null;
		// cria uma matriz de N x 2, de acordo com especificações do programa
		retornoMatrizInt = new int[mensagem.length][2];
		for (int i = 0; i < retornoMatrizInt.length; i++) {
			// se a mensagem for nula, lança uma exception. Vale ressaltar que o
			// programa não
			// conta espaços como Exceptions, espaços são caracteres válidos.
			if (lookup(mensagem[i]) == null) {
				throw new HMEncodingException();
			}
			// preenche a matriz N x 2 com os respectivos valores de linha e
			// coluna.
			// poderia ser feito com [i] e [j], porem daria mais trabalho, para
			// o mesmo propósito.
			// nesse caso ,por se tratar de uma matriz pequna, resolvi optar por
			// valores constantes.
			retornoMatrizInt[i][0] = lookup(mensagem[i]).getLinha() + 1;
			retornoMatrizInt[i][1] = lookup(mensagem[i]).getColuna() + 1;
		}
		// retorna a matriz gerada.
		return retornoMatrizInt;
	}

	// método de teste criado para verificar a estutura do indiceReverso;
	private void printArray() {
		for (int i = 0; i < indiceReverso.size(); i++) {
			System.out.println(indiceReverso.get(i).getPalavra() + " " + indiceReverso.get(i).getLinha() + " "
					+ indiceReverso.get(i).getColuna());
		}
	}
}