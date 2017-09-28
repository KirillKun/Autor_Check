package by.bsu.example.logic;

public class LoginLogic {
	private final static String ADMIN_LOGIN = "admin";
	private final static String ADMIN_PASS = "qwe";

	public static boolean checkLogin(String enterLogin, String enterPass) {
	return ADMIN_LOGIN.equals(enterLogin) && ADMIN_PASS.equals(enterPass);
	}
}
