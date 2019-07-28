package temaWeek7HashMap;

public class Angajat extends Persoane {
	

	public Angajat(String name,int age) {
		
		super(name,age);
		
	}
	
	@Override
	public String toString() {
		return "Angajat{" +
				"hobby=" + hobby +
				'}';
	}
}
