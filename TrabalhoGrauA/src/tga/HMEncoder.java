package tga;

import java.io.*;
//interface original provida nas especificações do programa, não alteradas.
interface HMEncoder {
	/**
	 * Retorna o nome do arquivo base atualmente em uso.
	 */
	public File getBaseText();

	/**
	 * Lê conteúdo do arquivo de texto base e constrói o índice reverso,
	 * substituindo o índice anterior caso exista.
	 */
	public void load(File baseText);

	/**
	 * Pesquisa o índice reverso utilizando busca binária recursiva. Retorna o
	 * objeto IndexedWord correspondente à palavra informada como parâmetro se
	 * encontrado ou null caso não exista correspondência.
	 */
	public IndexedWord lookup(String word);

	/**
	 * Retorna um array 2xN contendo as coordenadas das palavras existentes em
	 * message, onde N é o número de palavras.
	 */
	public int[][] encode(String message) throws HMEncodingException;
}