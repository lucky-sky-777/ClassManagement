package com.mezon.classmanagement.backend.exception;

import com.mezon.classmanagement.backend.dto.response.ResponseDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = ArithmeticException.class)
	public ResponseDTO<String> handle(ArithmeticException arithmeticException) {
		return new ResponseDTO<>(true, "arit", arithmeticException.getMessage(), null);
	}

}