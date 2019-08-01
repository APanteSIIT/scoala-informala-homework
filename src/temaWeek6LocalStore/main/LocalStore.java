package temaWeek6LocalStore.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LocalStore {
	private String name;
	private double price;
	private String validityDate;
	private double weight;
	private String ID;
	private String storageTemp;
	private String vitamin;
	private int quantity;
	private String saleDate;
	private int inputQuantity;
	private Product prod;
	
	List<StockItem> stockItems=new ArrayList<>();
	List<SoldItem> soldItems=new ArrayList<>();
	
	
	
	Product p=new Product(name,price,validityDate,weight,ID);
	StockItem stock=new StockItem(new Animal(name,price, validityDate,weight, ID,storageTemp),quantity);
	StockItem sold=new StockItem(new Animal(name,price, validityDate,weight, ID,storageTemp),quantity);
	StockItem vegetableItem=new StockItem(new Vegetable(name,price, validityDate,weight, ID,vitamin),quantity);
	
	
	//	menu
	public void getMenu() {
		boolean running = true;
		
		System.out.println("Welcome to LocalStore!");
		while (running) {
			System.out.println("\n Enter your choice: " +//options in the menu
					"\n 1.Create product and add it to stock" +
					"\n 2.Sell products" +
					"\n 3.Display daily sales report" +
					"\n 4.Exit");
			
			
			Scanner scan = new Scanner(System.in);
			String option = scan.next();
			LocalStore lc = new LocalStore();
			switch (option) {
				case "1": {
					System.out.println("Product type (1 - animal; 2 - vegetable):");
					String type = scan.next();
					if (type.equals("1")) {//adds an animal product to stockItem
						
						lc.addToStockAnimal(stockItems);
						break;
					}
					if (type.equals("2")) {//adds an vegetable product to stockItem
						lc.addToStockVegetable(stockItems);
						break;
					}
					if(!type.equals("1")||!type.equals("2")){
						System.out.println("Enter 1 or 2!");
						break;
					}
				}
				case "2": {//sell products based on input
					System.out.println("Items in stock: \n"+stockItems);
					System.out.println("Enter ID ");
					String inputID = scan.next();
					lc.setInputQuantity(inputQuantity);
					inputQuantity=lc.getInputQuantity();
					lc.addSoldItems( stockItems,soldItems,inputID,inputQuantity);//adds sold items to soldItem list
					lc.sellProduct(stockItems,inputID,inputQuantity);
					//updates the list of stockItems based on input
					System.out.println("");
					System.out.println("Remaining items in stock: \n"+stockItems);//print remaining items in the stockList
					break;
					
				}
				case "3": {
					System.out.println("");
					printSoldItems(soldItems);//print soldItem list
					break;
				}
				case "4": {
					running = false;
				}
			}
			
		}
		
	}
	//	method created a stockItem of type animal
	public StockItem createAnimalProduct() {
		Animal a=new Animal(name,price, validityDate,weight, ID,storageTemp);

//		calling name method
		name=a.setName(name);

//		calling setPrice method
		price=a.setPrice(price);

//		calling setValidityDate method
		validityDate=a.setValidityDate(validityDate);

//		calling setWeight method
		weight=a.setWeight(weight);

//		calling setID method
		ID=a.setID(ID);
		
		//		calling setStorageTemperature
		storageTemp=a.setStorageTemp(storageTemp);

//		calling quantity method form StockItem
		quantity=this.stock.setQuantity();
		Product p=new Product(name,price, validityDate,weight, ID);
		
		Animal a1=new Animal(name,price, validityDate,weight, ID,storageTemp);
		p=a1;
		return new StockItem(a1,quantity);
	}
	
	//method creates a vegetable product and adds the item to the list of stockItems
	public List<StockItem> addToStockAnimal(List<StockItem> stockItems){
		StockItem s=createAnimalProduct();
		stockItems.add(s);
		return stockItems;
	}
	//	method created a stockItem of type vegetable
	public StockItem createVegetableProduct() {
		Vegetable v=new Vegetable(name,price, validityDate,weight, ID, vitamin);
//		calling name method
		name=v.setName(name);

//		calling setPrice method
		price=v.setPrice(price);

//		calling setValidityDate method
		validityDate=v.setValidityDate(validityDate);

//		calling setWeight method
		weight=v.setWeight(weight);

//		calling setID method
		ID=v.setID(ID);

//		calling setVitamin
		vitamin=v.setVitamin();

//		calling quantity method form StockItem
		quantity=this.vegetableItem.setQuantity();
		
		Vegetable v1=new Vegetable(name,price, validityDate,weight, ID,vitamin);
		p=v1;
		return new StockItem(p,quantity);
		
	}
	
	//method creates a vegetable product and adds the item to the list of stockItems
	public List<StockItem> addToStockVegetable(List<StockItem> stockItems){
		StockItem v=createVegetableProduct();
		stockItems.add(v);
		return stockItems;
	}
	
	//	sellProduct method that updates the stockItem list
//	if all quantity of an item si selled the method will delete item
	public List<StockItem> sellProduct(List<StockItem> stockItems,String inputID,int inputQuantity) {
		List<StockItem> toRemove = new ArrayList<>();// new list that will be printed empty when stockItem quantity=0;
		for (StockItem item : stockItems) {
			
			int q=item.getQuantity() - inputQuantity;
			if (inputID.equals(item.getID())) {
				if ((item.getQuantity() >= 0)){
					if(q==0){
						toRemove.add(item);//adds stockItem to the new list
					}
					
				}
				if ((item.getQuantity() >= 0)){
					if(q >= 0){
						item.setQuantity(q);//sets the remaining quantity of sold stockItem
					}
				}
			}
			if(toRemove.size()==1) {
				stockItems.removeAll(toRemove);
				return stockItems;
			}
		}
		return stockItems;
	}
	
	
	public List<SoldItem> addSoldItems(List<StockItem> stockItems,List<SoldItem> soldItems,String inputID,int inputQuantity) {
		
		
		for(StockItem item:stockItems) {
			
			int q=item.getQuantity() -inputQuantity ;
			
			if (inputID.equals(item.getID())) {
				if (q==0) {
					StockItem sold=item.duplicate();
					sold.setQuantity(quantity);
					SoldItem s = new SoldItem(sold, saleDate);
					s.setSaleDate();
					saleDate =s.getSaleDate();
					SoldItem s1 = new SoldItem(sold, saleDate);
					soldItems.add(s1);
				}
			}
			if (inputID.equals(item.getID())) {
				if(q >0) {
					StockItem sold=item.duplicate();
					sold.setQuantity(inputQuantity);
					SoldItem s = new SoldItem(sold, saleDate);
					s.setSaleDate();
					saleDate =s.getSaleDate();
					SoldItem s1 = new SoldItem(sold, saleDate);
					soldItems.add(s1);
				}
			}
			
		}
		
		return soldItems;
		
	}
	
	public void printSoldItems(List<SoldItem> soldItems){
		System.out.println(soldItems);
		
	}
	public int setInputQuantity(int inputQuantity){
		Scanner scan=new Scanner (System.in);
		System.out.println("Enter quantity: ");
		inputQuantity = Integer.parseInt(scan.next());
		return this.inputQuantity=inputQuantity;
	}
	
	
	public int getInputQuantity() {
		return inputQuantity;
	}
	
	
	
	@Override
	public String toString() {
		
		return "LocalStore{" +
				"prod=" + p.toString();
	}
}


