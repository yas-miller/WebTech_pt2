package taglib;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import model.entities.Work;

import org.apache.log4j.Logger;

import dao.jdbc.JDBCDaoFactory;

public class WorkTable extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(WorkTable.class);     
	
	    @SuppressWarnings("deprecation")
		@Override
	    public int doStartTag() throws JspException {
	        
			
	        try {
	            //Get the writer object for output.
	            JspWriter out = pageContext.getOut();

				JDBCDaoFactory factory = new JDBCDaoFactory();
		    	
				List<Work> works = factory.createWorkDao().findAll();

				logger.info("works:" + works);
				
	            out.println("<TABLE border=1>");
	            out.println("<TR valign=\"top\">");
	            out.println("<TD>Id</TD>");
	            out.println("<TD>Time</TD>");
	            out.println("<TD>Adress</TD>");
	            out.println("<TD>Id petiotin</TD>");
	            out.println("<TD>Id brigade</TD>");
	            out.println("</TR>");
	            
	            for(Work w: works){
	            	out.println("<TR>");
		            out.println("<TD>" + w.getId() + "</TD>");
		            
		            Date gc = new Date(w.getTime()); 
		            out.println("<TD>" + "month - " + gc.getMonth() + "; day - " + gc.getDay() + "; time - " + gc.getHours() + ":" + gc.getMinutes() + "</TD>");
		            out.println("<TD>" + w.getAddress() + "</TD>");
		            out.println("<TD>" + w.getIdPetition() + "</TD>");
		            out.println("<TD>" + w.getIdBrigade() + "</TD>");
		            
		            out.println("</TR>");
	            } 
	            out.println("</TABLE>");

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return SKIP_BODY;
	    }
}
