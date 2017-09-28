package by.bsu.example.command;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
	String execute (HttpServletRequest request);

}
