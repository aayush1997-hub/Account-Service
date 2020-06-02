package com.anz.accountservice.dto;

import java.time.LocalDate;

import com.anz.accountservice.entity.AccountEntity;

public class AccountDto {

	private long accountNumber;

	private String accountName;

	private String accountType;

	private LocalDate balanceDate;

	private double openingAvailableBalance;

	public AccountDto() {

	}

	public long getAccountNumber() {

		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {

		this.accountNumber = accountNumber;
	}

	public String getAccountName() {

		return accountName;
	}

	public void setAccountName(String accountName) {

		this.accountName = accountName;
	}

	public String getAccountType() {

		return accountType;
	}

	public void setAccountType(String accountType) {

		this.accountType = accountType;
	}

	public LocalDate getBalanceDate() {

		return balanceDate;
	}

	public void setBalanceDate(LocalDate balanceDate) {

		this.balanceDate = balanceDate;
	}

	public double getOpeningAvailableBalance() {

		return openingAvailableBalance;
	}

	public void setOpeningAvailableBalance(double openingAvailableBalance) {

		this.openingAvailableBalance = openingAvailableBalance;
	}

	public static AccountDto toDto(AccountEntity accountEntity) {

		AccountDto accountDto = new AccountDto();

		accountDto.setAccountName(accountEntity.getAccountName());

		accountDto.setAccountNumber(accountEntity.getAccountNumber());

		accountDto.setAccountType(accountEntity.getAccountType());

		accountDto.setBalanceDate(accountEntity.getBalanceDate());

		accountDto.setOpeningAvailableBalance(accountEntity.getOpeningAvailableBalance());

		return accountDto;
	}

}
