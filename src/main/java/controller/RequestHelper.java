package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import controller.command.AddEmployeeCommand;
import controller.command.AddUserCommand;
import controller.command.AdminCommand;
import controller.command.ChangeEmployeeCommand;
import controller.command.ChangeUserCommand;
import controller.command.Command;
import controller.command.LoginCommand;
import controller.command.NoCommand;
import controller.command.SaveEmployeeCommand;
import controller.command.SaveUserCommand;
import controller.command.UserChangePetitionCommand;
import controller.command.UserChangeSemselfCommand;
import controller.command.UserFormCommand;
import controller.command.UserStartPageCommand;

public class RequestHelper {
	static Logger logger = Logger.getLogger(RequestHelper.class);
	private static RequestHelper instance = null;
	HashMap<String, Command> commands = new HashMap<String, Command>();

	private RequestHelper() {
		// ���������� ������� ���������
		commands.put("login", new LoginCommand());
		commands.put("userForm", new UserFormCommand());
		commands.put("userStartPage", new UserStartPageCommand());
		commands.put("adminForm", new AdminCommand());
		commands.put("change_admin_user", new ChangeUserCommand());
		commands.put("change_admin_employee", new ChangeEmployeeCommand());
		commands.put("admin_add_user", new AddUserCommand());
		commands.put("admin_save_user", new SaveUserCommand());
		commands.put("admin_add_employee", new AddEmployeeCommand());	
		commands.put("admin_save_employee", new SaveEmployeeCommand());
		commands.put("user_change_semself", new UserChangeSemselfCommand());
		commands.put("user_change_petition", new UserChangePetitionCommand());
		
	}

	public Command getCommand(HttpServletRequest request) {
		// ���������� ������� �� �������
		String action = request.getParameter("command");
		
		// ��������� �������, ���������������� �������
		Command command = commands.get(action);
		logger.info("command = " + action);
		if (command == null) {
			// ���� ������� �� ���������� � ������� �������
			command = new NoCommand();
			logger.info("return new NoCommand");
		}
		return command;
	}

	// �������� ������������� ������� �� ������� Singleton
	public static RequestHelper getInstance() {
		if (instance == null) {
			instance = new RequestHelper();
			logger.info("create new RequestHelper");
		}
		logger.info("return RequestHelper");
		return instance;
	}
}
