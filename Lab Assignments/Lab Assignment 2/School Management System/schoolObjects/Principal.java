package schoolObjects;

public class Principal extends Person{

	private int experience;

	public Principal(String name, int age, int experience){
		super(name, age);
		setExperience(experience);
	}

	public void setExperience(int experience){
		this.experience = experience;
	}

	public int getExperience(){
		return this.experience;
	}

	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("-----Principal's detail-----\nName: " + getName() + "\nAge:" + getAge() + "\nExperience: " + this.experience + "\n");

		return str.toString();
	}
}