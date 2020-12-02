package taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import dao.jdbc.JDBCDaoFactory;

public class AdminDeletePetition extends TagSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(AdminDeletePetition.class);     
	
    @Override
    public int doStartTag() throws JspException {
    	
        int id = Integer.parseInt(pageContext.getRequest().getParameter("id"));
        JspWriter out = pageContext.getOut();
        
        try {
			out.print("Petition with id:" + id + " has been removed.");
			new JDBCDaoFactory().createPetitionDao().delete(id);
			new JDBCDaoFactory().createWorkDao().delete(id);
			new JDBCDaoFactory().createBrigadeDao().delete(id);
			out.print("<hr />");
			out.print("<INPUT type=\"submit\" value=\"Go to head admin page.\">");
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

        return SKIP_BODY;
    }
}