package tga;
//Cria unchecked exception (exception em tempo de execu��o), conforme especificado no codificador.
public class HMEncodingException extends RuntimeException {

	public HMEncodingException() {
		super("Esta(s) palavra(s) n�o existe(m) neste arquivo, procure outro arquivo ou mude a mensagem desejada");
		//fazer condicionais pra lan�ar a exce��o
	}
}
