package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> resourceEntityNotFound(ResourceNotFoundException ex)
	{
		ApiError apiError = setError(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST, ex);
		return new ResponseEntity<>(apiError, apiError.getHttpStatus());
	}

	private ApiError setError(String message, HttpStatus httpStatus, Exception e)
	{
		ApiError apiError = new ApiError(httpStatus);
		apiError.setMessage(message);
		apiError.setDebugMessage(e.getMessage());
		return apiError;
	}
}

