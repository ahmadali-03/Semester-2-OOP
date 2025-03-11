package Library.Date;

public class Date{

	private int day;
	private int month;
	private int year;

	Date(int day, int month, int year){
		setDate(day);
		setMonth(month);
		setYear(year);
	}

	Date(Date other){
		this.day = other.day;
		this.month = other.month;
		this.year = other.year;
	}

	public void showDate(){
		System.out.printf("Date: %d/%d/%d \n", this.day, this.month, this.year);
	}

	@Override
	public boolean equals(Object obj){
		Date date = (Date)obj;

		return (day == date.day && month == date.month && year == date.year);
	}

	// Setters
	public void setDate(int day){
		this.day = day;
	}

	public void setMonth(int month){
		this.month = month;
	}

	public void setYear(int year){
		this.year = year;
	}

	// Getters
	public int getDay(){
		return this.day;
	}

	public int getMonth(){
		return this.month;
	}

	public int getYear(){
		return this.year;
	}

}
