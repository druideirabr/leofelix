import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class provaItalia {
	public static void main(String args[]) {
		Piloto[] p;
		String filename = "C:/Users/Leo/Downloads/F1Italia2016.txt";
		String words[] = null;
		int cont = 0;
		FileReader fr = null;
		BufferedReader inn = null;
		// conta as linhas do arquivo para criar o array
		try {
			fr = new FileReader(filename);
			inn = new BufferedReader(fr);
			String line = inn.readLine();

			while (line != null) { // enquanto não chega no final do arquivo
				cont++;
				line = inn.readLine();
			}
			// menos uma linha do cabeçalho
			inn.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo  \"" + filename + "\" não existe.");
		} catch (IOException e) {
			System.out.println("Erro  na leitura do arquivo " + filename + ".");
		}
		p = new Piloto[(cont - 1)];
		// guarda em um array de String os atributos do Piloto e passa um novo
		// obj Piloto para cada pos do array
		try {
			fr = new FileReader(filename);
			inn = new BufferedReader(fr);
			String l = inn.readLine();
			int i = 0;
			// leio mais uma vez pra começar na segunda linha
			while ((l = inn.readLine()) != null) {
				// enquanto não chega no final do arquivo
				words = l.split("#");
				p[i] = new Piloto(words[0], words[1], words[2], words[3], words[4], Integer.parseInt(words[5]));
				// assignar valores para o array de pilotos
				// converte para int
				System.out.println(i + " Number: " + p[i].getNumber() + ", Driver: " + p[i].getDriver() + ", Team: "
						+ p[i].getTeam() + ", Laps: " + p[i].getLaps() + ", Time: " + p[i].getTime() + ", Points: "
						+ p[i].getPts()); // apenas mostrando que adc correto
				i++;
			}
			// verifiquei que aqui ja mostra todos com a ultima linha
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo  \"" + filename + "\" não existe.");
		} catch (IOException e) {
			System.out.println("Erro  na leitura do arquivo " + filename + ".");
		}
		mostraArray(p);
		// aqui preenche todos com a ultima linha
	}

	public static void mostraArray(Piloto[] p) {
		for (int i = 0; i < p.length; i++) {
			System.out.println(i + " Number: " + p[i].getNumber() + ", Driver: " + p[i].getDriver() + "," + " Team: "
					+ p[i].getTeam() + ", Laps: " + p[i].getLaps() + "," + " Time: " + p[i].getTime() + ","
					+ " Points: " + p[i].getPts());
		}
	}

}
