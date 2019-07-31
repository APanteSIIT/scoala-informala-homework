package main;

/**
 * This is a program which simulates the operations at a store. The store has a list of item in stock.
 * Each item refers to a product and has a stock number (could be 0 if it's out of stock).A product is identified uniquely by an ID.
 * The products are animal and vegetable from a local farm.
 * All products have on their packaging the price, validity date and weight.
 * The animal products in the store are the following: milk, eggs and various other products made out of milk (such as cheese, yogurt, sour cream).
 * All animal products have on their packaging storage temperature.
 * All vegetable products have a name and describe on their packaging a list of vitamins they contain.
 */

public class Main {
	
	public static void main(String[] args) {
		LocalStore lc=new LocalStore();
		lc.getMenu();//calling menu
		
		
	}
	
}
