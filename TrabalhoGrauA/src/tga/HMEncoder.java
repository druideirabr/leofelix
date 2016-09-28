package tga;

import java.io.*;
//interface original provida nas especifica��es do programa, n�o alteradas.
interface HMEncoder {
	/**
	 * Retorna o nome do arquivo base atualmente em uso.
	 */
	public File getBaseText();

	/**
	 * L� conte�do do arquivo de texto base e constr�i o �ndice reverso,
	 * substituindo o �ndice anterior caso exista.
	 */
	public void load(File baseText);

	/**
	 * Pesquisa o �ndice reverso utilizando busca bin�ria recursiva. Retorna o
	 * objeto IndexedWord correspondente � palavra informada como par�metro se
	 * encontrado ou null caso n�o exista correspond�ncia.
	 */
	public IndexedWord lookup(String word);

	/**
	 * Retorna um array 2xN contendo as coordenadas das palavras existentes em
	 * message, onde N � o n�mero de palavras.
	 */
	public int[][] encode(String message) throws HMEncodingException;
}