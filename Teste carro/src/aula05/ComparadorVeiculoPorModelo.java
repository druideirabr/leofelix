package aula05;

import java.util.Comparator;

public class ComparadorVeiculoPorModelo
	implements Comparator<Veiculo>
{

	@Override
	public int compare(Veiculo o1, Veiculo o2) {
		return -1 * o1.getModelo().compareTo(o2.getModelo());
	}

}
