package tga;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws IOException {

		// cria um arquivo qualquer
		File f = new File("HM.txt");
		// pega o ultimo arquivo no diretorio onde as HM sao criadas
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH'h'mm'min'ss's' a");
		// renomeia o arquivo, dando um nome unico ao arquivo
		f.renameTo(new File("HM " + dateFormat.format(Calendar.getInstance().getTime()) + ".txt"));
		BufferedWriter out = null;
		// operadores booleanos para manter o programa funcionando caso o
		// usuario queira escolher
		// ou escolher outra mensagem
		boolean ativo;
		boolean selecionaArquivo = true;
		while (selecionaArquivo) {
			selecionaArquivo = false;
			// instancia o codificador
			Codificador c1 = new Codificador();
			// carrega o arquivo
			c1.load(c1.getBaseText());
			// instancia o array que vai armazenar as coordenadas
			int[][] a = null;
			ativo = true;
			while (ativo) {
				try {
					ativo = false;
					// joptionpane pra mensagem desejada, lembrando que o método
					// encode retorna
					// um array de inteiros, todo o processo de transformação de
					// String pra
					// int[][] fica dentro do encode.
					a = c1.encode(JOptionPane.showInputDialog("Digite a frase desejada: "));
					// escreve no arquivo f e grava em disco
					out = new BufferedWriter(new FileWriter(f));
					printFile(a);
					writeNewFile(out, a);
					// printa o array na tela.
					JOptionPane.showMessageDialog(null, showFile(a));
					out.close();
					// pergunta se quer abrir um novo arquivo, metodos privados
					// abaixo
					selecionaArquivo = selecionarNovoArquivo(selecionaArquivo);
					if (!selecionaArquivo)
						// se a pessoa não quiser abrir outro arquivo, vai
						// perguntar se ela quer
						// fechar o programa
						ativo = ativador(ativo);

				} catch (HMEncodingException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					// vai perguntar se a pessoa quer sair do programa
					ativo = ativador(ativo);
					if (ativo) {
						ativo = false;
						// se ela quiser continuar no programa, vai perguntar se
						// ela quer escolher outro arquivo
						selecionaArquivo = selecionarNovoArquivo(selecionaArquivo);
					}
					// se ela nao quiser escolher outro arquivo, vai abrir
					// novamente a janela de escolha de um arquivo novo
					if (!selecionaArquivo)
						ativo = true;
					// quando o usuario fecha o programa sem escolher nada,
					// lança um NPE.
				} catch (NullPointerException ex) {
					// segue o mesmo padrão do HMencodingException. Dá pro
					// usuario a opçao de escolher
					// um arquivo novo, ou sair do programa, caso o mesmo não
					// queira fazer nada.
					selecionaArquivo = selecionarNovoArquivo(selecionaArquivo);
					ativo = ativador(ativo);
					if (ativo) {
						ativo = false;
						selecionaArquivo = selecionarNovoArquivo(selecionaArquivo);
					}
					if (!selecionaArquivo)
						ativo = true;
				}
			}
		}
	}

	private static String showFile(int[][] a) {
		// cria uma String pra mostrar a HM num JoptionPane;
		String msg = "HM " + a.length;
		for (int i = 0; i < a.length; i++) {
			msg += "\n";
			for (int j = 0; j < a[i].length; j++) {
				msg += (a[i][j]) + " ";
			}

		}
		return msg;
	}

	private static void printFile(int[][] a) {
		// printa o array formado
		System.out.print("HM " + a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.print("\n");
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
		}
		// pula uma linha quando chega no final, caso a pessoa queira printar
		// mais de uma HM
		// em sequencia, não gera erros de formatação
		System.out.print("\n");
	}

	private static void writeNewFile(BufferedWriter out, int[][] a) throws IOException {
		// escreve em um arquivo o array da mensagem escondida, junto com as
		// mensagens HM + length
		out.write("HM " + a.length);
		for (int i = 0; i < a.length; i++) {
			out.newLine();
			for (int j = 0; j < a[i].length; j++) {
				out.write((a[i][j] + 1) + " ");
			}

		}
	}

	private static boolean selecionarNovoArquivo(boolean selecionaArquivo) {
		// condicionais de execução do programa, para dar possibilidade ao
		// usuario a adição
		// de mais de uma mensagem escondida ao mesmo tempo, e seleção de
		// diferentes arquivos
		// sobre uma unica execução
		int resposta = JOptionPane.showConfirmDialog(null, "Deseja Selecionar Outro Arquivo?");
		if (resposta == JOptionPane.YES_OPTION) {
			selecionaArquivo = true;
		}
		return selecionaArquivo;
	}

	private static boolean ativador(boolean ativo) {
		// condicionais de execução do programa, para dar possibilidade ao
		// usuario a adição
		// de mais de uma mensagem escondida ao mesmo tempo, e seleção de
		// diferentes arquivos
		// sobre uma unica execução
		int resposta = JOptionPane.showConfirmDialog(null, "Deseja Sair do Programa?");
		if (resposta == JOptionPane.YES_OPTION) {
			System.exit(0);
		} else
			ativo = true;

		return ativo;
	}

}
