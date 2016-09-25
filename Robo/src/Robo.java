

public class Robo {
	private String nome;

	public Robo(String nome) {
		this.nome = nome;
	}

	public void cumprimentar(Display d) {
		d.exibir("Olá! Eu sou " + this.nome);
	}
}

interface Display {
	public void exibir(String msg);
}