package javaBigFinal;

import java.util.List;

public abstract class DataReader {
	protected String searchCriteria;
	protected SearchType searchType;
	
	public abstract List<Person> getPersons();
	
	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}
	
	public void setSearchType(SearchType searchType) {
		this.searchType = searchType;
	}
}
