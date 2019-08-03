package temaWeek7Comparator;
/**
 * Implemented 2 comparators on a treeSet of persons:NameComparator and AgeComparator
 */


import java.util.*;

public class Persoane {

	private String name;
	private int age;
	
	

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
//		added persons to the TreeSet
		Student student1=new Student("Ioana",25);
		Student student2=new Student("Maria",20);
		Student student3=new Student("Viorica",19);

		Somer somer1=new Somer("Vasile",45);
		Somer somer2=new Somer("Petru",25);
		Somer somer3=new Somer("George",40);

		Angajat angajat1=new Angajat("Carmen",32);
		Angajat angajat2=new Angajat("Cristina",38);
		Angajat angajat3=new Angajat("Ion",55);
//		defined the TreeSet pers
//		passed the NameComparator in constructor of the TreeSet
		Set<Persoane> pers=new TreeSet<>(new NameComparator());
		pers.add(student1);
		pers.add(student2);
		pers.add(student3);
		pers.add(somer1);
		pers.add(somer2);
		pers.add(somer3);
		pers.add(angajat1);
		pers.add(angajat2);
		pers.add(angajat3);
		//		passed the AgeComparator in constructor of the TreeSet
		Set<Persoane> pers2=new TreeSet<>(new AgeComparator());
		pers2.add(student1);
		pers2.add(student2);
		pers2.add(student3);
		pers2.add(somer1);
		pers2.add(somer2);
		pers2.add(somer3);
		pers2.add(angajat1);
		pers2.add(angajat2);
		pers2.add(angajat3);
		
		System.out.println(("Sorting with comparator NameComparator: "));
//iterated thru the TreeSet pers with NameComparator
		for (Persoane p : pers) {
			System.out.println(p.getName()+" age " +p.getAge() );
			
		}
		System.out.println("    ");
//iterated thru the TreeSet pers2 with AgeComparator
		System.out.println(("Sorting with comparator AgeComparator: "));
		
		for (Persoane p : pers2) {
			System.out.println(p.getName()+" age " +p.getAge() );
			
		}
		
		
	}
	
	
	@Override
	public String toString() {
		return "Persoane{" +
				"name='" + name + '\'' +
				"age=" +
				'}';
	}
	
//	class AgeComparator
	public static class AgeComparator implements Comparator {
//	override compare method fotm AgeComparator
		@Override
		public int compare(Object o1, Object o2) {
			Persoane p1=(Persoane)o1;//cast of firs object to Persoane
			Persoane p2=(Persoane)o2;//cast of second object to Persoane
			if(p1.getAge()==p2.getAge()) return 0;
			if(p1.getAge()<p2.getAge()) return -1;
			else return 1;
		}
	}
//	class NameComparator
	public static class NameComparator implements Comparator<Persoane>{
		
//override the compare method from NameComparator
		@Override
		public int compare(Persoane o1, Persoane o2) {
			Persoane p1=(Persoane)o1;//cast of first object to Persoane
			Persoane p2=(Persoane)o2;//cast of second object to Persoane
			return (p1.getName()).compareTo(p2.getName());
			
			
		}
	}
	
}
