package ms.api.exceptionHandling;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request){
		
		ErrorResponse errorResponse = new ErrorResponse(
				 new Date(),
		            ex.getMessage(),
		            request.getDescription(false)
				);
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
		
	}

}
