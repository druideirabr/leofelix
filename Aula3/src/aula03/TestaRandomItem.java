package aula03;

import javax.swing.JOptionPane;

public class TestaRandomItem {

	public static void main(String[] args) {
		RandomItem[] r = new RandomItem[1000];
		for (int i = 0; i < r.length; i++) {
			r[i] = new RandomItem();
		}
		Ordena.OrdenaBS(r);
		for (int i = 0; i < r.length; i++) {
			System.out.println(r[i].toString());
		}

		pesquisaBinaria(r);

	}

	private static void pesquisaVarreduraArray(RandomItem[] r) {
		String a = null;
		boolean deuRuim = true;
		int resposta = -5;
		a = JOptionPane.showInputDialog(null, "Insira o nome desejado aqui:");
		while (deuRuim == true) {
			for (int i = 0; i < r.length; i++) {
				if (r[i].getName().equals(a)) {
					JOptionPane.showMessageDialog(null,
							"Primeiro encontro:\nPosição: " + i + "\n\nPesquisas Feitas: " + (i + 1));
					deuRuim = false;
				}
				if (i == r.length - 1) {
					resposta = JOptionPane.showConfirmDialog(null, "Deseja pesquisar outro nome?");

					if (resposta == JOptionPane.YES_OPTION) {
						a = JOptionPane.showInputDialog(null, "Insira o nome desejado aqui:");

					} else {
						deuRuim = false;
					}

				}

			}
		}
	}

	public static void pesquisaBinaria(RandomItem[] r) {
		int inf = 0;
		int sup = r.length;
		int med = (sup + inf) / 2;
		int cont = 0;
		String a = null;
		boolean deuRuim = true;
		int resposta = -5;
		a = JOptionPane.showInputDialog(null, "Insira o nome desejado aqui:");
		while (deuRuim == true && sup >= inf) {
			cont++;
			if (r[med].getName().equals(a)) {
				JOptionPane.showMessageDialog(null,
						"Primeiro encontro:\nPosição: " + med + "\n\nPesquisas Feitas: " + cont);
				deuRuim = false;
			} else if (r[med].getName().compareTo(a) > 1) {
				sup = med - 1;
				med = (sup + inf / 2);
			} else if (r[med].getName().compareTo(a) < 1) {
				inf = med + 1;
				med = (sup + inf / 2);
			}

			if (sup > inf) {
				resposta = JOptionPane.showConfirmDialog(null, "Deseja pesquisar outro nome?");

				if (resposta == JOptionPane.YES_OPTION) {
					a = JOptionPane.showInputDialog(null, "Insira o nome desejado aqui:");
					sup = r.length;
					inf = 0;
					med = (sup+inf)/2;

				} else {
					deuRuim = false;
				}
			}

		}
	}
}