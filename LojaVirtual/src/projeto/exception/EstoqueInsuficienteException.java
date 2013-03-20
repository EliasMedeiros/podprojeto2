package projeto.exception;

@SuppressWarnings("serial")
public class EstoqueInsuficienteException extends Exception {
	
	public EstoqueInsuficienteException() {
		super("Estoque Insuficiente!");
	}

}
