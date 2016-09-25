package aula07;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.*;

public class ExReadObject {
	public static void main(String[] args)
			throws IOException, ClassNotFoundException
	{
		File inf = new File("objetoPessoa.ser");
		
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(
					new BufferedInputStream(
						new FileInputStream(inf)));
			
			
			System.out.println(in.readBoolean());
			System.out.println(in.readInt());
			
			Pessoa p = (Pessoa) in.readObject();						
			System.out.println(p.getNome());
			System.out.println(p.getDataNascimento());
			
			System.out.println(in.readInt());
		}
		finally {
			if (in != null) in.close();
		}
				
		
		
	}

}
