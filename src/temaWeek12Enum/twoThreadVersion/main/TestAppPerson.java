package temaWeek12Enum.twoThreadVersion.main;


import org.junit.Test;
import temaWeek12Enum.twoThreadVersion.main.utilities.TXT;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestAppPerson {
	
	@Test
	public void testFilesExtension() throws IOException {
		String location = "src\\temaWeek12Enum\\oneThreadVersion\\test";
		String extension = ".txt";
		FindFilesByExt find = new FindFilesByExt(extension);
		File folder = new File(location);
		
		String[] fileList = folder.list(find);
		for (String file : fileList) {
			assertEquals(true, file.contains(".txt"));
		}
	}
	
	@Test
	public void testReadFromFile() {
		List<Person> personsSamples = new LinkedList<>();
		
		personsSamples.add(new Person("Son Willms", "1955-11-10", "male"));
		personsSamples.add(new Person("Eufemia Kiehn", "1997-05-06", "female"));
		personsSamples.add(new Person("Doris Davis", "1960-05-07", "1"));
		personsSamples.add(new Person("Blake Wintheiser", "2001-03-19", "0"));
		
		String location = "src\\temaWeek12Enum\\oneThreadVersion\\test";
		String extension = ".txt";
		
		File folder = new File(location);
		FindFilesByExt find = new FindFilesByExt(extension);
		List<String[]> records;
		String[] files = folder.list(find);
		List<Person> persons = new LinkedList<>();
		for (String file : files) {
			String temp = new StringBuffer(location).append(File.separator)
					.append(file).toString();
			
			records = TXT.readFromFile(temp);
			for (String[] s : records) {
				String name = s[0];
				String birthDate = s[1];
				String gender = s[2];
				persons.add(new Person(name, birthDate, gender));
			}
			
		}
		assertEquals(personsSamples.size(), persons.size());
		assertArrayEquals(personsSamples.toArray(), persons.toArray());
	}
	
	@Test
	public void testWriteToFile() throws IOException{
		List<Person> personsSamples = new LinkedList<>();
		
		personsSamples.add(new Person("Eufemia Kiehn", "1997-05-06", "female"));
		personsSamples.add(new Person("Blake Wintheiser", "2001-03-19", "0"));
		
		File file = TXT.writeToFile(personsSamples, "FemaleTest.txt");
		
		Path path = Paths.get("FemaleTest.txt");
		long lineCount = Files.lines(path).count();
		
		assertEquals(2,lineCount);
		
		
		}
		
		
	}
	
