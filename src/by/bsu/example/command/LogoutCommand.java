package by.bsu.example.command;

import javax.servlet.http.HttpServletRequest;

import by.bsu.example.resource.ConfigurationManager;



public class LogoutCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.index");
		//уничтоженин сессии
		request.getSession().invalidate();
		return page;
	}

}
