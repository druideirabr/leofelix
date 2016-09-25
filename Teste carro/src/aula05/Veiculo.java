package aula05;

public class Veiculo 
	implements Comparable<Veiculo>
{
	private String placa;
	private String cor;
	private String modelo;
	private int numPortas;
	private int numRodas;
	private double kmRodados;
	private double consumoLitrosPorKm;
	
	@Override
	public int compareTo(Veiculo outro) {
		if (this.consumoLitrosPorKm < outro.consumoLitrosPorKm)
			return -1;
		else if (this.consumoLitrosPorKm == outro.consumoLitrosPorKm)
			return 0;
		else
			return 1;
	}
	
	public Veiculo(String placa, String cor, String modelo, int numPortas,
			int numRodas, double kmRodados, double consumoLitrosPorKm) {
		super();
		this.placa = placa;
		this.cor = cor;
		this.modelo = modelo;
		this.numPortas = numPortas;
		this.numRodas = numRodas;
		this.kmRodados = kmRodados;
		this.consumoLitrosPorKm = consumoLitrosPorKm;
	}

	public String getPlaca() {
		return placa;
	}

	public String getCor() {
		return cor;
	}

	public String getModelo() {
		return modelo;
	}

	public int getNumPortas() {
		return numPortas;
	}

	public int getNumRodas() {
		return numRodas;
	}

	public double getKmRodados() {
		return kmRodados;
	}

	public double getConsumoLitrosPorKm() {
		return consumoLitrosPorKm;
	}
	
	public String toString() {
		return "veiculo: "+placa+" "+cor+" "+modelo;
	}

	

}
