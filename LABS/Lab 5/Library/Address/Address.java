package Library.Address;

public class Address{

	private String street;
	private String city;

	public Address(String street, String city){
		setStreet(street);
		setCity(city);
	}

	// Copy Constructor
	public Address(Address other){
		this.street = other.street;
		this.city = other.city;
	}

	public void showAddress(){
		System.out.printf("Address: %s, %s", this.city, this.street);
	}

	@Override
	public boolean equals(Object obj){
		Address address = (Address)obj;

		if ( address.street.equals(this.street) && address.city.equals(this.city) ){
			return true;
		}
		else{
			return false;
		}
	}

	public String getStreet(){
		return this.street;
	}

	public String getCity(){
		return this.city;
	}

	public void setStreet(String street){
		this.street = street;
	}

	public void setCity(String city){
		this.city = city;
	}

}
