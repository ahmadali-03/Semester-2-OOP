import java.util.Scanner;

public class InputDemo{
	
	public static void main(String args[]){

		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);

		System.out.println("This is an input demo code.");

		// Integer values
		byte b = 1;
		short s = 321;
		int i = 1000;
		long l = 10002000000l;

		// Decimal values
		float f = 10.0f;
		double d = 20000000000.0;

		// Character values
		char c = 'A';
		String word, sent;

		// Boolean Values
		Boolean bool = true; 

		// Taking input
		System.out.print("Enter byte value: ");
		b = input.nextByte();

		System.out.print("Enter int value: ");
		i = input.nextInt();

		System.out.print("Enter double value: ");
		d = input.nextDouble();

		System.out.print("Enter boolean value: ");
		bool = input.nextBoolean();

		// Taking char input
		System.out.printf("Enter char: ");
		c = input.next().charAt(0);

		// Taking string input
		System.out.printf("Enter string: ");
		word = input.next();

		System.out.printf("Enter string: ");
		sent = input2.nextLine();

		// Output
		System.out.printf("\nValue of byte: %04d\n", b);
		System.out.printf("Value of int: %04d \n", i);
		System.out.printf("Value of short: %d \n", s);
		System.out.printf("Value of long: %d \n", l);
		System.out.printf("Value of float: \t %,.1f \n", f);
		System.out.printf("Value of double: \t %,.1f \n", d);
		System.out.printf("Value of char: %c \n", c);
		System.out.printf("Value of boolean: %b \n", bool);
		System.out.printf("Value of string: %30s \n", "This is a string");
		System.out.printf("Value of string you entered: %s", word);
		System.out.printf("Value of string you entered (sentence): %s \n", sent);
		System.out.printf("Value of char you entered: %c", c);		
	}
}
