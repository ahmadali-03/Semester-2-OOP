package University.Employee;

public class Employee{
	private String name;
	private String designation;

	public Employee(String name, String designation){
		this.name = name;
		this.designation = designation;
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;		
	}

	public void setDesignation(String designation){
		this.designation = designation;
	}
	public String getDesignation(){
		return designation;		
	}

	public String toString(){
		return String.format("\nPerson Details:\nName: %s\nDesignation: %s\n", name, designation);
	}
}
