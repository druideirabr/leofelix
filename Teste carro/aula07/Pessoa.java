package aula07;

import java.awt.Color;
import java.time.LocalDate;


public class Pessoa implements java.io.Serializable 
{
	private String nome;
	private int idade;
	private double altura;
	private Color corPreferida;
	private LocalDate dataNascimento;
	
	public Pessoa(String nome, int idade, double altura, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
		this.corPreferida = Color.WHITE;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public double getAltura() {
		return altura;
	}

	public Color getCorPreferida() {
		return corPreferida;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome 
				+ ", idade="+ idade 
				+ ", altura=" + altura 
				+ ", corPreferida=" + corPreferida
				+ ", dataNascimento=" + dataNascimento 
				+ "]";
	}
	
	public static void main(String[] args) {
		Pessoa p = new Pessoa(
				"Luciano", 80, 
				3.19, 
				LocalDate.of(2001, 01, 01) 
				);
		System.out.println(p);
	}

}







