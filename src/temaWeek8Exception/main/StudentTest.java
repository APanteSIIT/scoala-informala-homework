package temaWeek8Exception.main;

import org.junit.Test;
import temaWeek8Exception.main.Repository;
import temaWeek8Exception.main.Student;

public class StudentTest {
	
	@Test (expected=IllegalArgumentException.class)
	public void testWhenStudentFirstNameIsNull(){
		Student s=new Student("","Ana","1983","f","2830815282228");
		s.addFirstName(null);
		}
		
	@Test (expected=IllegalArgumentException.class)
	public void testWhenStudentFirstNameLengthIsZero(){
		Student s=new Student("","Ana","1983","f","2830815282228");
		s.addFirstName("");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testWhenStudentLastNameIsNull(){
		Student s=new Student("","Ana","1983","f","2830815282228");
		s.addLastName(null);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testWhenStudentLastNameLengthIsZero(){
		Student s=new Student("","Ana","1983","f","2830815282228");
		s.addLastName("");
	}
	
	@Test (expected= Student.ExtendedException.class)
	public void testWhenStudentDateBirthIsNull(){
		Student s=new Student("","Ana","1983","f","2830815282228");
		s.addDateOfBirth(null);
	}
	
	@Test (expected= Student.ExtendedException.class)
	public void testWhenStudentDateBirthIsSmallerThan1900(){
		Student s=new Student("","Ana","1983","f","2830815282228");
		s.addDateOfBirth("1890");
	}
	
	@Test (expected= Student.ExtendedException.class)
	public void testWhenStudentDateBirthIsBiggerThan2001(){
		Student s=new Student("","Ana","1983","f","2830815282228");
		s.addDateOfBirth("2010");
	}
	@Test (expected= IllegalArgumentException.class)
	public void testWhenGenderIsNull(){
		Student s=new Student("","Ana","1983","f","2830815282228");
		s.addGender(null);
	}
	@Test (expected= IllegalArgumentException.class)
	public void testWhenGenderIsEmpty(){
		Student s=new Student("","Ana","1983","f","2830815282228");
		s.addGender("");
	}
	
	@Test
	public void testWhenGenderIsForM(){
		Student s=new Student("","Ana","1983","f","2830815282228");
		s.addGender("f");
	}
	
	@Test (expected= Student.ExtendedException.class)
	public void testWhenIDisNull(){
		Student s=new Student("","Ana","1983","f","2830815282228");
		s.addID(null);
	}
	
	@Test (expected= Student.ExtendedException.class)
	public void testWhenIDLengthIsDifferentThan13(){
		Student s=new Student("","Ana","1983","f","2830815282228");
		s.addID("12");
	}
	@Test (expected= Student.ExtendedException.class)
	public void testWhenIDIsNotANumber(){
		Student s=new Student("","Ana","1983","f","2830815282228");
		s.addID("sd");
	}
	
	@Test
	public void testCreateStudent (){
		Repository rep=new Repository();
		String firstName = "b";
		String lastName = "a";
		String dateOfBirth = "1900";
		String gender = "f";
		String ID = "1111111111111";
		Student s=rep.createStudent(firstName,lastName,dateOfBirth,gender,ID);
		
	}
	
	
}
