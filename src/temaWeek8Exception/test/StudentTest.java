package temaWeek8Exception.test;

import org.junit.Test;
import org.junit.*;
import temaWeek8Exception.main.Repository;
import temaWeek8Exception.main.Student;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void testWhenStudentFirstNameIsNull() {
		Student s = new Student("", "Ana", "1983", "f", "2830815282228");
		s.addFirstName(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWhenStudentFirstNameLengthIsZero() {
		Student s = new Student("", "Ana", "1983", "f", "2830815282228");
		s.addFirstName("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWhenStudentLastNameIsNull() {
		Student s = new Student("", "Ana", "1983", "f", "2830815282228");
		s.addLastName(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWhenStudentLastNameLengthIsZero() {
		Student s = new Student("", "Ana", "1983", "f", "2830815282228");
		s.addLastName("");
	}
	
	@Test(expected = NumberFormatException.class)
	public void testWhenStudentDateBirthIsNull() {
		Student s = new Student("", "Ana", "1983", "f", "2830815282228");
		s.addDateOfBirth(null);
	}
	
	@Test(expected = Student.ExtendedException.class)
	public void testWhenStudentDateBirthIsSmallerThan1900() {
		Student s = new Student("", "Ana", "1983", "f", "2830815282228");
		s.addDateOfBirth("1890");
	}
	
	@Test(expected = Student.ExtendedException.class)
	public void testWhenStudentDateBirthIsBiggerThan2001() {
		Student s = new Student("", "Ana", "1983", "f", "2830815282228");
		s.addDateOfBirth("2010");
	}
	
	@Test(expected = NumberFormatException.class)
	public void testWhenStudentDateBirthIsNotANumber() {
		Student s = new Student("", "Ana", "1983", "f", "2830815282228");
		s.addDateOfBirth("1c");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWhenGenderIsNull() {
		Student s = new Student("", "Ana", "1983", "f", "2830815282228");
		s.addGender(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWhenGenderIsEmpty() {
		Student s = new Student("", "Ana", "1983", "f", "2830815282228");
		s.addGender("");
	}
	
	@Test
	public void testWhenGenderIsForM() {
		Student s = new Student("", "Ana", "1983", "f", "2830815282228");
		s.addGender("f");
	}
	
	@Test(expected = NumberFormatException.class)
	public void testWhenIDisNull() {
		Student s = new Student("", "Ana", "1983", "f", "2830815282228");
		s.addID(null);
	}
	
	@Test(expected = Student.ExtendedException.class)
	public void testWhenIDLengthIsDifferentThan13() {
		Student s = new Student("", "Ana", "1983", "f", "2830815282228");
		s.addID("12");
	}
	
	@Test(expected = NumberFormatException.class)
	public void testWhenIDIsNotANumber() {
		Student s = new Student("", "Ana", "1983", "f", "2830815282228");
		s.addID("sd");
	}
	
	@Test
	public void testCreateStudent() {
		Repository rep = new Repository();
		String firstName = "b";
		String lastName = "a";
		String dateOfBirth = "1900";
		String gender = "f";
		String ID = "1111111111111";
		Student s = rep.createStudent(firstName, lastName, dateOfBirth, gender, ID);
		
	}
	
	@Test
	public void testDeleteStudent() {
		Repository rep = new Repository();
		String firstName = "b";
		String lastName = "a";
		String dateOfBirth = "1900";
		String gender = "f";
		String ID = "1111111111111";
		Student s = rep.createStudent("Ion", "Nastase", "1980", "m", "2222222222222");
		Student s2 = rep.createStudent("Marius", "Calin", "1990", "m", "5555555555555");
		List<Student> students = new ArrayList<>();
		students.add(s);
		students.add(s2);
		List<Student> remainingStudents = rep.deleteStudent("2222222222222", students);
		List<Student> compList = new ArrayList<>();
		compList.add(s2);
		assertEquals(compList, remainingStudents);
		
	}
	
	@Test(expected = NumberFormatException.class)
	public void testDeleteStudentWhenIdIsNotANumber() {
		Repository rep = new Repository();
		Student s = rep.createStudent("Ion", "Nastase", "1980", "m", "2222222222222");
		Student s2 = rep.createStudent("Marius", "Calin", "1990", "m", "5555555555555");
		List<Student> students = new ArrayList<>();
		students.add(s);
		students.add(s2);
		List<Student> remainingStudents = rep.deleteStudent("ssss", students);
		
		
	}
	
	@Test(expected = Student.ExtendedException.class)
	public void testDeleteStudentWhenIdIsNotWrongLength() {
		Repository rep = new Repository();
		Student s = rep.createStudent("Ion", "Nastase", "1980", "m", "2222222222222");
		Student s2 = rep.createStudent("Marius", "Calin", "1990", "m", "5555555555555");
		List<Student> students = new ArrayList<>();
		students.add(s);
		students.add(s2);
		List<Student> remainingStudents = rep.deleteStudent("2222", students);
	}
	@Test
	public void testRetrieveStudentsWithSameAge() {
		Repository rep = new Repository();
		Student s = rep.createStudent("Ion", "Nastase", "1980", "m", "2222222222222");
		Student s2 = rep.createStudent("Marius", "Calin", "1990", "m", "5555555555555");
		List<Student> students = new ArrayList<>();
		students.add(s);
		students.add(s2);
		List<Student> studentsWithSameAge = rep.retrieveStudentWithSameAge("39",students);
		List<Student> st = new ArrayList<>();
		st.add(s);
		assertEquals(st,studentsWithSameAge);
		
			}
	@Test (expected=NumberFormatException.class)
	public void testRetrieveStudentsWithSameAgeWhenAgeIsNotANumber() {
		Repository rep = new Repository();
		Student s = rep.createStudent("Ion", "Nastase", "1980", "m", "2222222222222");
		Student s2 = rep.createStudent("Marius", "Calin", "1990", "m", "5555555555555");
		List<Student> students = new ArrayList<>();
		students.add(s);
		students.add(s2);
		List<Student> studentsWithSameAge = rep.retrieveStudentWithSameAge("s", students);
		
	}
	
	@Test (expected=Student.ExtendedException.class)
	public void testRetrieveStudentsWithSameAgeWhenAgeIsSmallerThan18() {
		Repository rep = new Repository();
		Student s = rep.createStudent("Ion", "Nastase", "1980", "m", "2222222222222");
		Student s2 = rep.createStudent("Marius", "Calin", "1990", "m", "5555555555555");
		List<Student> students = new ArrayList<>();
		students.add(s);
		students.add(s2);
		List<Student> studentsWithSameAge = rep.retrieveStudentWithSameAge("17", students);
		
	}
	
	
	@Test (expected=Student.ExtendedException.class)
	public void testSortStudent(){
		List<Student> students = new ArrayList<>();
		Repository rep = new Repository();
		Student s1=new Student("","Marin","1980","f","2222222222222");
		Student s2=new Student("Maria","Condrea","1990","f","1111111111111");
		Student s3=new Student("George","Urzica","","m","7777777777777");
		Student s4=new Student("Viorica","Damian","1995","f","5555555555555");
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
//		List<Student> sortedListToCompare= new ArrayList<>();
//		sortedListToCompare.add(s1);
//		sortedListToCompare.add(s3);
//		sortedListToCompare.add(s2);
//		sortedListToCompare.add(s4);
		List<Student> sortedList=rep.sortStudent(students);
		
//		assertEquals(sortedListToCompare,sortedList);
	
	}
}

