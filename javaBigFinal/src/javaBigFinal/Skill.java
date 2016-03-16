package javaBigFinal;

public class Skill {
	private String name;
	private String discription;
	private double rate;
	
	public Skill(String name, String discription) {
		super();
		this.name = name;
		this.discription = discription;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
}
