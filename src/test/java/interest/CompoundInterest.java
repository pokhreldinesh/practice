package test.java.interest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CompoundInterest {

	public static void main(String[] args) {

		int n = 12;
		float p = 0, r = 0, t = 0;
		
		Scanner input = new Scanner(System.in);

		System.out.print("Please enter your investment amount: ");
		do {
			try {
				if (p < 0)
					System.out.print("Number cannot be negative! Please re-enter your number: ");
				p = input.nextFloat();
			}
			catch (InputMismatchException e){
				System.out.print("Number you enter is invalid! Please re-enter your number: ");
				p = 0;
				input.next();
			}
		} while (p <= 0);
		
		System.out.print("Please enter the anual interest rate %: ");	
		do {
			try {
				if (r < 0)
					System.out.print("Number cannot be negative! Please re-enter your number: ");
				r = input.nextFloat();
			}
			catch (InputMismatchException e){
				System.out.print("Number you enter is invalid! Please re-enter your number: ");
				r = 0;
				input.next();
			}
		} while (r <= 0);
		
		System.out.print("Please enter the number of years of investment: ");
		do {
			try {
				if (t < 0)
					System.out.print("Number cannot be negative! Please re-enter your number: ");
				t = input.nextFloat();
			}
			catch (InputMismatchException e){
				System.out.print("Number you enter is invalid! Please re-enter your number: ");
				t = 0;
				input.next();
			}
		} while (t <= 0);
		
		double rate = r / 100;

		double a = p * Math.pow((1 + rate/n), (t * n));
		a = Math.round(a * 100.0) / 100.0;

		System.out.println("\nThe investment balance after " + t + " years is " + a);
		
		input.close();
		
	}

}
