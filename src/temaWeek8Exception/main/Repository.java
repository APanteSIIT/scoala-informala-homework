package temaWeek8Exception.main;

import java.time.Year;
import java.util.*;

public class Repository {
	String firstName = "";
	String lastName = "";
	String dateOfBirth = "";
	String gender = "";
	String ID = "";
	

	Student student = new Student(firstName, lastName, dateOfBirth, gender, ID);
	List<Student> studentRepo=new ArrayList<>();
	List<Student> sameAge=new ArrayList<>();
	
	
	public Student createStudent(String firstName, String lastName, String dateOfBirth, String gender, String ID) {
//		adds student firstName by calling addFirstName method from Student class
			try {
				firstName = student.addFirstName(firstName);
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
			}

//		adds student lastName by calling addLastName method from Student class
			try{
				lastName=student.addLastName(lastName);
			} catch (IllegalArgumentException e) {
				System.err.println( e.getMessage());
			}
	
//	adds student dateOfBirth by calling addDateOfBirth method from Student class
			try {
				dateOfBirth=student.addDateOfBirth(dateOfBirth);
			} catch (Student.ExtendedException e) {
				System.err.println( e.getMessage());
			}
	

// adds gender by calling addGender	method from Student class
			try {
				gender=student.addGender(gender);
			} catch (IllegalArgumentException | Student.ExtendedException e) {
				System.err.println(e.getMessage());
			}
		
//	adds ID by calling addID method from Student class
			try {
				ID=student.addID(ID);
			} catch (IllegalArgumentException | Student.ExtendedException e) {
				System.err.println(e.getMessage());
			}
		
			Student s=new Student(firstName, lastName, dateOfBirth, gender, ID);
	
		return s;
	}
	
//	method for retrieving students of same  age and creating a new list called sameAge list
	public List<Student> retrieveStudentWithSameAge (String ageX) {
		int age=0;
		try {
			age = Integer.parseInt(ageX);
		}catch (NumberFormatException e){
			System.out.println(e.getMessage());
		}
		if(age<0){
			throw new Student.ExtendedException("Enter age bigger than 18!");
		}
		
		int birthYear = Year.now().getValue() - age;
		String year = Integer.toString(birthYear);
		
		for (Student st : studentRepo) {
			if (year.equals(st.getDateOfBirth())) {
				sameAge.add(st);
			}
			if(!year.equals(st.getDateOfBirth())){
				System.out.println("No students with same age");
			}
		}
		return sameAge;
	}
	
	public List<Student> deleteStudent (String ID) throws Student.ExtendedException{
		
		ID = "";
			try {
				Long studentID = Long.parseLong(ID);
				} catch (NumberFormatException e) {
				System.err.println("Invalid ID");
				}
		if(ID.length()!=13) {
			throw new Student.ExtendedException("Student does not exist!");
		}
		
		Iterator<Student> it = studentRepo.iterator();
		while (it.hasNext()) {
			Student st = it.next();
			if (ID.equals(st.getID())) {
				it.remove();
			}
		}
		return studentRepo;
		}
}
