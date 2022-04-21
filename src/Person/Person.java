package Person;

public class Person {
	private String id;
	private String fullName;
	private String riskFactor;
	
	public String getID() {
		return id;
	}
	public String getFullName() {
		return fullName;
	}
	public String getRiskFactor() {
		return riskFactor;
	}
	public Person(String id, String fullName, String riskFactor) {
		this.id=id;
		this.fullName=fullName;
		this.riskFactor=riskFactor;
	}
	
}
