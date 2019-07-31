package main;

public class Vegetable extends Product {
	private String vitamin;
	
	//	constructor of Animal class
	public Vegetable(String name, double price, String validityDate, double weight, String ID,String vitamin) {
		super(name,price, validityDate,weight, ID);
		this.vitamin=vitamin;
	}
	
	
	@Override
	public String setName(String name) {
		System.out.println("Enter  type of vegetable:carrots/potatoes/tomatoes: ");
		String input=scan.next();
		return input;
	}
	
	public String getVitamin() {
		return vitamin;
	}
	
	public String setVitamin() {
		return "vit A, vit C, vit B, vit E";
	}
	@Override
	public String getID() {
		return super.getID();
	}
	
	@Override
	public String toString() {
		return "VegetableProduct{" +
				"name='" + getName()  +
				", price=" + getPrice() +
				", validityDate='" + getValidityDate() + '\'' +
				", weight=" + getWeight() +
				", ID='" + getID()+ '\'' +
				", vitamins='" + getVitamin() + '\'' +
				'}';
	}
}
