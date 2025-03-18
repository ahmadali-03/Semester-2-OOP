package University.Department;
import University.Employee.*;
import University.Lab.*;

public class Department{

	 Employee hod;
	 String name;
	 String labIncharge;
	 Lab labs[];

	public Department(String name, Employee hod, String labIncharge, Lab labs[]){
		this.name = name;
		this.hod = hod;
		this.labIncharge = labIncharge;
		this.labs = labs;
	}

}
