package schoolObjects;

public class Student extends Person{

	private String rollNo;

	public Student(String name, int age, String rollNo){
		super(name, age);
		setRollNo(rollNo);
	}

	public void setRollNo(String rollNo){
		this.rollNo = rollNo;
	}

	public String getRollNo(){
		return this.rollNo;
	}

	@Override
	public boolean equals(Object obj){
		Student student = (Student)obj;
		return this.rollNo.equals(student.rollNo);
	}

	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("Name: " + getName() + "\nAge:" + getAge() + "\nRoll No.: " + this.rollNo + "\n");

		return str.toString();
	}
}