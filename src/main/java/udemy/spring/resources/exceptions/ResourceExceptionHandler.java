package udemy.spring.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import udemy.spring.services.exceptions.ResourceNotFoundException;

//vai interceptar as exceptions
@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> recursoNaoExiste(ResourceNotFoundException erro, HttpServletRequest request){
		String error = "Recurso não existe.";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, erro.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
		
	}
}
