package tga;

public class HMEncodingException extends RuntimeException {

	public HMEncodingException() {
		super("Esta palavra não existe no array, procure outro arquivo ou mude a mensagem desejada");
		//fazer condicionais pra lançar a exceção
	}
}
