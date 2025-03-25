package schoolObjects;

public class School{

	String name;
	String address;
	Principal principal;
	ClassRoom classes[];
	Teacher teachers[];

	public School(String name, String address, Principal principal, int numberOfClasses, Teacher teachers[], Student students1[], Student students2[]){
		setName(name);
		setAddress(address);
		setPrincipal(principal);
		setTeachers(teachers);
		classes = new ClassRoom[numberOfClasses];
		classes[0] =  new ClassRoom("Grade 10", "G10", teachers[0], students1); // Students list is hardcoded
		classes[1] =  new ClassRoom("Grade 9", "G09", teachers[1], students2); // Students list is hardcoded
	}


	// Setters
	public void setName(String name){
		this.name = name;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public void setPrincipal(Principal principal){
		this.principal = principal;
	}

	public void setTeachers(Teacher teachers[]){
		this.teachers = teachers;
	}

	public void setClasses(ClassRoom classes[]){
		this.classes = classes;
	}

	// Getters
	public String getName(){
		return this.name;
	}

	public String getAddress(){
		return this.address;
	}

	public Principal getPrincipal(){
		return this.principal;
	}

	public Teacher[] getTeachers(){
		return this.teachers;
	}

	public ClassRoom[] getClasses(){
		return classes;
	}

	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("-------School details-------\nSchool Name: " + this.name + "\nAddress:" + this.address + "\n\n" + principal);
		str.append("\n-----Teachers details-----\n");
		str.append("Total teachers: " + teachers.length + "\n");

		for(int i = 0; i < teachers.length; i++){
			str.append("Teacher " + (i + 1) + "\n----------\n" + teachers[i] + "\n");
		}
		str.append("\n-----Classes details-----\nNumber of classes: " + classes.length + "\n");
		
		for(int i = 0; i < classes.length; i++){
			str.append("\n--Class " + (i + 1) + " details--\n" + classes[i]);
		}

		return str.toString();
	}

}