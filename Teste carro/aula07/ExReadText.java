package aula07;

import java.io.*;

public class ExReadText {

	public static void main(String[] args) throws IOException 
	{
		File f = new File("exemplo7");
		BufferedReader in = null;
		try {
//			in = new InputStreamReader(new FileInputStream(f));
//			in = new InputStreamReader(
//					new BufferedInputStream(
//							new FileInputStream(f)));						
//			int c;
//			while ((c=in.read()) != -1) {
//				System.out.println((char)c);
//			}
			
			in = new BufferedReader(new FileReader(f));
			String line = null;
			while ((line=in.readLine()) != null) {
				System.out.println(line);
			}
			
		}
		finally {
			if (in != null) in.close();
		}

	}

}
