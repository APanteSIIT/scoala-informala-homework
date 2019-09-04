package temaWeek12Enum.oneThreadVersion.Main;

import temaWeek12Enum.oneThreadVersion.Main.utilities.TXT;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppPerson {
	
	private static final String location = "src\\temaWeek12Enum\\oneThreadVersion\\Main\\utilities";
	private static final String extension = ".txt";
	private static List<Person> persons = new ArrayList<>();
	private static List<Person> female = new ArrayList<>();
	
	
	public static void main(String[] args) throws InterruptedException {
		long startTime=System.currentTimeMillis();
		
		
//		create an instance of FindFilesByExt which searches a file based on .txt extension
		FindFilesByExt files = new FindFilesByExt(extension);
		//		create a folder using location string
		File folder = new File(location);
//		create an array of strings containing all .txt files from folder
		String[] fileList = folder.list(files);
		List<String[]> records ;
//		loops into the fileList containing .txt files and reads each row as a record in a records list;
		for (String file : fileList) {
			String temp = new StringBuffer(location).append(File.separator)
					.append(file).toString();
 
			records = TXT.readFromFile(temp);
//			loops on each record and creates person object with name,birthDate, gender arguments
				for (String[] pers : records) {
					String name = pers[0];
					String birthDate = pers[1];
					String gender = pers[2];
					persons.add(new Person(name, birthDate, gender));
				
				}
		}
//	loops the List<Person> persons and adds in List<Person> female the persons with female gender and date of birth 08-15
		for (Person person : persons) {
			if (person.getGender().equals("FEMALE")) {
				if(person.getDayAndMonthOfBirth().equals("08-15"))
				female.add(person);
			}
		}
//		call the writeToFile method from TXT class
//		write to a new file called Female.txt persons from List<Person> female
		TXT.writeToFile(female,"Female1.txt");
		
//		find in how many milisec main thread runs
		Thread.sleep(3000);
		
		long endTime = System.currentTimeMillis();
		long time=endTime-startTime;
		System.out.println("that took:" +  time);// 3374
		
		
	}
	
	
}