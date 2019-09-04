package temaWeek12Enum.twoThreadVersion.main;

import java.util.ArrayList;
import java.util.List;

public class AppPerson {
	
	private static final String location = "src\\temaWeek12Enum\\twoThreadVersion\\main\\utilities";
	private static final String extension = ".txt";
	private static List<Person> persons = new ArrayList<>();
	private static List<Person> female = new ArrayList<>();
	
	
	public static void main(String[] args) throws InterruptedException {
		long startTime=System.currentTimeMillis();
		
		RunnableClass myRunnable=new RunnableClass();
		Thread t1=new Thread(myRunnable);
		Thread t2=new Thread(myRunnable);
		Thread t3=new Thread(myRunnable);
		
		t1.start();
		t2.start();
		t3.start();

		Thread.sleep(3000);
//		find in how many milisec main thread runs
		long endTime = System.currentTimeMillis();
		long time=endTime-startTime;
		System.out.println("that took:" +  time);// 3001
		
	}
	
	
}