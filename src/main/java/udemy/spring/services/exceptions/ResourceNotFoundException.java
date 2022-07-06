package udemy.spring.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//passar o id do Objeto que não foi encontrado
	public ResourceNotFoundException(Object id) {
		super("Recurso não encontrado. Id  "  +id);
		
	}

}
