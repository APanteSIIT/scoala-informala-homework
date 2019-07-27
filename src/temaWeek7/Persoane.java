package temaWeek7;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Persoane {

	private String name;
	private int age;
	
	
//	@Override
//	public int compareTo(Persoane o) {
//
//		return getName().compareTo(o.getName());
//	}
	
	
	//	class constructor
	public Persoane (String name) {
		this.name = name;

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
	
////	equals method to compare Persoane objects;
//	public boolean equals(Persoane o) {
//		if (this==null) return false;
//		if(this==o) return true;
//		if(getClass()!=o.getClass()) return false;
//		Persoane i=(Persoane) o;
//		if(i.getName().equals(o.getName())) return true;
//		return false;
//	}
	
//	@Override
//	public boolean equals(Object o) {
//		return false;
//	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
	public static void main(String[] args) {
		String name="1";
		Persoane a=new Persoane(name);
		Set<String> pers=new HashSet<>();
//		Student student1=new Student("Ioana");
//		Student student2=new Student("Maria");
//		Student student3=new Student("Viorica");
//
//		Somer somer1=new Somer("Vasile",45);
//		Somer somer2=new Somer("Petru",25);
//		Somer somer3=new Somer("George",40);
//
//		Angajat angajat1=new Angajat("Carmen",32);
//		Angajat angajat2=new Angajat("Cristina",38);
//		Angajat angajat3=new Angajat("Ion",55);
//
		pers.add("maria");
		pers.add("ioana");
		
		pers.add("vasilica");
//		pers.add(somer1);
//		pers.add(somer2);
//		pers.add(somer3);
//		pers.add(angajat1);
//		pers.add(angajat2);
//		pers.add(angajat3);
		
		for (String p : pers) {
			System.out.println(p.toString()+ " "+ a.hashCode());
//			System.out.println("Persoana este:" + p.getName() + " with age:"
//					+ p.getAge());
		}
		
		
	}
	
	@Override
	public boolean equals(Object o) {
		if (this==o) return true;
		if (o==null || getClass()!=o.getClass()) return false;
		Persoane persoane = (Persoane) o;
		return age==persoane.age &&
				Objects.equals(name, persoane.name);
	}
	
	@Override
	public String toString() {
		return "Persoane{" +
				"name='" + name + '\'' +
				
				'}';
	}
}
