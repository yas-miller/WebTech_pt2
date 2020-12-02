package controller.command;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entities.Employee;
import model.entities.UtilityWorker;

import org.apache.log4j.Logger;

import controller.ConfigurationManager;
import controller.MessageManager;
import dao.jdbc.JDBCDaoFactory;

public class ChangeEmployeeCommand implements Command {

	static Logger logger = Logger.getLogger(ChangeEmployeeCommand.class);
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		try {
				JDBCDaoFactory factory = new JDBCDaoFactory();

				Employee employee = new Employee();
				
				Enumeration<String> enumer = request.getParameterNames();
				while(enumer.hasMoreElements()){
					logger.info(enumer.nextElement());
				}
				
				int id = Integer.parseInt(request.getParameter("id"));
				employee.setId(id);
				logger.info("id employee: " + id);
				
				String name = request.getParameter("name");
				employee.setName(name);
				logger.info("name employee: " + name);
				
				logger.info((request.getParameter("UtilityWorker")).toString());
				UtilityWorker utilityWorker = UtilityWorker.valueOf(request.getParameter("UtilityWorker"));
				logger.info("UtilityWorker employee: " + utilityWorker);
				employee.setUtilityWorker(utilityWorker);
		
				logger.info("uddate employee: " + employee);
				factory.createEmployeeDao().update(employee);

				page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADMIN_PAGE_PATH);
		} catch(Exception ex) {
			request.setAttribute("errorMessage", MessageManager.getInstance().getProperty(MessageManager.LOGIN_ERROR_MESSAGE));
			logger.error(MessageManager.getInstance().getProperty(MessageManager.LOGIN_ERROR_MESSAGE));
			page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADMIN_PAGE_PATH);
		}
		return page;
	}
}
