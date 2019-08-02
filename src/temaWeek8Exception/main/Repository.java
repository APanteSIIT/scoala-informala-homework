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
//
		firstName = student.addFirstName(firstName);
		lastName=student.addLastName(lastName);
		dateOfBirth=student.addDateOfBirth(dateOfBirth);
		gender=student.addGender(gender);
		ID=student.addID(ID);
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
