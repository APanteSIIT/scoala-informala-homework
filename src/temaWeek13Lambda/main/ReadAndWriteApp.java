package temaWeek13Lambda.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/* App description:
	By using streams and lamba expressions, implement a small application which:
	1.load from a file a structure like first name, last name, date of birth
	2. write back another file containing only first name, last name ordered
	alphabetically for all the of all matches which have the birthday on a month indicated.

Application takes 3 params:
	1. input filename
	2. target month (1-12)
	3. output file name
 */
 
public class ReadAndWriteApp {
	private static String input="src"+File.separator+"temaWeek13Lambda"+File.separator+"main"+File.separator+"utilities"+File.separator+"MOCK_DATA.csv";
	private static String output="Output.txt";
	
	public static void main(String[] args) {
	
	
		ReadAndWriteApp app=new ReadAndWriteApp();
		
		app.readWriteToFile(input,"12",output);
		
	}
//	method for reading from a file and writhing on another file
	public void readWriteToFile(String input,String month,String output){
		
		try(BufferedReader br=Files.newBufferedReader(Paths.get(input))){
			Stream<String> lines=br.lines()
					.filter(line->line.contains("-"+month+"-"))//filtering upon month
					.map(line->line.substring(0,line.lastIndexOf(",")))//extracting only the firstname and lastname to be writhed in another file
					.sorted();//sorting in alphabetical order
			Files.write(Paths.get(output),(Iterable<String>) lines::iterator);//writhing each line from stream lines in output file
			
		}catch (IOException e){
			System.err.println("Caught IOException ");
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public static String getInput() {
		return input;
	}
}
