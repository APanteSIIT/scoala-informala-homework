package temaWeek11InputOutput.test;

import org.junit.Test;
import temaWeek11InputOutput.main.Standings;
import temaWeek11InputOutput.main.utilities.CSV;
import temaWeek11InputOutput.main.Athlete;

import java.io.*;
import java.util.*;


import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class AthleteTest {
	
	private List<Athlete> athletesTest = new ArrayList<>();
	//	helper method to add athletes in a list for further testing scenarious
	public List<Athlete> addAthletesForTest() {
		String[] athelete1 = {"11", "Umar Jorgsn", "SK", "30:15", "xxxox", "xxxxx", "xxoxo"};
		String[] athelete2 = {"1", "Jimmy Smiles", "UK", "29:15", "xxoox", "xooxo", "xxxxo"};
		String[] athelete3 = {"27", "Piotr Smitzer", "CZ", "30:10", "xxxxx", "xxxxx", "xxxxx"};
		List<String[]> list = new ArrayList<>();
		list.add(athelete1);
		list.add(athelete2);
		list.add(athelete3);
		for (String[] array : list) {
			String athleteNumber = array[0];
			String athleteName = array[1];
			String countryCode = array[2];
			String time = array[3];
			String firstShootingRange = array[4];
			String secondShootingRange = array[5];
			String thirdShootingRange = array[6];
			
			athletesTest.add(new Athlete(athleteNumber, athleteName, countryCode, time,
					firstShootingRange, secondShootingRange, thirdShootingRange));
		}
		
		return athletesTest;
	}
	
	
	@Test
	public void testReadFromFile() {
		List<String[]> list = new LinkedList<>();
		Reader reader = new StringReader("apple,orange,banana");
		list.add(new String[]{"apple", "orange", "banana"});
		
		assertArrayEquals(list.toArray(), CSV.read(reader).toArray());
	}
	
	@Test()
	public void testIOException() {
		String file = "src" + File.separator + "skiBiathlonStandings" + File.separator + "utilities" + File.separator + "clasament.csv";
		String dateRow;
		try (BufferedReader in = new BufferedReader(new FileReader(file))) {
			while ((dateRow = in.readLine())!=null) {
				String[] dataRecords = dateRow.split(",");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			assertThat(e.getMessage(), containsString("IO exception"));
		}
		
	}
	
	@Test
	public void testFileNotFound() {
		String file = "File not found";
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			fail("Expected an FileNotFoundException to be thrown");
		} catch (FileNotFoundException e) {
			assertThat(e.getMessage(), containsString("File not found"));
		}
	}
	
	@Test
	public void testWinners() {
		athletesTest = addAthletesForTest();
		
		Collections.sort(athletesTest, new Standings.TimeComparator());
		Athlete winner = athletesTest.get(0);
		Athlete runner = athletesTest.get(1);
		Athlete thirdPlace = athletesTest.get(2);
		assertEquals("30:10", winner.getFinalTime());
		assertEquals("30:15", runner.getFinalTime());
		assertEquals("30:45", thirdPlace.getFinalTime());
		
	}
	
}
