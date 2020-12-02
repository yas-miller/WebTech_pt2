package taglib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import model.entities.Petition;

import org.apache.log4j.Logger;

import dao.jdbc.JDBCDaoFactory;

public class UsersPetitionTable extends TagSupport {
	private int id;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(UsersPetitionTable.class);     

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

		@SuppressWarnings("deprecation")
		@Override
	    public int doStartTag() throws JspException {
	    	
	        try {
	            //Get the writer object for output.
	            JspWriter out = pageContext.getOut();
	            out.write(id);
				JDBCDaoFactory factory = new JDBCDaoFactory();
		    	
				List<Petition> petitions = factory.createPetitionDao().findAll();
				
				List<Petition> userPetition = new ArrayList<>();
				
				for(Petition p: petitions){
					if(1 == p.getIdTenant()){
						userPetition.add(p);
					}
				}
				logger.info("---------------------------------------------------------------------");
				logger.info("id: " + id);
				logger.info("petitions:" + userPetition);
				out.println("Statements: " + userPetition.size());
	            out.println("<TABLE border=1>");
	            out.println("<TR valign=\"top\">");
	            out.println("<TD>Id petition</TD>");
	            out.println("<TD>Express service </TD>");
	            out.println("<TD>Scale work</TD>");
	            out.println("<TD>Time</TD>");
	            out.println("<TD> </TD>");
	            out.println("<TD> </TD>");
	            out.println("</TR>");
	            
	            for(Petition p: userPetition){
	            	out.println("<TR>");
		            out.println("<TD>" + p.getId() + "</TD>");
		            out.println("<TD>" + p.getExpressService() + "</TD>");
		            out.println("<TD>" + p.getScaleWork() + "</TD>");
		            
					Date gc = new Date(p.getTime()); 
		            out.println("<TD>" + "month - " + gc.getMonth() + ", day - " + gc.getDay() + ", time - " + gc.getHours() + ":" + gc.getMinutes() + "</TD>");

		            out.println("<TD><a href='jsp.user/user_change_petition.jsp?id=" + p.getId() + "' /> change</a></TD>");
		            out.println("<TD><a href='jsp.user/user_delete_petition.jsp?id=" + p.getId() + "' /> delete</a></TD>");
		            out.println("</TR>");
	            }
	            
	            out.println("</TABLE>");

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return SKIP_BODY;
	    }
}
