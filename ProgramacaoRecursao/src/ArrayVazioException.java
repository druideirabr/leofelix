
public class ArrayVazioException extends RuntimeException {
private String  n;

public ArrayVazioException(){
	super();
	n = "Array Vazio";
}
public String getNomeException(){
	return n;
	
}
public ArrayVazioException(String n){
	super(n);
}
}
