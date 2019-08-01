package temaWeek8Exception.test;

import org.junit.Test;
import temaWeek8Exception.main.Student;

public class StudentTest {
	
	@Test (expected=NullPointerException.class)
	public void testWhenStudentFirstNameisNull(){
		Student s=new Student("","Ana","1983","f","2830815282228");
		s.addFirstName(null);
		}
	
}
