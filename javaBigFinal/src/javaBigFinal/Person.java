package javaBigFinal;

import java.util.List;

public class Person {
	private String name;
	private String email;
	private List<Skill> skillList;
	
	public Person(String name,String email,Skill skill) {
		this.name = name;
		this.email = email;
		addSkill(skill);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<Skill> skillList) {
		this.skillList = skillList;
	}
	
	public void addSkill(Skill skill) {
		skillList.add(skill);
	}
	
	@Override
	public boolean equals(Object obj) {
		Person person = (Person) obj;
		return getEmail() == person.getEmail();
	}
	
	@Override
	public int hashCode() {
		return -1;
	}
}
