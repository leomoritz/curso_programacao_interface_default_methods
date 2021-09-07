package application;

import java.security.InvalidParameterException;
import java.util.Locale;
import java.util.Scanner;

import services.BrazilInterestService;
import services.InterestService;
import services.UsaInterestService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		double totalPayment;

		System.out.print("Amount: ");
		double amount = sc.nextDouble();
		System.out.print("Months: ");
		int months = sc.nextInt();

		System.out.print("Interest USA: ");
		InterestService isUsa = new UsaInterestService(sc.nextDouble());
		System.out.print("Interest Brazil: ");
		InterestService isBrazil = new BrazilInterestService(sc.nextDouble());

		try {

			totalPayment = isUsa.payment(amount, months);
			System.out.println("Total payment after 3 months in USA: \n" + String.format("%.2f", totalPayment));
			totalPayment = isBrazil.payment(amount, months);
			System.out.println("Total payment after 3 months in Brazil: \n" + String.format("%.2f", totalPayment));

		} catch (InvalidParameterException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}

}
