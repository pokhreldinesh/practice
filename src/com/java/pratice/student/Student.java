package com.java.pratice.student;

public class Student {
	int a; // initialized to zero
	static int b; // initialized to zero only when class is loaded not for each object created.

	Student() {
		// Constructor incrementing static variable b
		b++;
	}

	public void showData() {
		System.out.println("Value of a = " + a);
		System.out.println("Value of b = " + b);
	}

	public void increment() {
		a++;
	}
}
