package temaWeek11InputOutput.main;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class SkiBiathlonApp {
	
	static private List<Athlete> athletes=new LinkedList<>();
	
	public static void main(String[] args) {
		
		String file="src"+ File.separator+"temaWeek11InputOutput"+File.separator+"main"+File.separator+"utilities"+File.separator+"clasament.csv";
		List<String[]> list=new LinkedList<>();
		try (Reader reader=new FileReader(file)){
			list=temaWeek11InputOutput.main.utilities.CSV.read(reader);
		}catch (FileNotFoundException e){
			System.out.println("File not found exception");
		}catch (IOException e){
			System.out.println("IOException");
		}
		
		for(String[] array:list){
			String athleteNumber=array[0];
			String athleteName=array[1];
			String countryCode=array[2];
			String time=array[3];
			String firstShootingRange=array[4];
			String secondShootingRange=array[5];
			String thirdShootingRange=array[6];
			
			athletes.add(new Athlete(athleteNumber,athleteName,countryCode,time,
					firstShootingRange,secondShootingRange,thirdShootingRange));
		}
//	printing each athlete from the list
		for(Athlete a:athletes){
			System.out.println(a);
		}
//		calling showWinner method to display the winners
		Standings.showWinners(athletes);
	}
	
}
