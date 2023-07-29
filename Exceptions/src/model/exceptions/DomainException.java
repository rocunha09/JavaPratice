package model.exceptions;

public class DomainException extends RuntimeException{
	//se for extends RuntimeExceptions não precisa tratar, mas se for apenas Exception precisa
	//Exception é serializable então ele precisa ter uma versão, a ide ajudou nisso.
	//runtime não precisa de que os métodos tenham throws
	private static final long serialVersionUID = 1L;
	
	
	public DomainException(String msg) {
		super(msg);
	}
	
}
