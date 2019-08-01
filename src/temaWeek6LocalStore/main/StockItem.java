package temaWeek6LocalStore.main;

import java.util.Scanner;
//class that holds the items in the stock and adds an extra property:quantity
public class StockItem {
	Scanner scan=new Scanner(System.in);
	private int quantity;
	private Product prod;// aggregation


//	constructor based on superclass Product
	
	public StockItem(Product prod,int quantity) {
		this.prod=prod;//aggregation
		this.quantity = quantity;
		
	}
	
	
	
	public int getQuantity() {
		return quantity;
	}
	
	
	public int setQuantity(int quantity) {
		return this.quantity=quantity;
	}
	
	//method that sets the qty of an item in the stock
	public int setQuantity() {
		String input;
		do{
			System.out.println("Enter quantity: ");
			input=scan.next();}
		while(!isInteger(input));
		
		quantity=Integer.parseInt(input);
		return quantity;
	}
	
	
	public static boolean isInteger(String s) {
		boolean isValidInteger = false;
		try
		{
			Integer.parseInt(s);
			isValidInteger = true;
		}
		catch (NumberFormatException ex)
		{
			isValidInteger = false;
			
		}
		return isValidInteger;
	}
	
	public String getID() {
		return prod.getID();
	}
	public String getName() { return prod.getName();}
	public double getWeight() { return prod.getWeight();}
	public String getValidityDate() {
		return prod.getValidityDate();
	}
	public double getPrice() { return prod.getPrice();}
	
	
	public StockItem duplicate() {
		return new StockItem(prod, quantity);
	}
	
	@Override
	public String toString() {
		return "StockItem{" +
				"qty=" + quantity +
				", prod=" + prod +
				'}'+"\n";
	}
}
