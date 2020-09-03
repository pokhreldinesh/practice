package com.java.practice.interest;

import java.util.Scanner;

public class ComInterestCallReadingFloat {
	
	public static void main(String[] args) {
		int n = 12;
		float p = 0, r = 0, t = 0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter your investment amount: ");
		p = ReadingFloat.getFloat(input);
		
		System.out.print("Please enter the anual interest rate %: ");	
		r = ReadingFloat.getFloat(input);
		
		System.out.print("Please enter the number of years of investment: ");
		t = ReadingFloat.getFloat(input);
		
		double rate = r / 100;

		double a = p * Math.pow((1 + rate/n), (t * n));
		a = Math.round(a * 100.0) / 100.0;

		System.out.println("\nThe investment balance after " + t + " years is " + a);
		
		input.close();
	}
}
