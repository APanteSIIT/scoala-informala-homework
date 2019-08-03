package temaWeek8Exception.main;
/**
 * Class student with the following attributes:first name,
 * last name, date of birth, gender and CNP.
 */

import java.time.Year;
import java.util.Comparator;
import java.util.Objects;

public class Student {
	
	private final String firstName;
	private final String lastName;
	private final String dateOfBirth;
	private final String gender;
	private final String ID;
	
	//	class constructor
	public Student(String firstName, String lastName, String dateOfBirth, String gender, String ID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.ID = ID;
	}
	
	//	nested class ExtendedException which creates custom exception extended from RuntimeException class
	public static class ExtendedException extends RuntimeException {
		public ExtendedException(String message) {
			super(message);
		}
		
	}
	
	//	 method to set firstName, throws IllegalArgumentException when has an illegal argument
	public String addFirstName(String firstName) throws IllegalArgumentException {
		
		if (firstName==null || firstName.length()==0) {
			throw new IllegalArgumentException("Invalid name!");
		}
		return firstName;
	}
	
	//	 method to set lastName, throws IllegalArgumentException when has an illegal argument
	public String addLastName(String lastName) throws IllegalArgumentException {
		
		if (lastName==null || lastName.length()==0) {
			throw new IllegalArgumentException("Invalid name!");
		}
		return lastName;
	}
	
	//	method to set dateOfBirth,throws NumberFormatException and ExtendedException
	public String addDateOfBirth(String dateOfBirth) throws NumberFormatException, ExtendedException {
		
		final int y = Year.now().getValue() - 18;//calculates the year of birth as an int
		
		try {
			int date = Integer.parseInt(dateOfBirth);//transforms method argument into an int
			
		} catch (NumberFormatException e) {        //catching the NumberFormatException when argument method is
			System.err.println(e.getMessage());//not a numeric string type
		}
		int date = Integer.parseInt(dateOfBirth);
		if (date < 1900 || date > y) {//conditions for the year of birth
			throw new ExtendedException("Enter a year between 1900 and current date minus 18");
		}
		
		return dateOfBirth;
	}
	
	//	gender method which takes a String argument and throws IllegalArgumentException and ExtendedException
	public String addGender(String gender) throws IllegalArgumentException, ExtendedException {
		
		if (gender==null || gender.length()==0) {
			throw new IllegalArgumentException("Enter a valid gender!");
		}
		
		if ((!gender.equalsIgnoreCase("m")) && (!gender.equalsIgnoreCase("f"))) {
			throw new ExtendedException("Enter m/f");
		}
		
		return gender;
	}
	
	//	ID method which takes input from scanner and throws NumberFormatException and ExtendedException
	public String addID(String ID) throws IllegalArgumentException, ExtendedException {
		
		try {//takes argument and parse it as a decimal long number
			long studentID = Long.parseLong(ID);
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());//catches exception if not a decimal numbers
		}
		long studentID = Long.parseLong(ID);
		int length = String.valueOf(studentID).length();
		if (studentID==0 || length!=13) {
			throw new ExtendedException("Enter a 13 digit CNP");
		}
		
		return ID;
	}
	
	public static class StudentComparator implements Comparator {
		
		@Override
		public int compare(Object o1, Object o2) {
			Student s1 = (Student) o1;
			Student s2 = (Student) o2;
			return s1.getFirstName().compareTo(s2.getFirstName());
		}
	}
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getID() {
		return ID;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this==o) return true;
		if (o==null || getClass()!=o.getClass()) return false;
		Student student = (Student) o;
		return Objects.equals(firstName, student.firstName) &&
				Objects.equals(lastName, student.lastName) &&
				Objects.equals(dateOfBirth, student.dateOfBirth) &&
				Objects.equals(gender, student.gender) &&
				Objects.equals(ID, student.ID);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, dateOfBirth, gender, ID);
	}
	
	@Override
	public String toString() {
		return "Student{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", dateOfBirth='" + dateOfBirth + '\'' +
				", gender='" + gender + '\'' +
				", ID=" + ID +
				'}' + "\n";
	}
}
