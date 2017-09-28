package by.bsu.example.command.client;

import by.bsu.example.command.ActionCommand;
import by.bsu.example.command.LoginCommand;
import by.bsu.example.command.LogoutCommand;

public enum CommandEnum {
	
	LOGIN {
		{
	
		this.command = new LoginCommand();
	    }
},
LOGOUT {
	{
		this.command = new LogoutCommand();
	}
};
	ActionCommand command;
	public ActionCommand getCurrentCommand(){
		return command;
	}
	}