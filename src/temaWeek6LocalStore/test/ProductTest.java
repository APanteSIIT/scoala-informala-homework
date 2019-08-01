package temaWeek6LocalStore.test;

import org.junit.Test;
import temaWeek6LocalStore.main.Animal;
import temaWeek6LocalStore.main.Product;
import temaWeek6LocalStore.main.Vegetable;
import temaWeek6LocalStore.main.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;


import static org.junit.Assert.*;


public class ProductTest {
	
	final double DELTA = 1e-15;
	
	@Test
	public void testProduct(){
		
		Product p=new Product("milk",2.2,"10",1.2,"458b");
		assertEquals("milk",p.getName());
		assertEquals(2.2,p.getPrice(),DELTA);
		assertEquals("10",p.getValidityDate());
		assertEquals(1.2,p.getWeight(),DELTA);
		assertEquals("458b",p.getID());
	}
	@Test
	public void testAnimal() {
		Animal a = new Animal("milk", 2.2, "10", 1.2, "458b", "5");
		assertEquals("milk", a.getName());
		assertEquals(2.2, a.getPrice(), DELTA);
		assertEquals("10", a.getValidityDate());
		assertEquals(1.2, a.getWeight(), DELTA);
		assertEquals("458b", a.getID());
		assertEquals("5", a.getStorageTemp());
		
	}
	@Test
	public void testVegetable() {
		Vegetable v = new Vegetable("carrot", 2.2, "10", 1.2, "458b", "vit A, vit C, vit B, vit E");
		assertEquals("carrot", v.getName());
		assertEquals(2.2, v.getPrice(), DELTA);
		assertEquals("10", v.getValidityDate());
		assertEquals(1.2, v.getWeight(), DELTA);
		assertEquals("458b", v.getID());
		assertEquals("vit A, vit C, vit B, vit E", v.getVitamin());
	}
	@Test
	public void testStockItem() {
		Animal a = new Animal("milk", 2.2, "10", 1.2, "458b", "5");
		Vegetable v = new Vegetable("carrot", 2.2, "10", 1.2, "458b", "vit A, vit C, vit B, vit E");
		StockItem s = new StockItem(v, 5);
		
		assertEquals("carrot", v.getName());
		assertEquals(2.2, v.getPrice(),DELTA);
		assertEquals("10", v.getValidityDate());
		assertEquals(1.2, v.getWeight(),DELTA);
		assertEquals(1.2, v.getWeight(),DELTA);
		assertEquals("458b", v.getID());
		
		StockItem s2 = new StockItem(a, 5);
		assertEquals("milk", a.getName());
		assertEquals("5", a.getStorageTemp());
		
		
	}
	@Test
	public void testSoldItem() {
		
		Vegetable v = new Vegetable("carrot", 2.2, "10", 1.2, "458b", "vit A, vit C, vit B, vit E");
		StockItem s = new StockItem(v, 5);
		SoldItem sold=new SoldItem(s,"2019-07-24");
		assertEquals("carrot",s.getName());
		assertEquals(2.2,s.getPrice(),DELTA);
		assertEquals("10",s.getValidityDate());
		assertEquals(1.2,s.getWeight(),DELTA);
		assertEquals("458b",s.getID());
		assertEquals("vit A, vit C, vit B, vit E",v.getVitamin());
		assertEquals("2019-07-24",sold.getSaleDate());
		
	}
	
	@Test
	public void testSellProduct() {
		List<StockItem> stock=new ArrayList<>();
		String inputID="458b";
		String inputQuantity="5";
		Animal a = new Animal("milk", 2.2, "10", 1.2, "45", "5");
		Vegetable v = new Vegetable("carrot", 2.2, "10", 1.2, "458b", "vit A, vit C, vit B, vit E");
		StockItem veg = new StockItem(v, 5);
		StockItem anim = new StockItem(a, 6);
		
		
		stock.add(veg);
		stock.add(anim);
		LocalStore lc=new LocalStore();
		List<StockItem> sold=lc.sellProduct(stock,"458b",5);
		List<StockItem> remaining=new ArrayList<>();
		remaining.add(anim);
		assertArrayEquals(remaining.toArray(),sold.toArray());
		
	}
	@Test
	public void addSoldItems(){
		List<StockItem> stock=new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
		String formattedDate = formatter.format(LocalDate.now());
		
		
		Vegetable v = new Vegetable("carrot", 2.2, "10", 1.2, "458b", "vit A, vit C, vit B, vit E");
		StockItem veg = new StockItem(v, 2);
		
		SoldItem veg2=new SoldItem(veg,formatter.format(LocalDate.now()));
		List<SoldItem> newList=new ArrayList<>();
		newList.add(veg2);
		
		StockItem veg3 = new StockItem(v, 4);
		stock.add(veg3);
		
		
		LocalStore lc=new LocalStore();
		List<SoldItem> remainingItem=new ArrayList<>();
		
		
		List<SoldItem> sold=lc.addSoldItems(stock,remainingItem,"458b",2);
		
		SoldItem s=sold.get(0);
		
		assertEquals(newList.size(),sold.size());
		assertEquals(veg.getID(),s.getID());
		assertEquals(veg2.getQuantity(),s.getQuantity());
		
		
		
	}
	
	@Test
	public void testScanner() {
		
		String data = "Enter  type of product:milk/cheese/yogurt: \r\n";
		InputStream stdin = System.in;
		try {
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner scanner = new Scanner(System.in);
			System.out.println(scanner.nextLine());
		} finally {
			System.setIn(stdin);
		}
		
		
	}
}


