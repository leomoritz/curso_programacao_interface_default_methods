package application;

import java.security.InvalidParameterException;
import java.util.Locale;
import java.util.Scanner;

import services.InterestService;
import services.UsaInterestService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Amount: ");
		double amount = sc.nextDouble();
		System.out.print("Months: ");
		int months = sc.nextInt();

		System.out.print("Interest: ");
		InterestService is = new UsaInterestService(sc.nextDouble());
		
		try {
			double payment = is.payment(amount, months);
			System.out.println("Payment after 3 months: \n" + String.format("%.2f", payment));

		} catch (InvalidParameterException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}

}
