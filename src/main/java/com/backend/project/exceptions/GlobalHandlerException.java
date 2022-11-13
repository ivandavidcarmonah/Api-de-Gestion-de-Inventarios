package com.backend.project.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.backend.project.DTO.ErrorsDTOs.ErrorDetailDTO;

@ControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetailDTO> resourceNotFoundException(
			ResourceNotFoundException notFoundException,
			WebRequest webRequest){
		ErrorDetailDTO errorDetailDTO = new ErrorDetailDTO(new Date(), notFoundException.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<ErrorDetailDTO>(errorDetailDTO, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BackStandarAppException.class)
	public ResponseEntity<ErrorDetailDTO> resourceBackAppException(
			BackStandarAppException notFoundException,
			WebRequest webRequest){
		ErrorDetailDTO errorDetailDTO = new ErrorDetailDTO(new Date(), notFoundException.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<ErrorDetailDTO>(errorDetailDTO, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetailDTO> globalException(
			Exception notFoundException,
			WebRequest webRequest){
		ErrorDetailDTO errorDetailDTO = new ErrorDetailDTO(new Date(), notFoundException.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<ErrorDetailDTO>(errorDetailDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub.
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String nameColumn = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			
			errors.put(nameColumn, message);
		});
		
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
}
