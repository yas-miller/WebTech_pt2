package controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entities.Employee;
import model.entities.UtilityWorker;

import org.apache.log4j.Logger;

import controller.ConfigurationManager;
import controller.MessageManager;
import dao.jdbc.JDBCDaoFactory;

public class SaveEmployeeCommand implements Command {

	static Logger logger = Logger.getLogger(SaveEmployeeCommand.class);
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		try {
				JDBCDaoFactory factory = new JDBCDaoFactory();

				Employee employee = new Employee();
				
				String name = request.getParameter("name");
				employee.setName(name);
				logger.info("name employee: " + name);
				
				UtilityWorker utilityWorker = UtilityWorker.valueOf((request.getParameter("UtilityWorker")).toString());
				logger.info("UtilityWorker employee: " + utilityWorker);
				employee.setUtilityWorker(utilityWorker);
		
				logger.info("uddate employee: " + employee);
				factory.createEmployeeDao().create(employee);

				page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADMIN_PAGE_PATH);
		} catch(Exception ex) {
			request.setAttribute("errorMessage", MessageManager.getInstance().getProperty(MessageManager.LOGIN_ERROR_MESSAGE));
			logger.error(MessageManager.getInstance().getProperty(MessageManager.LOGIN_ERROR_MESSAGE));
			page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADMIN_PAGE_PATH);
		}
		return page;
	}
}
