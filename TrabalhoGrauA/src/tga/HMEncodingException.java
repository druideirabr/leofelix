package tga;
//Cria unchecked exception (exception em tempo de execução), conforme especificado no codificador.
public class HMEncodingException extends RuntimeException {

	public HMEncodingException() {
		super("Esta(s) palavra(s) não existe(m) neste arquivo, procure outro arquivo ou mude a mensagem desejada");
		//fazer condicionais pra lançar a exceção
	}
}
