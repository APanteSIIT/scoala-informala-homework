package temaWeek6LocalStore.main;
//subclass of Product class

public class Animal extends Product {
	
	private String storageTemp;
	
	
	//	constructor of Animal class
	public Animal(String name, double price, String validityDate, double weight, String ID, String storageTemp) {
		super(name,price, validityDate,weight, ID);//calling constructor from superclass
		this.storageTemp=storageTemp;
		
	}
	
	//	method for storageTemp
	public String setStorageTemp(String storageTemp) {
		System.out.println("Enter storage temperature: ");
		String input=scan.next();
		if(!isDouble(input)){
			System.out.println("Enter a valid temperature!");
			setStorageTemp(storageTemp);
		}
		return storageTemp=input+"°C";
	}
	
	public String getStorageTemp() {
		return storageTemp;
	}
	
	@Override
	public String setName(String name) {
		System.out.println("Enter  type of product:milk/cheese/yogurt: ");
		name=scan.next();
		return name;
	}
	@Override
	public double setPrice(double price) {	return super.setPrice(price);}
	
	@Override
	public String setValidityDate(String validityDate) {
		return super.setValidityDate(validityDate);
	}
	@Override
	public double setWeight(double weight) {
		return super.setWeight(weight);
	}
	@Override
	public String getID() {
		return super.getID();
	}
	
	@Override
	public String setID(String ID) {
		return super.setID(ID);
	}
	
	@Override
	public String toString() {
		return "MilkProduct{" +
				"name='" + getName() + '\'' +
				", price=" + getPrice() +
				", validityDate='" + getValidityDate() + '\'' +
				", weight=" + getWeight() +
				", ID='" + getID()+ '\'' +
				", storageTemp='" + getStorageTemp() + '\'' +
				'}';
	}
}
