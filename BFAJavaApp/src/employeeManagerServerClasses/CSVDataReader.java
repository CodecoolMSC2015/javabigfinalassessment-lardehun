package employeeManagerServerClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CSVDataReader extends DataReader{
	String csvFilePath;
	List<Person> persons;
	
	public CSVDataReader(String csvFilePath) {
		this.csvFilePath = csvFilePath;
	}

	@Override
	public Set<Person> getPersons(String searchCriteria, SearchType searchType) {
		Set<Person> personSet = new HashSet<>();
		//Get scanner instance
        Scanner scanner = null;
		try {
			scanner = new Scanner(new File(csvFilePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
         
        //Set the delimiter used in file
        scanner.useDelimiter("/n");
         
        //Get all tokens and store them in some data structure
        while (scanner.hasNext()) 
        {
            String[] current = scanner.next().split(",");
            //if its find a matching skill its add it to the set
            if (searchType == SearchType.Optional) {
				if (current[2] == searchCriteria) {
					Person currentPerson = new Person(current[0],current[1]);
					Skill currentSkill = new Skill(current[2],current[3],Double.parseDouble(current[4]));
				
					currentPerson.addSkill(currentSkill);
					personSet.add(currentPerson);
				}
			}
        }
         
        //Do not forget to close the scanner  
        scanner.close();
		return personSet;
	}
}
