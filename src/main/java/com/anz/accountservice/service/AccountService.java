package com.anz.accountservice.service;

import java.util.List;

import com.anz.accountservice.dto.AccountDto;
import com.anz.accountservice.dto.TransactionDto;
import com.anz.accountservice.exception.NoSuchAccountsException;
import com.anz.accountservice.exception.NoSuchTransactionsException;
import com.anz.accountservice.exception.ValidatorException;

public interface AccountService {

	public List<AccountDto> viewAccountList(String userId) throws NoSuchAccountsException, ValidatorException;

	public List<TransactionDto> viewAccountTransaction(Long accountNumber)
			throws NoSuchTransactionsException, ValidatorException;

}
