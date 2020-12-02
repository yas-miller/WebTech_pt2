package controller.command;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entities.ExpressService;
import model.entities.Petition;
import model.entities.ScaleWork;

import org.apache.log4j.Logger;

import controller.ConfigurationManager;
import controller.MessageManager;
import dao.jdbc.JDBCDaoFactory;

public class UserChangePetitionCommand implements Command {

	static Logger logger = Logger.getLogger(UserChangePetitionCommand.class);
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		try {
				JDBCDaoFactory factory = new JDBCDaoFactory();

				Petition petition = new Petition();
				
				int id = Integer.parseInt(request.getParameter("id"));
				petition.setId(id);
				logger.info("id petition: " + id);
				
				ExpressService expressService = ExpressService.valueOf(request.getParameter("ExpressService"));
				logger.info("ExpressService petition: " + expressService);
				petition.setExpressService(expressService);
				
				ScaleWork scaleWork = ScaleWork.valueOf(request.getParameter("ScaleWork"));
				logger.info("ScaleWork petition: " + scaleWork);
				petition.setScaleWork(scaleWork);

				int month = Integer.parseInt(request.getParameter("month"));
				logger.info("month petition: " + month);
				
				int day = Integer.parseInt(request.getParameter("day"));
				logger.info("day petition: " + day);
				
				int hour = Integer.parseInt(request.getParameter("hour"));
				logger.info("hour petition: " + hour);
				
				int minutes = Integer.parseInt(request.getParameter("minutes"));
				logger.info("minutes petition: " + minutes);

				GregorianCalendar calendar = new GregorianCalendar();
				calendar.set(2015, month, day, hour, minutes);	
				petition.setTime(calendar.getTimeInMillis());
				
				int idUser =  Integer.parseInt(request.getParameter("idUser"));
				petition.setIdTenant(idUser);
				logger.info("idUser: " + idUser);
				
				logger.info("uddate petition: " + petition);
				factory.createPetitionDao().update(petition);

				page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.USER_FORM_PATH);
		} catch(Exception ex) {
			request.setAttribute("errorMessage", MessageManager.getInstance().getProperty(MessageManager.LOGIN_ERROR_MESSAGE));
			logger.error(MessageManager.getInstance().getProperty(MessageManager.LOGIN_ERROR_MESSAGE));
			page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADMIN_PAGE_PATH);
		}
		return page;
	}
}
