package by.bsu.example.command.factory;

import javax.servlet.http.HttpServletRequest;

import by.bsu.example.command.ActionCommand;
import by.bsu.example.command.EmptyCommand;
import by.bsu.example.command.client.CommandEnum;
import by.bsu.example.resource.MessageManager;

public class ActionFactory {

	public ActionCommand defineCommand(HttpServletRequest request) {
		ActionCommand current = new EmptyCommand();
		// ���������� ����� ������� �� �������
		String action = request.getParameter("command");
		if (action == null || action.isEmpty()) {
			return current;
		}
		// ��������� �������, ���������������� �������
		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();

		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
		}
		return current;
	}

}
