package com.anz.accountservice.dto;

import java.time.LocalDate;

import com.anz.accountservice.entity.TransactionEntity;

public class TransactionDto {

	private long accountNumber;

	private String accountName;

	private LocalDate valueDate;

	private String currency;

	private double debitAmount;

	private String transactionType;

	private String transactionNarrative;

	public TransactionDto() {

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

	public static TransactionDto toDto(TransactionEntity transactionEntity) {

		TransactionDto transactionDto = new TransactionDto();

		transactionDto.setAccountName(transactionEntity.getAccountName());

		transactionDto.setAccountNumber(transactionEntity.getAccountNumber());

		transactionDto.setCurrency(transactionEntity.getCurrency());

		transactionDto.setDebitAmount(transactionEntity.getDebitAmount());

		transactionDto.setTransactionNarrative(transactionEntity.getTransactionNarrative());

		transactionDto.setTransactionType(transactionEntity.getTransactionType());

		transactionDto.setValueDate(transactionEntity.getValueDate());

		return transactionDto;
	}

}
