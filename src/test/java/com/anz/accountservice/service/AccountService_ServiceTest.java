package com.anz.accountservice.service;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.anz.accountservice.entity.AccountEntity;
import com.anz.accountservice.entity.TransactionEntity;
import com.anz.accountservice.exception.NoSuchAccountsException;
import com.anz.accountservice.exception.NoSuchTransactionsException;
import com.anz.accountservice.exception.ValidatorException;
import com.anz.accountservice.repository.AccountRepository;
import com.anz.accountservice.repository.TransactionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountService_ServiceTest {

	@InjectMocks
	private AccountServiceImpl accountService;

	@Mock
	private AccountRepository accountRepo;

	@Mock
	private TransactionRepository transactionRepo;

	private List<AccountEntity> accountsList =new ArrayList<AccountEntity>();

	private List<TransactionEntity> transactionList = new ArrayList<TransactionEntity>();

	@Before
	public void initialize() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void AccountListExceptionTest() {
		Exception ex = assertThrows(NoSuchAccountsException.class, () -> {
			accountService.viewAccountList("user1");
		});
		String expectedMessage = "User does not have any available accounts";
		String actualMessage = ex.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void TransactionListExceptionTest() {
		Exception ex = assertThrows(NoSuchTransactionsException.class, () -> {
			accountService.viewAccountTransaction(11111111L);
		});
		String expectedMessage = "No Transactions available for this account";
		String actualMessage = ex.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void InvalidUserIdExceptionTest() {

		Exception ex = assertThrows(ValidatorException.class, () -> {
			accountService.viewAccountList("*");
		});

		String expectedMessage = "User Id is not valid!";

		String actualMessage = ex.getMessage();

		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void InvalidAccountNumberTest() {

		Exception ex = assertThrows(ValidatorException.class, () -> {
			accountService.viewAccountTransaction(1111L);
		});

		String expectedMessage = "Account Number is not Valid!";

		String actualMessage = ex.getMessage();

		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void fetchAccountsListfromDataBaseTest() {
		AccountEntity account = new AccountEntity();
		account.setAccountName("SG123");
		account.setAccountNumber(5365124);
		account.setAccountType("Savings");
		account.setBalanceDate(LocalDate.of(2018, 11, 8));
		account.setOpeningAvailableBalance(8335.25);
		account.setUserId("user1@123");
		accountsList.add(account);
		when(accountRepo.findByUserId("user1@123")).thenReturn(accountsList);
		List<AccountEntity> accountList = accountRepo.findByUserId("user1@123");
		assertEquals(1, accountList.size());
		for (AccountEntity accountEntity : accountList) {
			assertEquals("user1@123", accountEntity.getUserId());
		}
	}

	@Test
	public void fetchTransactionListfromDataBaseTest() {
		TransactionEntity transaction = new TransactionEntity();
		transaction.setAccountName("Sg123");
		transaction.setAccountNumber(5365124);
		transaction.setCurrency("SGD");
		transaction.setDebitAmount(5633.25);
		transaction.setTransactionNarrative("");
		transaction.setTransactionType("Debit");
		transaction.setValueDate(LocalDate.of(2018, 12, 8));
		transactionList.add(transaction);
		when(transactionRepo.findByAccountNumber(5365124L)).thenReturn(transactionList);
		List<TransactionEntity> transactionsList = transactionRepo.findByAccountNumber(5365124L);
		assertEquals(1, transactionsList.size());
		for (TransactionEntity transactionEntity : transactionsList) {
			assertEquals(5365124, transactionEntity.getAccountNumber());
		}

	}

}
