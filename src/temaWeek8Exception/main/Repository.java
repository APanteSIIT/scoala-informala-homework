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
	List<Student> studentRepo = new ArrayList<>();
	
	public static void main(String[] args) {
	
	}
	
//	create student method
	public Student createStudent(String firstName, String lastName, String dateOfBirth, String gender, String ID) {

		firstName = student.addFirstName(firstName);//calling addFirstName method for validation of method argument
		lastName = student.addLastName(lastName);//calling addLastName method for validation of method argument
		dateOfBirth = student.addDateOfBirth(dateOfBirth);//calling addDateOfBirth method for validation of method argument
		gender = student.addGender(gender);//calling addGender method for validation of method argument
		ID = student.addID(ID);//calling addID method for validation of method argument
		Student s = new Student(firstName, lastName, dateOfBirth, gender, ID);
		
		return s;
	}
	
	//	method for retrieving students of same  age and creating a new list called sameAge list
	public List<Student> retrieveStudentWithSameAge(String ageX,List<Student> studentRepo) throws Student.ExtendedException {
		List<Student> sameAge = new ArrayList<>();
		try {
		int	age = Integer.parseInt(ageX);
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
		}
		int	age = Integer.parseInt(ageX);
		
			if (age < 18){
		throw new Student.ExtendedException("Enter age bigger than 18!" );}
		
		
		int birthYear = Year.now().getValue() - age;
		String year = Integer.toString(birthYear);
		
//	iterator for finding the student with same age as method argument
		for (Student st : studentRepo) {
			if (year.equals(st.getDateOfBirth())) {
				sameAge.add(st);
			}
		}
		return sameAge;
	}
//	method to delete the student from studentRepo list based on ID
	public List<Student> deleteStudent(String ID, List<Student> studentRepo) throws NumberFormatException, Student.ExtendedException {
		
		try {
			Long studentID = Long.parseLong(ID);
		} catch (NumberFormatException e) {
			System.err.println("Invalid ID");
		}
		long studentID = Long.parseLong(ID);
		int length = String.valueOf(studentID).length();
		
		if(studentID==0||length!=13){
			throw new Student.ExtendedException("Student does not exist!");
		}
//	created iterator to find the student with same ID and to remove it from the studentRepo list
		Iterator<Student> it = studentRepo.iterator();
		while (it.hasNext()) {
			Student st = it.next();
			if (ID.equals(st.getID())) {
				it.remove();
			}
		}
		return studentRepo;
		}
//	method for sorting the collection of students
		public List<Student> sortStudent(List<Student> studentRepo){
		if(studentRepo.size()==0){
			throw new Student.ExtendedException("Student repository is empty!");
		}
		for(Student st:studentRepo){
			if(st.getFirstName()==""||st.getLastName()==""||st.getDateOfBirth()==""||st.getGender()==""||st.getID()==""){
				throw new Student.ExtendedException("Empty input!");
			}
		}
			Collections.sort(studentRepo, new Student.StudentComparator());
		
			return studentRepo;
		}
	
	
	
	
}
