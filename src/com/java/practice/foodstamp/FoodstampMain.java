package com.java.practice.foodstamp;

public class FoodstampMain{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FoodstampReceiver appl1, appl2, appl3, appl4;
		appl1 = new FoodstampReceiver("Ritu", "Bhattarai", 4, 60000);
		appl2 = new FoodstampReceiver("Dinesh", "Pokhrel", 5, 150000,120, "Dixon Landing", "Milpitas", "CA");
		appl3 = new FoodstampReceiver("Thuy", "Ng", 5, 90000);
		appl4 = new FoodstampReceiver();
		System.out.println(appl1);
		System.out.println(appl2);
		System.out.println(appl3);
		System.out.println(appl4);
	}

}
