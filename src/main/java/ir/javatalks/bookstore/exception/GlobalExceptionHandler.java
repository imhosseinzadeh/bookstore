package ir.javatalks.bookstore.exception;

import ir.javatalks.bookstore.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = { Exception.class })
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ErrorResponseDto handleMyException(Exception ex) {
    return new ErrorResponseDto("400", ex.getMessage());
  }

}
