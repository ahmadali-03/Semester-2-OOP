package schoolObjects;

public class Teacher extends Person{

	private String subjectTeaching;
	private String id;

	public Teacher(String name, int age, String id, String subjectTeaching){
		super(name, age);
		setSubjectTeaching(subjectTeaching);
		setId(id);
	}


	// Setters
	public void setSubjectTeaching(String subjectTeaching){
		this.subjectTeaching = subjectTeaching;
	}

	public void setId(String id){
		this.id = id;
	}

	// Getters
	public String getSubjectTeaching(){
		return this.subjectTeaching;
	}

	public String getId(){
		return this.id;
	}

	@Override
	public boolean equals(Object obj){
		Teacher teacher = (Teacher)obj;
		return this.id.equals(teacher.id);
	}

	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("Name: " + getName() + "\nAge:" + getAge() + "\nID: " + getId() + "\nSubject teaching: " + this.subjectTeaching);

		return str.toString();
	}
}