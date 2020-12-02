package taglib;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import model.entities.ExpressService;
import model.entities.ScaleWork;
import model.entities.Petition;

import org.apache.log4j.Logger;

import dao.jdbc.JDBCDaoFactory;

public class UserChangePetition extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(UserChangePetition.class);     
	
    @SuppressWarnings("deprecation")
	@Override
    public int doStartTag() throws JspException {
        int id = Integer.parseInt(pageContext.getRequest().getParameter("id"));
       
        try {
            JspWriter out = pageContext.getOut();

            Petition petition = new JDBCDaoFactory().createPetitionDao().find(id);
			
            out.println("<TABLE border=1>");
            out.println("<TR valign=\"top\">");
            out.println("<TD>Id</TD>");
            out.println("<TD>Express service</TD>");
            out.println("<TD>Scale work</TD>");
            out.println("<TD>Time</TD>");
            out.println("</TR>");
	
            out.println("<TR>");
			out.println("<input type=\"hidden\" name=\"id\" value=" + petition.getId() + ">");
            out.println("<TD>" + petition.getId() + "</TD>");

            out.println("<TD>");
            out.println("<select name=\"ExpressService\" >");
            for(ExpressService es : ExpressService.values()){
            	if(es.equals(petition.getExpressService())){
            		 out.println("<option value="  + es + " selected>" + es + "</option>");
            	} else 
            	{
                out.println("<option value=" + es + ">" + es + "</option>");
            	}
            }
            out.println("</select>");
            out.println("</TD>");
          
            out.println("<TD>");
            out.println("<select name=\"ScaleWork\" >");
            for(ScaleWork sw : ScaleWork.values()){
            	if(sw.equals(petition.getScaleWork())){
            		 out.println("<option value="  + sw + " selected>" + sw + "</option>");
            	} else 
            	{
                out.println("<option value=" + sw + ">" + sw + "</option>");
            	}
            }
            out.println("</select>");
            out.println("</TD>");
       
            out.println("<TD>");
            Date gc = new Date(petition.getTime()); 
            out.println("month - " + "<input type=\"text\" name=\"month\" value=" + gc.getMonth() + ">" +
            		    ", day - " + "<input type=\"text\" name=\"day\" value=" + gc.getDay() + ">" +
            		   ", <br> time - " + "<input type=\"text\" name=\"hour\" value=" + gc.getHours() + ">" +
            		   		   ":" + "<input type=\"text\" name=\"minutes\" value=" + gc.getMinutes() + ">");
            out.println("</TD>");

            out.println("</TR>");
            out.println("</TABLE>");
            out.println("<input type=\"hidden\" name=\"idUser\" value=" + petition.getIdTenant() + ">");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}