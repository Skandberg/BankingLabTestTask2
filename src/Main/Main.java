package Main;

import java.util.LinkedList;
import java.util.Scanner;



import Person.Person;
import Reader.DocumentReader;
import Validator.DataValidator; 



public class Main {
	public static void main(String[] args) {
		DocumentReader reader = new DocumentReader();
		System.out.println("Type path to file: ");
		Scanner console = new Scanner(System.in);
		String path = console.nextLine();
		console.close();
		LinkedList<String> records = new LinkedList<>(reader.ReadLines(path));
		LinkedList<Person> persons = new LinkedList<Person>();
		for (int i=0;i<records.size();i++) {
			String[] parts = reader.splitRecord(records.get(i));
			Person person = new Person(parts[0],
					parts[1],
					parts[2]);
			persons.add(person);
			
		}
			
		for (int i=0;i<persons.size();i++) {
			
			
					
			DataValidator validator = new DataValidator();
			
			if (validator.validateFieldsAmount(records.get(i))) {
				validator.validateID(persons.get(i).getID());
				validator.validateFullName(persons.get(i).getFullName());
				validator.validateRiskFactor(persons.get(i).getRiskFactor());
				
				for (int j=i+1;j<persons.size();j++) {
					if (!validator.validateUniqueness(persons.get(i), persons.get(j))) {
						break;
					}
					
					
					
				}
			}
			
			
			

			
			
			
			System.out.println("-------------");	
			System.out.println(persons.get(i).getID() + " " + persons.get(i).getFullName()+ " "+persons.get(i).getRiskFactor());
			if (validator.getDeclineReason()!="") {
				System.out.println("DECLINED: " + validator.getDeclineReason());
			}else {
				System.out.println("ACCEPTED");
			}
		}
	}
}
