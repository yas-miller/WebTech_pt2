package controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import controller.ConfigurationManager;
import controller.MessageManager;
import controller.ParseUserPetitionPage;
import model.entities.Petition;
import model.Dispatcher;

public class UserFormCommand implements Command {
	private static final String PARAM_NAME_WORKING = "working";
	private static final String PARAM_NAME_SCALE = "scale";
	private static final String PARAM_NAME_MONTH = "month";
	private static final String PARAM_NAME_DAY = "day";
	private static final String PARAM_NAME_HOUR = "hour";
	private static final String PARAM_NAME_MINUTE = "minute";
	
	static Logger logger = Logger.getLogger(UserFormCommand.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		// ���������� �� ������� ������ � ������
		String working = request.getParameter(PARAM_NAME_WORKING);
		logger.debug("working: " + working);
		String scale = request.getParameter(PARAM_NAME_SCALE);
		logger.debug("scale: " + scale);
		String month = request.getParameter(PARAM_NAME_MONTH);
		logger.debug("month: " + month);
		String day = request.getParameter(PARAM_NAME_DAY);
		logger.debug("day: " + day);
		String hour = request.getParameter(PARAM_NAME_HOUR);
		logger.debug("hour: " + hour);
		String minute = request.getParameter(PARAM_NAME_MINUTE);
		logger.debug("minute" + minute);
		
		HttpSession session = request.getSession();
		logger.debug("idUser, without casting: " + session.getAttribute("userId"));
		int idUser = (int) session.getAttribute("userId");
		logger.debug("idUser: " + idUser);
		try {
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");

				Petition petition = new Petition();
				petition.setExpressService(ParseUserPetitionPage.parseWorking(working));
				petition.setScaleWork(ParseUserPetitionPage.parseScaleWork(scale));
				petition.setTime(ParseUserPetitionPage.parseTime(month, day, hour, minute));
				petition.setIdTenant(idUser);
				logger.info("Create petition.");
				
				Dispatcher dispatcher = Dispatcher.getInstanse();
				dispatcher.addPetition(petition);
				logger.info("Sent petition to dispatcher.");

			page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.USER_FORM_PATH);	
		} catch(Exception ex) {
			request.setAttribute("errorMessage", MessageManager.getInstance().getProperty(MessageManager.LOGIN_ERROR_MESSAGE));
			page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE_PATH);
			logger.error(MessageManager.getInstance().getProperty(MessageManager.LOGIN_ERROR_MESSAGE));
		}
		return page;
	}

}
