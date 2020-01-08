package temaWeek11InputOutput.main;

public class Athlete {
	private final String athlNo;
	private final String athlName;
	private final String countryCode;
	private final String skiTimeResult;
	private final String firstShootingRange;
	private final String secondShootingRange;
	private final String thirdShootingRange;
	private final String finalTime;
	private final int penalty;


//	constructor of athlete
	
	public Athlete(String athlNumber, String athlName, String countryCode, String skiTimeResult,
				   String firstShootingRange, String secondShootingRange, String thirdShootingRange) {
		this.athlNo = athlNumber;
		this.athlName = athlName;
		this.countryCode = countryCode;
		this.skiTimeResult = skiTimeResult;
		this.firstShootingRange = firstShootingRange;
		this.secondShootingRange = secondShootingRange;
		this.thirdShootingRange = thirdShootingRange;
		this.penalty=(calculatePenalty(firstShootingRange)+calculatePenalty(secondShootingRange)+calculatePenalty(thirdShootingRange));
		this.finalTime=calculateFinalTime(skiTimeResult,penalty);
	}
	
	@Override
	public String toString() {
		return "Athlete{" +
				"athlNumber='" + athlNo + '\'' +
				", athlName='" + athlName + '\'' +
				", countryCode='" + countryCode + '\'' +
				", time='" + skiTimeResult + '\'' +
				", firstShootingRange='" + firstShootingRange + '\'' +
				", secondShootingRange='" + secondShootingRange + '\'' +
				", thirdShootingRange='" + thirdShootingRange + '\'' +"\n"+
				", finalTime= "+finalTime+'\''+
				'}';
	}
	//	penalty calculation based on missed shootings "o"
	public int calculatePenalty(String penalty){
		int sum=0;
		for(int i=0;i<penalty.length();i++){
			char c=penalty.charAt(i);
			if(c=='o'){
				sum=sum+10;
			}
		}
		return sum;
	}
	//	method for calculating the final time based on ski time results and missed shots
	public String calculateFinalTime(String skiTimeResult,int penalty ){
		String minutes=getSkiTimeResult().substring(0,2);
		String seconds=getSkiTimeResult().substring(3);
		int timeInSeconds=Integer.parseInt(minutes)*60+Integer.parseInt(seconds);
		int finalTime=timeInSeconds+penalty;
		String finalTimeToString = String.format("%02d:%02d", finalTime/60, finalTime%60);
		return finalTimeToString;
	}
	
	
	
	public String getAthlName() {
		return athlName;
	}
	
	public String getSkiTimeResult() {
		return skiTimeResult;
	}
	
	
	public String getFinalTime() {
		return finalTime;
	}
	
	public int getPenalty() {
		return penalty;
	}
}
