package com.anz.accountservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.accountservice.dto.AccountDto;
import com.anz.accountservice.dto.TransactionDto;
import com.anz.accountservice.entity.AccountEntity;
import com.anz.accountservice.entity.TransactionEntity;
import com.anz.accountservice.exception.NoSuchAccountsException;
import com.anz.accountservice.exception.NoSuchTransactionsException;
import com.anz.accountservice.exception.ValidatorException;
import com.anz.accountservice.repository.AccountRepository;
import com.anz.accountservice.repository.TransactionRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepo;

	@Autowired
	TransactionRepository transactionRepo;

//	Fetching Account List of the particular User

	public List<AccountDto> viewAccountList(String userId) throws NoSuchAccountsException, ValidatorException {

		if (!Validator.validateUserId(userId))

			throw new ValidatorException("User Id is not valid!");

		List<AccountEntity> accountEntityList = accountRepo.findByUserId(userId);

		if (accountEntityList.isEmpty())
			throw new NoSuchAccountsException("User does not have any available accounts!");

		List<AccountDto> accountDtoList = new ArrayList<AccountDto>();

		for (AccountEntity accountEntity : accountEntityList) {
			accountDtoList.add(AccountDto.toDto(accountEntity));
		}

		return accountDtoList;
	}

// Fetching Transaction List of the particular Account Number

	public List<TransactionDto> viewAccountTransaction(Long accountNumber)
			throws NoSuchTransactionsException, ValidatorException {

		if (!Validator.validateAccountNumber(accountNumber))

			throw new ValidatorException("Account Number is not Valid!");

		List<TransactionEntity> transactionEntityList = transactionRepo.findByAccountNumber(accountNumber);

		if (transactionEntityList.isEmpty())
			throw new NoSuchTransactionsException("No Transactions available for this account!");

		List<TransactionDto> transactionDtoList = new ArrayList<TransactionDto>();

		for (TransactionEntity transactionEntity : transactionEntityList) {
			transactionDtoList.add(TransactionDto.toDto(transactionEntity));
		}

		return transactionDtoList;
	}

}
