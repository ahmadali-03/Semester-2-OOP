public class Student{

	// Decelaring private variables
	private String name;
	private String regNo;
	private double gpa;
	private String address;
	private String phoneNumber;	

	// Generating reg number
	private static int stdNum = 1;
	
	// Constructor
	public Student(String name, double gpa, String address, String number){
		this.name = name;
		this.gpa = gpa;
		this.address = address;
		this.phoneNumber = number;
		regNo = String.format("FA24-BCS-%03d", stdNum++);
	}

	// Function to display student information
	public void display(){

		System.out.println("\nName: "+ name);
		System.out.println("Reg No.: "+ regNo);
		System.out.println("GPA: "+ gpa);
		System.out.println("Address: "+ address);
		System.out.println("Number: "+ phoneNumber);
		System.out.println("----------------------------------------------");
	}

	public void setName(String number){
		this.name = name;
	}

	public void setGpa(double gpa){
		this.gpa = gpa;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public void setPhoneNum(String number){
		this.phoneNumber = number;
	}

}