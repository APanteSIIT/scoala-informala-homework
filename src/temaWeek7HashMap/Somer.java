package temaWeek7HashMap;

public class Somer extends Persoane {

	
	public Somer(String name,int age)
	{
		super(name,age);
		
	}
	@Override
	public String toString() {
		return "Somer{" +super.getName()+ ", "+super.getAge()+", "+
				"hobby=" + hobby +
				'}';
	}
}
