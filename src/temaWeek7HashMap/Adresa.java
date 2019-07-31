package temaWeek7HashMap;


public class Adresa {
	private String streetName;
	private int no;
	private String city;
	private String country;
	
	public Adresa(String streetName, int no, String city, String country) {
		this.streetName = streetName;
		this.no = no;
		this.city = city;
		this.country = country;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Adresa{" +
				"streetName='" + streetName + '\'' +
				", no=" + no +
				", city='" + city + '\'' +
				", country='" + country + '\'' +
				'}';
	}
}
