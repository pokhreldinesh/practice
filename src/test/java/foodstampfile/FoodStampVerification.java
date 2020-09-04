package test.java.foodstampfile;

public class FoodStampVerification {
	private String firstName, lastName, street, city, county;
	private int houseNumber;
	private int headCountInt;
	private double income;
	public final int ID;   // use final to declare constant 
	private static int objectCount = 0;

	
	public FoodStampVerification(String firstName, String lastName, int houseNumber, 
			String street, String city, String County, int headCountInt, double income) {
		ID = ++objectCount;
		setFirstName(firstName);
		setLastName(lastName);
		setHouseNumber(houseNumber);
		setStreet(street);
		setCity(city);
		setCounty(County);
		setHeadCountInt(headCountInt);
		setIncome(income);	
	}
	
	public FoodStampVerification(String firstName, String lastName, int headCount, double income,
			int houseNumber, String street, String city, String county) {
		ID = ++objectCount;
		setFirstName(firstName);
		setLastName(lastName);
		setHeadCountInt(headCount);
		setIncome(income);	
		setHouseNumber(houseNumber);
		setStreet(street);
		setCity(city);
		setCounty(county);
	}
	
	public FoodStampVerification(String firstName, String lastName, int headCountInt, double income) {
		this(firstName, lastName, headCountInt, income, 0, "","","");
	}
	
	public FoodStampVerification(String firstName, String lastName) {
		this(firstName, lastName, 0, 0);
	}
	
	public FoodStampVerification() {
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
	
	public void setCounty(String county) {
		if (county.equals(""))
			county = "--";
		this.county = county;
	}
	
	public void setHeadCountInt(int headCountInt) {
		if (headCountInt == 0)
			headCountInt = 1;
		this.headCountInt =headCountInt;
	}
	
	public void setIncome(double income) {
		if (income < 0 )
			income = 0;
		this.income = income;
	}
	
	public boolean getFoodstamp() {
		if (income <= 10000 && headCountInt == 1)
			return true;
		if (income <= 25000 && headCountInt >= 2)
			return true;
		if (income <= 40000 && headCountInt >= 3)
			return true;
		if (income <= 60000 && headCountInt >= 4)
			return true;
		if (income <= 100000 && headCountInt >= 5)
			return true;
		return false;
	}
	
	public String toString() {
		return "{" + ID + ", First Name: " + firstName + ", Last Name:  " + lastName + ", Income:  "
				+ income + ", Head Count: " + headCountInt + "\nAddress: " + houseNumber + " " 
				+ street + ", " + city + ", " + county + ", Eligible for Foodstamp: " +getFoodstamp() + "}\n";
	}
}

