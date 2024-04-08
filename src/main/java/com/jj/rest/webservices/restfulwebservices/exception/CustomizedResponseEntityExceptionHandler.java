package com.jj.rest.webservices.restfulwebservices.exception;

import com.jj.rest.webservices.restfulwebservices.ErrorDetails;
import com.jj.rest.webservices.restfulwebservices.user.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

/** 컨트롤러에서 발생하는 예외를 처리하는 클래스
 *  ResponseEntityExceptionHandler를 상속받아서 커스터마이징
 */
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // 모든 예외를 처리하는 메서드
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handelAllExceptions(Exception ex, WebRequest request) throws Exception {
        // 에러 상세 정보를 생성
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(), request.getDescription(false));
        // 500 Internal Server Error 상태 코드와 함께 에러 상세 정보를 반환
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 사용자를 찾을 수 없는 경우를 처리하는 메서드
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handelUserNotFoundExceptions(Exception ex, WebRequest request) throws Exception {
        // 에러 상세 정보를
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(), request.getDescription(false));
        // 404 Not Found 상태 코드와 함께 에러 상세 정보를 반환
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    // MethodArgumentNotValidException 예외를 처리하는 메서드
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
        "Total Errors:" + ex.getErrorCount() + " First Error:" + ex.getFieldError().getDefaultMessage(),
                request.getDescription(false));

        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
