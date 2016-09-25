
import javax.swing.JOptionPane;

public class TestaJOP {

	public static void main(String[] args) {

		try {
		// lê primeiro valor
		double d1 = leDouble("Primeiro Valor?");

		// lê segundo valor
		double d2 = leDouble("Segundo Valor?");

		JOptionPane.showMessageDialog(null, "Soma: " + (d1 + d2));
		}
		catch (InputAbortedException iae) {
			JOptionPane.showMessageDialog(
					null,
					"<html>Entrada de '"+iae.getNomeDaVariavel()
					+"' cancelada. <br/><i>Finalizando!</i>");
			System.exit(0);
		}
	}

	private static Double leDouble(String nomeVar) {
		double resultado = 0;
		boolean fracasso = true;
		while (fracasso) {
			try {
				String s1 = JOptionPane.showInputDialog(
						"Informe o valor de "+nomeVar);
				if (s1 == null ) {
					// entrada cancelada
					throw new InputAbortedException(nomeVar);
				}
				else {
					resultado = Double.parseDouble(s1);
					fracasso = false;
				}

			} catch (NumberFormatException nfe) {
				// redundante, 
				// fracasso = true;
				JOptionPane.showMessageDialog(
						null, 
						"Você deve informar um número", 
						"Erro", 
						JOptionPane.ERROR_MESSAGE);

			}
		}
		return resultado;

	}

}
