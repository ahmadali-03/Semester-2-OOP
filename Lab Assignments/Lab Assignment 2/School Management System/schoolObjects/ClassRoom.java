package schoolObjects;

public class ClassRoom{

	private String name;
	private String classCode;
	private Teacher teacher;
	private Student students[];

	public ClassRoom(String name, String classCode, Teacher teacher, Student students[]){
		setName(name);
		setClassCode(classCode);
		setTeacher(teacher);
		if (students.length <= 5){
			setStudents(students);
		}
		else{
			System.out.println("Class is full!! Can't add more students!!");
		}
	}

	// Setters
	public void setName(String name){
		this.name = name;
	}

	public void setClassCode(String classCode){
		this.classCode = classCode;
	}

	public void setTeacher(Teacher teacher){
		this.teacher = teacher;
	}

	public void setStudents(Student students[]){
		this.students = students;
	}

	// Getters
	public String getName(){
		return this.name;
	}

	public String getClassCode(){
		return this.classCode;
	}

	public Teacher getTeacher(){
		return this.teacher;
	}

	public Student[] getStudents(){
		return this.students;
	}

	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("Class name: " + this.name + "\nClass code:" + this.classCode + "\nClass teacher: " + this.teacher.getName() + "\n");
		str.append("Total students: " + students.length + "\n\n");

		for(int i = 0; i < students.length; i++){
			str.append("Student " + (i + 1) + "\n---------\n"+ students[i]);
		}

		return str.toString();
	}
	
}