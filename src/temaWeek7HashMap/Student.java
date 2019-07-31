package temaWeek7HashMap;

public class Student extends Persoane {
	
	
	public Student(String name,int age) {
		super(name,age);
		
	}
	
	
	@Override
	public String toString() {
		return "Student{"+"name="+super.getName()+ ", age="+super.getAge()+
				'}';
	}
}
