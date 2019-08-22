package temaWeek11InputOutput.main.utilities;

import java.io.*;

import java.util.LinkedList;
import java.util.List;

public class CSV {
	
	//	method reads a data from a csv file and return as a list
	public static List<String[]> read(Reader reader){
		
		List<String[]> data=new LinkedList<>();
		String dateRow;
		
		try (BufferedReader in=new BufferedReader(reader)){
			while((dateRow=in.readLine())!=null){
				String[] dataRecords=dateRow.split(",");
				data.add(dataRecords);
			}
		}catch (FileNotFoundException e){
//			System.out.println("File not found or other reasons");
		}catch (IOException e){
			System.out.println("IO exception");
		}
		
		return data;
	}
	
}