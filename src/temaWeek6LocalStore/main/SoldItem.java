package temaWeek6LocalStore.main;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

//class that holds the sold items
public class SoldItem{
	private String saleDate;
	private String ID;
	private StockItem stockItem;
	int quantity;
	
	
	//	constructor
	public SoldItem(StockItem stockItem, String saleDate) {
		this.stockItem=stockItem;
//		this.stockItem=stockItem.duplicate();
		this.saleDate = saleDate;
	}
	
	
	public String setSaleDate(){
		
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
		saleDate = formatter.format(LocalDate.now());
		
		return saleDate;
	}
	
	public int setQuantity(int quantity){
		return this.quantity=quantity;
	}
	
	public String getSaleDate() {
		return saleDate;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getID() {
		return stockItem.getID();
		
	}
	
	@Override
	public boolean equals(Object o) {
		if (this==o) return true;
		if (o==null || getClass()!=o.getClass()) return false;
		SoldItem soldItem = (SoldItem) o;
		return quantity==soldItem.quantity &&
				Objects.equals(saleDate, soldItem.saleDate) &&
				Objects.equals(ID, soldItem.ID) &&
				Objects.equals(stockItem, soldItem.stockItem);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(saleDate, ID, quantity);
	}
	
	@Override
	public String toString() {
		return "SoldItems{" +
				"saleDate='" + saleDate + '\'' +
				", qty=" + stockItem.getQuantity() +
				", ID=" + stockItem.getID()+
				'}';
		
	}
}
