package temaWeek12Enum.Main;

import java.util.Date;

public class Person {

	private String name;
	private Date birthDate;
	private String gender;
	
	public Person(String name,Date birthDate,String gender){
		this.name=name;
		this.birthDate=birthDate;
		this.gender=gender;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public enum Gender{
		FEMALE,MALE;
		
		public static Gender getGender(String input){
			if(input.equals("0")||input.equalsIgnoreCase("male")){
				return MALE;
			}
			else if(input.equals("1")||input.equalsIgnoreCase("female")){
				return FEMALE;
			}
			else throw new IllegalArgumentException("Enter a valid gender");
		}
	}
}
