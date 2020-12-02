package taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

public class AdminAddNewUser extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(AdminAddNewUser.class);     
	
    @Override
    public int doStartTag() throws JspException {
       
        try {
            JspWriter out = pageContext.getOut();
			
            out.println("<TABLE border=1>");
            out.println("<TR valign=\"top\">");
            out.println("<TD>Name</TD>");
            out.println("<TD>Adress</TD>");
            out.println("<TD>Login</TD>");
            out.println("<TD>Password</TD>");
            out.println("</TR>");
            out.println("<TR>");
			
            out.println("<TD><input type=\"text\" name=\"name\" value=\"\"> </TD>");
            out.println("<TD><input type=\"text\" name=\"adress\" value=\"\"> </TD>");
            out.println("<TD><input type=\"text\" name=\"login\" value=\"\"> </TD>");
            out.println("<TD><input type=\"text\" name=\"password\" value=\"\"> </TD>");
            out.println("</TR>");
            out.println("</TABLE>");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}