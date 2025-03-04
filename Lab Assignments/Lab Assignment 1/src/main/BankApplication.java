package main;
import banking.BankingSystem;
import java.io.Console;

public class BankApplication{

	public static void main (String args[]){

		Console console = System.console();

		String accountNumber;

		System.out.println("Enter account number: ");
		accountNumber = console.readLine("Enter account number: ");

		System.out.println("Enter password: ");
		char [] pin = console.readPassword("Enter password: ");

		//Convert char to str
		String code = new String(pass);

		if (BankingSystem.LoginProcessor.authenticate(accountNumber , code) {
			System.out.println("Access Granted!");
       	 	} 
		else {
           		 System.out.println("Invalid credentials!");
        	}
	}

}
