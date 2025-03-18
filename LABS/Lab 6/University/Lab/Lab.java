package University.Lab;

import University.Employee.*;
import University.SystemUnit.*;

public class Lab{

	String name;
	Employee labStaff;
	SystemUnit systemUnits[];
	boolean hasMultimedia;

	public Lab(String name, Employee labStaff, SystemUnit systemUnits[], boolean hasMultimedia){
		setName(name);
		setLabStaff(labStaff);
		
	}
	
	public void setName(String name){
		this.name = name;
	}

	public void setLabStaff(Employee labStaff){
		this.labStaff = labStaff;
	}

	public void setSystemUnit(SystemUnit systemUnits[]){
		this.systemUnits = systemUnits;
	}

	public void setHasMultimedia(boolean hasMultimedia){
		this.hasMultimedia = hasMultimedia;
	}

	public String getName(){
		return this.name;
	}

	public Employee getLabStaff(){
		return this.labStaff;
	}

	public SystemUnit[] getSystemUnit(){
		return this.systemUnits;
	}

	public boolean getHasMultimedia(){
		return this.hasMultimedia;
	}

	public String toString(){

		StringBuilder str = new StringBuilder();
		str.append(name);
		str.append(labStaff);
		for(int i = 0; i < 2; i++)
		{
			str.append(systemUnits[i]);
		}

		return str.toString();
	}


}
