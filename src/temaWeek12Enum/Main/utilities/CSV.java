package temaWeek12Enum.Main.utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSV {
	
	public static List<String[]> readFromFile(String fileName) {
		
		List<String[]> list=new ArrayList<>();
		
			String line;
			try(BufferedReader br=new BufferedReader(new FileReader(fileName))){
				while((line=br.readLine())!=null) {
					String[] dateRecords=line.split(",");
					list.add(dateRecords);
				}
			}catch (FileNotFoundException e){
				System.err.println("FileNotFound exception found");
			}catch (IOException e){
				System.err.println("IOException was caught!");
			}
		
		
		return list;
	}
}
