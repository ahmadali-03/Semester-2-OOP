package banking;
import util.PinValidator;

public class BankingSystem{

	static final String storedAccountNumber = "000111";
	static final String storedPin = "0000";

	PinValidator obj1 = new PinValidator();
	PinValidator.Rules validate = obj1.new Rules();

	public static class LoginProcessor{

		public static boolean authenticate(String accountNumber, String pin){

			if (storedAccountNumber.equals(accountNumber) && validate.isValid(pin)){

			}
			else{
				return false;
			}	
		}
	}
}
