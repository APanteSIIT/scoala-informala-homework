package temaWeek8Exception.main;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	String firstName = "";
	String lastName = "";
	String dateOfBirth = "";
	String gender = "";
	String ID = "";
	
	Scanner sc = new Scanner(System.in);
	Student student = new Student(firstName, lastName, dateOfBirth, gender, ID);
	List<Student> studentRepo=new ArrayList<>();
	List<Student> sameAge=new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main=new Main();
		System.out.println("Welcome to student repository!");
		boolean running = true;
		while (running) {
			System.out.println(
					"\nEnter 0 for add students" +            //application menu
							"\n      1 for delete students" +
							"\n      2 for retrieve all students with same age" +
							"\n      3 for quit");
			String input = sc.next();
			switch (input) {
				case "0": {
					Student s=main.createStudent();
					main.studentRepo.add(s);
					break;
				}
				case "1": {
				
				}
				case "2": {
					System.out.println("Type age:");
					List<Student> sameAge=main.retrieveStudent(main.studentRepo);
					System.out.println(main.sameAge);
				}
			}
			
			
		}
	}
	
	public Student createStudent() {
		boolean notSucces = true;
//		Student student = new Student("ana", "marin", "1900", "f", "2222255566334");
		do {        //adds student firstName by calling addFirstName method from Student class
			try {    //loops to enter firstName if exception are cached
				firstName = student.addFirstName(firstName);
				notSucces = false;
			} catch (IllegalArgumentException | Student.ExtendedException | NullPointerException e) {
				System.err.println("Attention! " + e.getMessage());
				
			}
		} while (notSucces);

//		adds student lastName by calling addFirstName method from Student class
//		loops to enter lastName if exception are cached
		do {
			try {
				lastName=student.addLastName(lastName);
				notSucces = false;
			} catch (IllegalArgumentException e) {
				System.err.println("Attention! " + e.getMessage());
				
			}
		} while (notSucces);

//		adds student dateOfBirth by calling addDateOfBirth method from Student class
//		loops when dateOfBirth catches an exception
		do {
			try {
				dateOfBirth=student.addDateOfBirth(dateOfBirth);
				notSucces = false;
			} catch (Student.ExtendedException e) {
				System.err.println("Attention! " + e.getMessage());
				notSucces = true;
			}
		} while (notSucces);

// adds gender by calling addGender	method from Student class
//	loops when catches an exception
		do {
			try {
				gender=student.addGender(gender);
				notSucces = false;
			} catch (NullPointerException | Student.ExtendedException e) {
				System.err.println("Attention! " + e.getMessage());
				notSucces = true;
			}
		} while (notSucces);
//	adds ID by calling addID method from Student class
//	loops when catches an exception
		do {
			try {
				ID=student.addID(ID);
				notSucces = false;
			} catch (NumberFormatException | Student.ExtendedException e) {
				System.err.println("Attention! " + e.getMessage());
				notSucces = true;
			}
		} while (notSucces);
		
		Student s=new Student(firstName, lastName, dateOfBirth, gender, ID);
		System.out.println(s);
		return s;
	}
	public List<Student> retrieveStudent (List<Student> studentRepo) {
		boolean notSucces = true;
		int input = 0;
		do {
			try {
				input = Integer.parseInt(sc.next());
				notSucces = false;
			} catch (NumberFormatException | NoSuchElementException | IllegalStateException e) {
				System.out.println("Invalid input");
			}
		} while (notSucces);
		int birthYear = Year.now().getValue() - input;
		String year = Integer.toString(birthYear);
		
		for (Student st : studentRepo) {
			if (year.equals(st.getDateOfBirth())) {
				sameAge.add(st);
			}
		}
		return sameAge;
	}
}