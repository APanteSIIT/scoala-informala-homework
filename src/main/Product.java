package main;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


//this is the superclass products which is extended by the Animal and Vegetable classes
public class Product {
	
	private String name;
	private double price;
	private String validityDate;
	private double weight;
	private String ID;
	Scanner scan=new Scanner(System.in);
	
	
	//	constructor of the Product class
	public Product(String name, double price, String validityDate, double weight, String ID) {
		this.name=name;
		this.price = price;
		this.validityDate = validityDate;
		this.weight = weight;
		this.ID = ID;
		
	}
	
	public String getName() {
		return name;
	}
	
	public String setName(String name) {
		return this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double setPrice(double price) {
		System.out.println("Enter price: ");
		String p = scan.next();
		if (isDouble(p)) {
			price = Double.parseDouble(p);
			return price;
		}
		if(!isDouble(p)){
			System.out.println("Enter a valid price!");
			setPrice(price);
		}
		return price;
	}
	
	public static boolean isDouble(String s) {
		boolean isValidDouble = false;
		try
		{
			Double.parseDouble(s);
			isValidDouble = true;
		}
		catch (NumberFormatException ex)
		{
			System.out.println("Not a double");
			isValidDouble = false;
		}
		return isValidDouble;
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
	
	//	sets validityDate based on remaining nr of days  from the time the product is added in the stock
//	enter integers >0;
	public String setValidityDate(String validityDate) {
		DateTimeFormatter formatter;
		String input;
		do{
			formatter = DateTimeFormatter.ISO_DATE;
			String formattedDate = formatter.format(LocalDate.now());//setts the validitydate based on actual date
			System.out.println("Enter validity days (from this day)"+formattedDate + ": ");
			input=scan.next();}
		while (!isNumber(input));
		int v =Integer.parseInt(input);
		Period period = Period.ofDays(v);
		System.out.println("expiration date is: " + period.addTo(LocalDate.now()));
		validityDate= formatter.format(period.addTo(LocalDate.now()));
		return validityDate;
	}
	
	public boolean isNumber(String input) {
		
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if(c >= '0' && c <= '9'){
				return  true;
			}
			if (c>= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
				return false;
			}
			if (input.valueOf(i).matches("[^a-zA-Z0-9]")) {
				return false;
			}
		}
		return true;
	}
	
	public String getValidityDate()  {
		return validityDate;
	}
	
	
	public double getWeight() {
		return weight;
	}
	
	public double setWeight(double weight) {
		String input;
		do {
			System.out.println("Enter weight(kg/l): ");
			input=scan.next();}
		while (!isDouble(input));
		
		weight=Double.parseDouble(input);
		return weight;
	}
	
	public String getID() {
		return ID;
	}
	
	public String setID(String ID) {
		System.out.println("Enter an unique ID: ");
		ID=scan.next();
		return ID;
	}
	
	@Override
	public String toString() {
		return "Product{" +
				"name="+
				", price=" + price +
				", validityDate='" + validityDate + '\'' +
				", weight=" + weight +
				", ID='" + ID + '\'' +
				'}';
	}
}
