package com.java.practice.interest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadingFloat {

	public static float getFloat(Scanner input) {

		float amount = 0;

		do {
			try {
				if (amount < 0)
					System.out.print("Number cannot be negative! Please re-enter your number: ");
				amount = input.nextFloat();

			} catch (InputMismatchException e) {
				System.out.print("Number you enter is invalid! Please re-enter your number: ");
				amount = 0;
				input.next();
			}
		} while (amount <= 0);
		
		return amount;
	}
}
