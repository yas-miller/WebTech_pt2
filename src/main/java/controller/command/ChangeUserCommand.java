package controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.entities.Tenant;
import controller.ConfigurationManager;
import controller.MessageManager;
import dao.jdbc.JDBCDaoFactory;

public class ChangeUserCommand implements Command {
	
	static Logger logger = Logger.getLogger(ChangeUserCommand.class);
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		try {
				JDBCDaoFactory factory = new JDBCDaoFactory();

				Tenant tenant = new Tenant();
				
				logger.info(request.getParameter("id"));
				int id = Integer.parseInt(request.getParameter("id"));
				tenant.setId(id);
				logger.info("id user: " + id);
				
				String name = request.getParameter("name");
				tenant.setName(name);
				logger.info("name user: " + name);
				
				String adress = request.getParameter("adress");
				tenant.setAddress(adress);
				logger.info("adress user: " + adress);
				
				String login = request.getParameter("login");
				tenant.setLogin(login);
				logger.info("login tenant" + login);
				
				String password = request.getParameter("password");
				tenant.setPassword(password);
				logger.info("password tenant" + password);
				
				logger.info("uddate user: " + tenant);
				factory.createTenantDao().update(tenant);

				page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADMIN_PAGE_PATH);
		} catch(Exception ex) {
			request.setAttribute("errorMessage", MessageManager.getInstance().getProperty(MessageManager.LOGIN_ERROR_MESSAGE));
			logger.error(MessageManager.getInstance().getProperty(MessageManager.LOGIN_ERROR_MESSAGE));
			page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADMIN_PAGE_PATH);
		}
		return page;
	}
}
