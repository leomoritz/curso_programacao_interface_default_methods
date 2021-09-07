package services;

import java.security.InvalidParameterException;

public interface InterestService {
	
	double getInterestRate();
	default double payment(double amount, int months) {
		if (months < 1) {
			throw new InvalidParameterException("Months must be greater than zero");
		}
		double totalInterest = Math.pow((1 + getInterestRate() / 100), months);
		double totalPayment = amount * totalInterest;
		return totalPayment;
	}

}
