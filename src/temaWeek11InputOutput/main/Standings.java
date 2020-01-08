package temaWeek11InputOutput.main;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Standings {
	
	//	method for sorting and showing the first 3 places based on total time
	public static void showWinners(List<? super Athlete> list){
		Collections.sort(list,new Standings.TimeComparator());
		Athlete winner=(Athlete) list.get(0);
		Athlete runnerUp=(Athlete) list.get(1);
		Athlete thirdPlace=(Athlete) list.get(2);
		System.out.println("Winner -"+ winner.getAthlName()+" "+ winner.getFinalTime()+
				"("+winner.getSkiTimeResult()+ "+" + winner.getPenalty()+")");
		System.out.println("Runner-Up -"+ runnerUp.getAthlName()+" "+ runnerUp.getFinalTime()+
				"("+runnerUp.getSkiTimeResult()+ "+" + runnerUp.getPenalty()+")");
		System.out.println("Third Place -"+ thirdPlace.getAthlName()+" "+ thirdPlace.getFinalTime()+
				"("+thirdPlace.getSkiTimeResult()+ "+" + thirdPlace.getPenalty()+")");
	}
	//	class TimeComparator which compares the total time of the athletes
	public static class TimeComparator implements Comparator {
		//	compares final time of two athletes
		@Override
		public int compare(Object o1, Object o2) {
			Athlete a1=(Athlete) o1;//cast of firs object to Athlete
			Athlete a2=(Athlete) o2;//cast of second object to Athlete
			return a1.getFinalTime().compareTo(a2.getFinalTime());
		}
	}
}