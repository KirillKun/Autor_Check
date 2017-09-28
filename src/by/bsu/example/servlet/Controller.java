package by.bsu.example.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsu.example.command.ActionCommand;
import by.bsu.example.command.factory.ActionFactory;
import by.bsu.example.resource.ConfigurationManager;
import by.bsu.example.resource.MessageManager;

@WebServlet("/controller")

public class Controller extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String page =null;
		//����������� �������, ��������� �� JSP
		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);
		/*����� �������������� ������ execute() � �������� ����������
		 * ������-����������� ���������� �������
		 */
		page = command.execute(request);
		//����� ���������� �������� ������
		//page=null;//��������������������
		if(page!=null){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
			//����� �������� ������ �� ������
			dispatcher.forward(request, response);
			
		}else {
			//��������� �������� � ���������� �� ������
			page = ConfigurationManager.getProperty("path.page.index");
			request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
			response.sendRedirect(request.getContextPath()+page);
		}
	}
}
