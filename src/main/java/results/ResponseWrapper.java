package results;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SuppressWarnings("unchecked")
public class ResponseWrapper<T> extends ResponseEntity<T>
{

	public ResponseWrapper(T body, final HttpStatus status)
	{
		super((T) new Resultset<>(status, body), status);
	}
}
