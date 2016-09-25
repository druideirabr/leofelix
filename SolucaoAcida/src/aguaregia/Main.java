
package aguaregia;

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {

	public static void main(String[] args) {
		double a = 0;
		double d = 0;
		double c = 0;
		double nitrico = 0;
		double cloridrico = 0;
		a = concAcido(a, "�cido Clor�drico(Concentra��o)");
		c = concAcido(c, "�cido N�trico (Concentra��o)");
		d = concAcido (d, "Volume total desejado(mL)");
		NumberFormat df = new DecimalFormat ("####.#");
		cloridrico = (((0.7*d)/(a/37))/11.26);
		nitrico = (((0.3*d)/(c/63))/18.09);
		JOptionPane.showMessageDialog(null, "Quantidade de �cido Clor�drico: " + df.format(cloridrico) + " mL\n"
				+ "Quantidade de �cido N�trico: " + df.format(nitrico) + " mL\n\n Diluir at� o total de "+d +" mL com �gua", "Resultado", 1);

	}

	private static double concAcido(double a, String msg) {
		while (a <= 0 )
			a = leConcentracao(msg);
		return a;
	}

	private static double leConcentracao(String msg) {
		boolean fracasso = true;
		double a = 0;
		int resposta = 0;
		while (fracasso) {
		try {

				a =  Double.parseDouble (JOptionPane.showInputDialog(null,msg, "Dosador", JOptionPane.INFORMATION_MESSAGE));
				
				fracasso = false;
				
		}	
		 catch (Exception ex) {
			resposta = JOptionPane.showConfirmDialog(null, "Resultado Inv�lido!.Deseja Sair do Programa?");
			if (resposta == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		 }
		}

		return a;

	}
}
