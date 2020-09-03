package com.java.practice.foodstamp;

public class FoodstampReceiver {
	private String firstName, lastName, street, city, state;
	private int houseNumber;
	private int headCount;
	private double income;
	public final int ID;   // use final to declare constant 
	private static int objectCount = 0;

	
	public FoodstampReceiver(String firstName, String lastName, int houseNumber, 
			String street, String city, String state, int headCount, double income) {
		ID = ++objectCount;
		setFirstName(firstName);
		setLastName(lastName);
		setHouseNumber(houseNumber);
		setStreet(street);
		setCity(city);
		setState(state);
		setHeadCount(headCount);
		setIncome(income);	
	}
	
	public FoodstampReceiver(String firstName, String lastName, int headCount, double income,
			int houseNumber, String street, String city, String state) {
		ID = ++objectCount;
		setFirstName(firstName);
		setLastName(lastName);
		setHeadCount(headCount);
		setIncome(income);	
		setHouseNumber(houseNumber);
		setStreet(street);
		setCity(city);
		setState(state);
	}
	
	public FoodstampReceiver(String firstName, String lastName, int headCount, double income) {
		this(firstName, lastName, 0, 0, 0, "","","");
	}
	
	public FoodstampReceiver(String firstName, String lastName) {
		this(firstName, lastName, 0, 0);
	}
	
	public FoodstampReceiver() {
		this("--", "--");
	}
	
	public static int getObjectCount() {
		return objectCount;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public double getIncome() {
		return income;
	}
	
	public void setFirstName(String firstName) {
		if (firstName.equals(""))
			firstName = "--";
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName.equals(""))
			lastName = "--";
		this.lastName = lastName;
	}
	
	public void setHouseNumber(int houseNumber) {
		if (houseNumber < 0)
			houseNumber=Math.abs(-houseNumber);
		this.houseNumber = houseNumber;
	}
	
	public void setStreet(String street) {
		if (street.equals(""))
			street = "--";
		this.street = street;
	}
	
	public void setCity(String city) {
		if (city.equals(""))
			city = "--";
		this.city = city;
	}
	
	public void setState(String state) {
		if (state.equals(""))
			state = "--";
		this.state = state;
	}
	
	public void setHeadCount(int headCount) {
		if (headCount == 0)
			headCount = 1;
		this.headCount =headCount;
	}
	
	public void setIncome(double income) {
		if (income < 0 )
			income = 0;
		this.income = income;
	}
	
	public boolean getFoodstamp() {
		if (income <= 10000 && headCount == 1)
			return true;
		if (income <= 25000 && headCount >= 2)
			return true;
		if (income <= 40000 && headCount >= 3)
			return true;
		if (income <= 60000 && headCount >= 4)
			return true;
		if (income <= 100000 && headCount >= 5)
			return true;
		return false;
	}
	
	public String toString() {
		return "{" + ID + ", First Name: " + firstName + ", Last Name:  " + lastName + ", Income:  "
				+ income + ", Head Count: " + headCount + ", Eligible for Foodstamp: " +getFoodstamp() + 
				"\nAddress: " + houseNumber + " " + street + ", " + city + ", " + state + "}\n";
	}
}
