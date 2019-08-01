package temaWeek8Exception.main;
/**
 * Class student with the following attributes:first name,
 * last name, date of birth, gender and CNP.
 *
 */

import java.time.Year;
import java.util.Scanner;


public class Student {
	
	private final String firstName;
	private final String lastName;
	private final String dateOfBirth;
	private final String gender;
	private final String ID;
	Scanner sc=new Scanner(System.in);
//	class constructor
	public Student(String firstName, String lastName, String dateOfBirth, String gender, String ID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.ID = ID;
	}
//	nested class ExtendedException which creates custom exception extended from RuntimeException class
	public class ExtendedException extends RuntimeException {
		public ExtendedException(String message) {
			super(message);
		}
		
	}
//	firstName method which take input from Scanner and throws IllegalArgumentException
	public String addFirstName(String firstName) throws IllegalArgumentException {
		System.out.println("Enter first name: ");
		firstName = sc.next();

		if (firstName==null||firstName.length()==0) {
			throw new IllegalArgumentException("Invalid name!");
		}

			return firstName;
	}
	//	lastName method which take input from Scanner and throws IllegalArgumentException
	public String addLastName(String lastName)throws IllegalArgumentException {
		
		System.out.println("Enter last name: ");
	
		lastName = sc.next();
		
		if (lastName==null||lastName.length()==0) {
			
			throw new IllegalArgumentException("Invalid name!");
		}
	
		return lastName;
	}
//	dateOfBirth method which takes input from scanner and throws NumberFormatException and ExtendedException
	public String addDateOfBirth(String dateOfBirth) throws NumberFormatException, ExtendedException{
		
		System.out.println("Enter year of birth: ");
		dateOfBirth=sc.next();//takes input from scanner
		final int y = Year.now().getValue() - 18;//helper int variable
		int date = 0;
		try {
			date = Integer.parseInt(dateOfBirth);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		
		if (date < 1900 || date > y) {
			throw new ExtendedException("Enter a year between 1900 and current date minus 18");
		}
		
		return dateOfBirth;
	}
//	gender method which takes input from scanner and throws NullPointerException and ExtendedException
	
	public String addGender(String gender)throws NullPointerException,ExtendedException{
		
		System.out.println("Enter gender: ");
		
		gender=sc.next();
		if(gender.length()==0||gender==null){
			throw new NullPointerException ("Enter a valid gender!");}
		
		if((!gender.equalsIgnoreCase("m"))&&(!gender.equalsIgnoreCase("f"))){
			throw new ExtendedException("Enter m/f");
		}
		
		return gender;
	}
	//	ID method which takes input from scanner and throws NumberFormatException and ExtendedException
	public String addID(String ID)throws NumberFormatException,ExtendedException {
		
		System.out.println("Enter ID: ");
	
		ID=sc.next();
		long studentID=0;
		try{
			studentID=Long.parseLong(ID);
		} catch (NumberFormatException e){
			System.err.println(e.getMessage());
		}
		int length=(int)Math.floor(Math.log10(studentID) + 1);
		
		if(length!=13){
			throw new ExtendedException("Enter a 13 digit CNP");
		}
		
		return ID;
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
	public String toString() {
		return "Student{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", dateOfBirth='" + dateOfBirth + '\'' +
				", gender='" + gender + '\'' +
				", ID=" + ID +
				'}'+"\n";
	}
}
