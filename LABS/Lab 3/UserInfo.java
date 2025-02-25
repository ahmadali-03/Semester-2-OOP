public class UserInfo{
	
	private static String username = "ahmad@gmail.com";
	private static String password = "13579";

	public static int checkUsername(String user){
		if (user.equals(username))
			return 1;
		else
			return 0;
	}

	public static int checkPassword(String pass){
		if (pass.equals(password))
			return 1;
		else
			return 0;
	}
}