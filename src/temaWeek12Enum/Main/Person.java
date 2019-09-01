package temaWeek12Enum.Main;

public class Person {
	
	private final String name;
	private final String birthDate;
	private String gender;
	
	public Person(String name, String birthDate, String gender) {
		this.name = name;
		this.birthDate = birthDate;
		//calling getGender from enum Gender class for further use of enum const.
		this.gender = Gender.getGender(gender);
	}
//	enum class for gender
	public enum Gender {
		FEMALE, MALE;
		
		public static String getGender(String input) {
			if (input.equals("0") || input.equals("male")) {
				return MALE.toString();
			} else if (input.equals("1") || input.equals("female")) {
				return FEMALE.toString();
			} else throw new IllegalArgumentException("Enter a valid gender");
		}
		
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public String getGender() {
		return gender;
	}
	
//	method to extract the month and day from the birthDate
	public String getDayAndMonthOfBirth(){
		int index=birthDate.indexOf("-");
		return birthDate.substring(index+1);
	}
	
//	method to extract the year of birth
	public String getYearOfBirth(String birthDate) {
		return birthDate.substring(0, 4);
	}
	
//	method to extract firstName from name
	public String getFirstName(String name) {
		int index = getName().lastIndexOf(" ");
		return getName().substring(0, index);
	}
	
	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", birthDate='" + birthDate + '\'' +
				", gender='" + gender.toLowerCase() + '\'' +
				'}' + "\n";
	}
}
