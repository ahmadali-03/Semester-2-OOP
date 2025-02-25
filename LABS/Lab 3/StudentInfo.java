import java.util.Scanner;

public class StudentInfo{

	public static void main(String args[])
	{
		// Creating input objects
		Scanner input1 = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		
		String username;
		String password;

		// Taking user input
		System.out.print("Enter username: ");
		username = input1.next();
		System.out.print("Enter password: ");
		password = input2.next();

		// Checking user entered credentials
		if (UserInfo.checkUsername(username) == 1 && UserInfo.checkPassword(password) == 1)
		{
			System.out.println("Logged In :)");
			// Creating objects
			Student s1, s2, s3, s4;
			s1 = new Student("Ahmad Ali", 3.93, "Allama Iqbal Twon, Lahore", "+92 323 5592221");
			s2 = new Student("Ahmad Ansar", 3.98, "Gulberg, Lahore", "+92 323 0012227");
			s3 = new Student("M. Bin Mohsin", 3.93, "Bahria Town, Lahore", "+92 310 4582391");
			s4 = new Student("M. Ahmad Akhtar", 3.98, "Thokar Niaz Baig, Lahore", "+92 323 9912583");
			
			// Calling function in Student class
			s1.display();
			s2.display();
			s3.display();
			s4.display();
		}
		else
		{
			System.out.println("Incorrect credentials!!");
		}
	}

}	
