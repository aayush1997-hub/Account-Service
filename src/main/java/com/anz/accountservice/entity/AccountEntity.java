package com.anz.accountservice.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountEntity {

	@Id
	private long accountNumber;

	private String accountName;

	private String accountType;

	private LocalDate balanceDate;

	private String userId;

	private double openingAvailableBalance;

	public AccountEntity() {

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

	public String getUserId() {

		return userId;
	}

	public void setUserId(String userId) {

		this.userId = userId;
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

}
