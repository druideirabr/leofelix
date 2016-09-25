package aula07;

import java.io.*;
import java.time.LocalDate;

public class ExWriteObject {
	public static void main(String[] args)
	throws IOException
	{
		File of = new File("objetoPessoa.ser");
		Pessoa pessoa = new Pessoa(
			"Luciano", 80, 3.19,LocalDate.of(2001, 01, 01));
		
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream(of)));
			
			out.writeBoolean(true);
			out.writeInt(377);
			out.writeObject(pessoa);
		}
		finally {
			if (out!=null) out.close();	
		}
		
		
		
		
	}
}
