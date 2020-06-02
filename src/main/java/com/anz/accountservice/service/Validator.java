package com.anz.accountservice.service;

public class Validator {

	public static boolean validateUserId(String userId) {

		String regexp = "[a-zA-z0-9@]+";

		if (userId.matches(regexp))

			return true;

		else

			return false;
	}

	public static boolean validateAccountNumber(Long accountNumber) {

		String regex = "[0-9] {9}";

		if (accountNumber.toString().matches(regex))

			return true;

		else

			return false;
	}

}
