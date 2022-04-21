package Validator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Person.Person;

public class DataValidator {
	private String declineReason="";
	public boolean validateFieldsAmount(String line) {
		if (line.split(",",-1).length-1>3) {
			declineReason += "Too many fields, record must have only 3 fields; ";
			return false;
		}
		return true;
	}
	public void validateID(String id) {
		if (id.isEmpty()){
			declineReason+="Missing ID; ";
		}
		else {
			try {
				Integer.parseInt(id);
			}catch(Exception e) {
				declineReason+= "Wrong ID format; ";
			}
			
		}
		
		
	}
	public void validateFullName (String fullName) {
		if (fullName.isEmpty()){
			declineReason+="Missing Full Name; ";
		}else {
			Pattern pattern = Pattern.compile("^[a-zA-ZÀ-ž_ ]*$");
			Matcher matcher = pattern.matcher(fullName);
			if (!matcher.find()) {
				declineReason+="Full Name may contain only letters and spaces; ";
			}
		}
		
	}
	public void validateRiskFactor (String riskFactor) {
		if (riskFactor.isEmpty()) {
			declineReason+="Missing Risk Factor; ";
		}else {
			Pattern pattern = Pattern.compile("^(\\d*\\.)?\\d+$");
			Matcher matcher = pattern.matcher(riskFactor);
			if (!matcher.find()) {
				declineReason+="Wrong Risk Factor format; ";
			}else {
				if(Double.parseDouble(riskFactor)<1 || Double.parseDouble(riskFactor)>2) {
					declineReason += "Risk Factor must be between 1 and 2.5 inclusive; ";
				}
			}
			/*try {
				double parsedRiskFactor =  Float.parseFloat(riskFactor);
				if (parsedRiskFactor<1 || parsedRiskFactor >2.5) {
					declineReason += "Risk Factor must be between 1 and 2.5 inclusive; ";
				}
			}catch (Exception e) {
				declineReason+= "Wrong Risk Factor format; ";
				return;
			}*/
			
		}
		
	}
	
	public boolean validateUniqueness(Person firstPerson, Person secondPerson) {
		if (firstPerson.getID().equals(secondPerson.getID()) || firstPerson.getFullName().equals(secondPerson.getFullName())) {
			declineReason+= "This person already exists; ";
			return false;
		}else {
			return true;
		}
	}
	public String getDeclineReason() {
		return declineReason;
	}
}
