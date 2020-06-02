package com.anz.accountservice.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anz.accountservice.dto.AccountDto;
import com.anz.accountservice.dto.TransactionDto;
import com.anz.accountservice.exception.NoSuchAccountsException;
import com.anz.accountservice.exception.NoSuchTransactionsException;
import com.anz.accountservice.exception.ValidatorException;
import com.anz.accountservice.service.AccountService;

//Controller Class

@RestController
public class AccountServiceController {

	private static final Logger logger = LogManager.getLogger(AccountService.class);

	@Autowired
	AccountService accountService;

	// Sending Get Request for fetching Account List of User

	@GetMapping("/accounts")

	public List<AccountDto> viewAccountList(@RequestParam("userId") String userId)
			throws NoSuchAccountsException, ValidatorException {

		logger.info("user signed in with user id:" + userId);

		return accountService.viewAccountList(userId);
	}

	// Sending Get Request for fetching the transaction details of the account
	// selected

	@GetMapping("/transactions")

	public List<TransactionDto> viewAccountTransaction(@RequestParam("accountNumber") Long accountNumber)
			throws NoSuchTransactionsException, ValidatorException {

		logger.info("account number selected:" + accountNumber);

		return accountService.viewAccountTransaction(accountNumber);
	}

}
