package taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import model.entities.UtilityWorker;

import org.apache.log4j.Logger;

public class AdminAddNewEmployee extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(AdminChangeEmployee.class);     
	
    @Override
    public int doStartTag() throws JspException {
       
        try {
            JspWriter out = pageContext.getOut();
			
            out.println("<TABLE border=1>");
            out.println("<TR valign=\"top\">");
            out.println("<TD>Name</TD>");
            out.println("<TD>UtilityWorker</TD>");
            out.println("</TR>");
            
            out.println("<TR>");
            out.println("<TD><input type=\"text\" name=\"name\" value=\"\"> </TD>");
            
            out.println("<TD>");
            out.println("<select name=\"UtilityWorker\" >");
            for(UtilityWorker u : UtilityWorker.values()){
                out.println("<option value=" + u + ">" + u + "</option>");	
            }
            out.println("</select>");
            out.println("</TD>");
            
            out.println("</TR>");
            out.println("</TABLE>");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}