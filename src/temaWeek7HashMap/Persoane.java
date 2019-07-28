package temaWeek7HashMap;
//2. You need to store some information about some persons: for one person, you need a list of his/her hobbies;
//		Define for Hobby a class that contains:
//
//		Name of hobby (String) – eq: cycling, swimming
//		Frequency (int) – how many times a week they practice it
//		List of Addresses where this hobby can be practiced (List<Adresa>)
//		You will use a HashMap
//
//<Persoana, List<Hobby>>
//		NOTE: equals() from Persoana must be overriden
//		Add some information to this map; for a certain Persoana, print the names of the hobbies and the countries where it can be practiced
//		USE THE ALREADY DEFINED CLASSES: PERSOANA, SOMER, ANGAJAT, STUDENT; ADRESA; TARA;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Persoane {

	private String name;
	private int age;
	Hobby hobby;
	
	//	class constructor
	public Persoane (String name, int age) {
		this.name = name;
		this.age=age;

	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public static void main(String[] args) {
		Student student=new Student("Ionel",25);
		Somer somer=new Somer("Vasile",55);
		Angajat angajat=new Angajat("Maria",35);
		
		Adresa adresa1=new Adresa("Campuilui",1,"Rasnov","Ro");
		Adresa adresa2=new Adresa("Zorilor",25,"Brasov","Ro");
		Adresa adresa3=new Adresa("Victoriei",55,"Bucuresti","Ro");
		Adresa adresa4=new Adresa("Republicii",55,"Zarnesti","Ro");
		
		Hobby cyclism=new Hobby("cyclism",2,adresa1);
		Hobby football=new Hobby("football",1,adresa2);
		Hobby handball=new Hobby("handball",3,adresa3);
		Hobby chess=new Hobby("chess",3,adresa4);
		
		List<Hobby> hobbies1=new ArrayList<>();
		List<Hobby> hobbies2=new ArrayList<>();
		List<Hobby> hobbies3=new ArrayList<>();
		
		hobbies1.add(cyclism);
		hobbies1.add(football);
		hobbies2.add(handball);
		hobbies2.add(chess);
		hobbies3.add(chess);
		hobbies3.add(cyclism);
		
		
		HashMap<Persoane,List<Hobby>> map=new HashMap<>();
		map.put(student,hobbies1);
		map.put(angajat,hobbies2);
		map.put(somer,hobbies3);
		
		System.out.println(map.get(student));
	
		
	}
	
	@Override
	public boolean equals(Object o) {
		if (this==o) return true;
		if (o==null || getClass()!=o.getClass()) return false;
		Persoane persoane = (Persoane) o;
		return age==persoane.age &&
				Objects.equals(name, persoane.name) &&
				Objects.equals(hobby, persoane.hobby);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, age, hobby);
	}
	
	@Override
	public String toString() {
		return "Persoane{" +
				"name='" + name + '\'' +
				"age=" +
				'}';
	}
}
