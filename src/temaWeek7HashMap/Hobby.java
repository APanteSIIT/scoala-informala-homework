package temaWeek7HashMap;


public class Hobby {
	
	private String hobbyName;
	private int frequency;
	Adresa adresa;
	
	public Hobby(String hobbyName, int frequency, Adresa adresa) {
		this.hobbyName = hobbyName;
		this.frequency = frequency;
		this.adresa = adresa;
	}
	
	public String getHobbyName() {
		return hobbyName;
	}
	
	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	public Adresa getAdresa() {
		return adresa;
	}
	
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	
	@Override
	public String toString() {
		return "Hobby{" +
				hobbyName +", "+
				"country= "+ adresa.getCountry()+'\'' +
				'}';
	}
}
