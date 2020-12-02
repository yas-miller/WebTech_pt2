package controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import controller.ConfigurationManager;
import controller.MessageManager;

public class UserStartPageCommand implements Command {
static Logger logger = Logger.getLogger(AdminCommand.class);
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		
		try {

			page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.USER_FORM_PATH);
			logger.info("page: " + page);
		} catch(Exception ex) {
			request.setAttribute("errorMessage", MessageManager.getInstance().getProperty(MessageManager.SERVLET_EXCEPTION_ERROR_MESSAGE));
			logger.error(MessageManager.getInstance().getProperty(MessageManager.SERVLET_EXCEPTION_ERROR_MESSAGE));
			page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE_PATH);
		}
		return page;
	}
}
