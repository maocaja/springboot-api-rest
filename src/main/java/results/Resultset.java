package results;

import com.fasterxml.jackson.annotation.JsonFormat;
import exception.ResourceNotFoundException;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

import static Constants.ApiConstants.DATE_FORMAT;


@Data
public class Resultset<T>
{
	private HttpStatus httpStatus;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
	private LocalDateTime localDateTime;
	private T data;

	public Resultset()
	{
		this.localDateTime = LocalDateTime.now();
	}

	public Resultset(final HttpStatus httpStatus, final T data) throws ResourceNotFoundException
	{
		this();
		if (data == null || (data instanceof List && ((List) data).isEmpty()))
			throw new ResourceNotFoundException("Not content Found");
		this.httpStatus = httpStatus;
		this.data = data;
	}
}
