package com.anz.accountservice.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TransactionEntity {

	@Id
	@GeneratedValue
	private int id;

	private long accountNumber;

	private String accountName;

	private LocalDate valueDate;

	private String currency;

	private double debitAmount;

	private String transactionType;

	private String transactionNarrative;

	public TransactionEntity() {

	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
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

	public LocalDate getValueDate() {

		return valueDate;
	}

	public void setValueDate(LocalDate valueDate) {

		this.valueDate = valueDate;
	}

	public String getCurrency() {

		return currency;
	}

	public void setCurrency(String currency) {

		this.currency = currency;
	}

	public double getDebitAmount() {

		return debitAmount;
	}

	public void setDebitAmount(double debitAmount) {

		this.debitAmount = debitAmount;
	}

	public String getTransactionType() {

		return transactionType;
	}

	public void setTransactionType(String transactionType) {

		this.transactionType = transactionType;
	}

	public String getTransactionNarrative() {

		return transactionNarrative;
	}

	public void setTransactionNarrative(String transactionNarrative) {

		this.transactionNarrative = transactionNarrative;
	}

}
