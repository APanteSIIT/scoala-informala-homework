package temaWeek12Enum.Main;

import temaWeek12Enum.Main.utilities.CSV;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AppPerson {
	
	private static final String location = "src\\temaWeek12Enum\\Main\\Utilities";
	private static final String extension = ".txt";
	private static List<Person> persons = new ArrayList<>();
	
	public static void main(String[] args) {
		FindFilesByExt files = new FindFilesByExt(extension);
		File folder = new File(location);
		String[] fileList = folder.list(files);
		List<String[]> records = new ArrayList<>();
		
		for (String file : fileList) {
			String temp = new StringBuffer(location).append(File.separator)
					.append(file).toString();
//			System.out.println("file : " + temp);
			records = CSV.readFromFile(temp);
			for (String[] pers : records) {
				String name = pers[0];
				String birthDate = pers[1];
				String gender = pers[2];
				persons.add(new Person(name, birthDate, gender));
			}
			
		}
		
	}
}