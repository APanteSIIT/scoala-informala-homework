package temaWeek7Comparable;


import java.util.Set;
import java.util.TreeSet;

public class Persoane implements Comparable<Persoane> {

	private String name;
	private int age;
	
	
	@Override
	public int compareTo(Persoane o) {
	
		return getName().compareTo(o.getName());
	}
	
	
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
	
		
		Set<Persoane> pers=new TreeSet<>();
		Student student1=new Student("Ioana",25);
		Student student2=new Student("Maria",20);
		Student student3=new Student("Viorica",19);

		Somer somer1=new Somer("Vasile",45);
		Somer somer2=new Somer("Petru",25);
		Somer somer3=new Somer("George",40);

		Angajat angajat1=new Angajat("Carmen",32);
		Angajat angajat2=new Angajat("Cristina",38);
		Angajat angajat3=new Angajat("Ion",55);

		pers.add(student1);
		pers.add(student2);
		pers.add(student3);
		pers.add(somer1);
		pers.add(somer2);
		pers.add(somer3);
		pers.add(angajat1);
		pers.add(angajat2);
		pers.add(angajat3);
		
		for (Persoane p : pers) {
			System.out.println("Persoana este:" + p.getName() + " with age:"
					+ p.getAge());
		}
		
		
	}
	
	
	@Override
	public String toString() {
		return "Persoane{" +
				"name='" + name + '\'' +
				"age=" +
				'}';
	}
}
