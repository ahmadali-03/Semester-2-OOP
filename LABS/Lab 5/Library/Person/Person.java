package Library.Person;

import Library.Address.*;

public class Person{

	private String name;
	private String role;
	private Address address;

	Person(String name, String role, Address address){
		setName(name);
		setRole(role);
		this.address = address;
	}

	Person(Person other){
		this.name = other.name;
		this.role = other.role;
		this.address.Address(other.address);
	}

	public void showPersonDetails(){
		System.out.printf("%s", this.name);
		this.address.showAddress();
	}

	@Override
	public boolean equals(){

	}

	// Setters
	public void setName(String name){
		this.name = name;
	}

	public void setRole(String role){
		this.role = role;
	}

	// Getters
	public String getName(){
		return this.name;
	}

	public String getRole(){
		return this.role;
	}



}
