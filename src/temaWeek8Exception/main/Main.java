package temaWeek8Exception.main;


import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		Repository repo=new Repository();
		Student student=new Student("Ana","Marisn","1990","f","2222222222222");
		Student student2=new Student("Ion","Grigore","2000","m","11111111111111");
		Student student3=new Student("Vasile","Burca","2000","m","7777777777777");
		
		List<Student> studentRepo=new ArrayList<>();
		studentRepo.add(student);
		studentRepo.add(student2);
		studentRepo.add(student3);
		List<Student> sameAge=new ArrayList<>();
		
		
	}
}
