package com.anz.accountservice.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.anz.accountservice.dto.AccountDto;
import com.anz.accountservice.dto.TransactionDto;
import com.anz.accountservice.service.AccountService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AccountServiceController.class)
public class AccountServiceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountService accountService;

	private List<AccountDto> accountsList = null;

	private List<TransactionDto> transactionList = null;

	@Before
	public void initialize() {
		AccountDto account = new AccountDto();
		account.setAccountName("SG123");
		account.setAccountNumber(5365124);
		account.setAccountType("Savings");
		account.setBalanceDate(LocalDate.of(2018, 11, 8));
		account.setOpeningAvailableBalance(8335.25);
		accountsList.add(account);
		TransactionDto transaction = new TransactionDto();
		transaction.setAccountName("Sg123");
		transaction.setAccountNumber(5365124);
		transaction.setCurrency("SGD");
		transaction.setDebitAmount(5633.25);
		transaction.setTransactionNarrative("");
		transaction.setTransactionType("Debit");
		transaction.setValueDate(LocalDate.of(2018, 12, 8));
		transactionList.add(transaction);

	}

	@Test
	public void viewAccountsListTest() throws Exception {

		final String userId = "user1@123";

		when(accountService.viewAccountList(userId)).thenReturn(accountsList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accounts").param(userId, "user1@123");

		mockMvc.perform(requestBuilder).andExpect(status().isOk());

	}

	@Test
	public void viewTransactionsListTest() throws Exception {

		final long accountNumber = 5365124;

		when(accountService.viewAccountTransaction(accountNumber)).thenReturn(transactionList);

		this.mockMvc.perform(get("/transactions").param("accountNumber", "5365124")).andExpect(status().isOk());

	}

}
