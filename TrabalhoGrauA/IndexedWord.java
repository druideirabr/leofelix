package tga;

public class IndexedWord {
	private String palavra;
	private int linha;
	private int coluna;
	
	//construtor:
	public IndexedWord(String palavra, int linha, int coluna) {
		this.palavra = palavra;
		this.linha = linha;
		this.coluna = coluna;
	}

	//métodos get:
	public String getPalavra() {
		return palavra;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

}// IndexedWord
