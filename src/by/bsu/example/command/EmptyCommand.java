package by.bsu.example.command;

import javax.servlet.http.HttpServletRequest;

import by.bsu.example.resource.ConfigurationManager;



public class EmptyCommand implements ActionCommand{

	@Override
	public String execute(HttpServletRequest request) {
		/*� ������ ������ ��� ������� ��������� � �����������
		 * ������������� �� �������� ����� ������*/
		String page = ConfigurationManager.getProperty("path.page.login");
		return page;
	}
	
}
