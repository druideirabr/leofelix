package aula07;

import java.io.*;

public class ExWrite {

	public static void main(String[] args) throws IOException {
		File f = new File("exemploWrite.txt");
		String[] linhas = { 
			"Primeira linha", 
			"Segunda linha", 
			"Terceira linha" 
		};

		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(f));
			out.write('X');
			for(int i=0; i<linhas.length; i++) {
				out.newLine();
				out.write(linhas[i]);
			}
			
		} finally {
			out.close();
		}

	}

}
