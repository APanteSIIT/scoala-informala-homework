package temaWeek12Enum.oneThreadVersion.Main.utilities;

import temaWeek12Enum.oneThreadVersion.Main.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TXT {
//	method that reads from a file and returns a list of array strings
	public static List<String[]> readFromFile(String fileName) {
		
		List<String[]> list = new ArrayList<>();
		
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while ((line = br.readLine())!=null) {
				String[] dateRecords = line.split(",");
				list.add(dateRecords);
			}
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFound exception found");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IOException was caught!");
			e.printStackTrace();
		}
		
		
		return list;
	}
//	method to write in a new file from a list of Persons
	public static File writeToFile(List<Person> list,String filename) {
		
		try (BufferedWriter bw = new BufferedWriter(new PrintWriter(filename))) {
			for (int i = 0; i < list.size(); i++) {
				String birthDate = list.get(i).getBirthDate();
				String name = list.get(i).getName();
//				writing to a file with a specific format
				bw.write("Happy Birthday " + list.get(i).getFirstName(name) + "(" +
						list.get(i).getYearOfBirth(birthDate) + ")!");
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("IOException was found");
			e.printStackTrace();
		}
		return new File(filename);
	}
	
}
	

