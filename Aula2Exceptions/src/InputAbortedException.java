import java.util.concurrent.TimeUnit;

public class InputAbortedException extends RuntimeException {
	
	private String nomeDaVariavel;

	public InputAbortedException() {
		super();
		this.nomeDaVariavel = "A entrada de valores foi cancelada e o programa será fechado";

	}

	public String getNomeDaVariavel() {
		return nomeDaVariavel;
	}
	
	
	
//	public InputAbortedException(String msg) {
//		super(msg);
//	}
	
}
