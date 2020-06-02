package com.anz.accountservice.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class ExceptionControllerAdvice {

	private static Logger logger = LogManager.getLogger(ExceptionControllerAdvice.class);

	@ExceptionHandler(NoSuchAccountsException.class)

	public ResponseEntity<ErrorMessage> accountExceptionHandler(NoSuchAccountsException ex) {

		logger.error(ex.getMessage());

		ErrorMessage error = new ErrorMessage();

		error.setErrorCode(500);

		error.setMessage(ex.getMessage());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NoSuchTransactionsException.class)

	public ResponseEntity<ErrorMessage> transactionExceptionHandler(NoSuchTransactionsException ex) {

		logger.error(ex.getMessage());

		ErrorMessage error = new ErrorMessage();

		error.setErrorCode(500);

		error.setMessage(ex.getMessage());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ValidatorException.class)

	public ResponseEntity<ErrorMessage> ValidatorExceptionHandler(ValidatorException ex) {

		logger.error(ex.getMessage());

		ErrorMessage error = new ErrorMessage();

		error.setErrorCode(500);

		error.setMessage(ex.getMessage());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
