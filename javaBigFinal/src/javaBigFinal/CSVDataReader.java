package javaBigFinal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class CSVDataReader extends DataReader {
	private String csvFilePath;
	private List<Person> persons;
	
	public CSVDataReader(String csvFilePath) {
		this.csvFilePath = csvFilePath;
	}

	public List<Person> getPersons() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
			String line;
			List<String> splittedSearchCriteria = Arrays.asList(searchCriteria.split(","));
			while ((line = br.readLine()) != null) {
			    Person currentPerson = parse(line);
			    Skill currentPersonSkill = parseOnlySkill(line);
			    if (searchType.equals(SearchType.Optional)) {
			    	for (String criteria : splittedSearchCriteria) {
			    		if (currentPerson.getSkillList().contains(criteria)) {
							persons.add(currentPerson);
			    		}
					}
				}
			    
			    else {
			    	for (String criteria : splittedSearchCriteria) {
			    		if (currentPerson.getSkillList().contains(criteria)) {
			    			for (Person person : persons) {
			    				if (person.equals(currentPerson)) {
			    					person.addSkill(currentPersonSkill);
			    					}	
			    				}
								persons.add(currentPerson);
			    			}
			    	}
			    	for (Person person : persons) {
			    		if (!person.getSkillList().equals(splittedSearchCriteria)) {
							persons.remove(person);
						}
			    	}
			    }
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return persons;
	}

	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	public void setSearchType(SearchType searchType) {
		this.searchType = searchType;
	}
	
	public Person parse(String lineFromCSV) {
		String[] splittedCSVLine = lineFromCSV.split(",");
		Skill personSkill = new Skill(splittedCSVLine[2],splittedCSVLine[3]); 
		Person newPerson = new Person(splittedCSVLine[0],splittedCSVLine[1],personSkill);
		return newPerson;
	}
	
	public Skill parseOnlySkill(String lineFromCSV) {
		String[] splittedCSVLine = lineFromCSV.split(",");
		Skill personSkill = new Skill(splittedCSVLine[2],splittedCSVLine[3]);
		return personSkill;
	}
	
}
