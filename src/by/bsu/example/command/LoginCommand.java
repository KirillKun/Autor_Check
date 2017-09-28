package by.bsu.example.command;

import javax.servlet.http.HttpServletRequest;

import by.bsu.example.logic.LoginLogic;
import by.bsu.example.resource.ConfigurationManager;
import by.bsu.example.resource.MessageManager;


public class LoginCommand implements ActionCommand{
	private static final String PARAM_NAME_LOGIN="Login";
	private static final String PARAM_NAME_PASSWORD="password";
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		//извлечение из запроса логина и пароля
		String log = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		//проверка логина и пароля
		if(LoginLogic.checkLogin(log, pass)){
			request.setAttribute("user", log);
			//определение пути к main.jsp
			page = ConfigurationManager.getProperty("path.page.main");
		}else{
			request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
			page = ConfigurationManager.getProperty("path.page.login");
		}
		return page;
	}
	
}
