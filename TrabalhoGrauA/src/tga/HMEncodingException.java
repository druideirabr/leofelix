package tga;

public class HMEncodingException extends RuntimeException {

	public HMEncodingException() {
		super("Esta palavra n�o existe no array, procure outro arquivo ou mude a mensagem desejada");
		//fazer condicionais pra lan�ar a exce��o
	}
}
