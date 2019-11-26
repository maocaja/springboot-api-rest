package exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Data
public class ApiError
{
	private HttpStatus httpStatus;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
	private LocalDateTime localDateTime;
	private String message;
	private String debugMessage;

	public ApiError()
	{
		this.localDateTime = LocalDateTime.now();
	}

	public ApiError(final HttpStatus httpStatus)
	{
		this();
		this.httpStatus = httpStatus;
	}

	public ApiError(final HttpStatus httpStatus, Throwable throwable)
	{
		this();
		this.httpStatus = httpStatus;
		this.message = "Unexpetecd error";
		this.debugMessage = throwable.getLocalizedMessage();
	}

	public ApiError(final HttpStatus httpStatus, String message, Throwable throwable)
	{
		this();
		this.httpStatus = httpStatus;
		this.message = message;
		this.debugMessage = throwable.getLocalizedMessage();
	}



}
