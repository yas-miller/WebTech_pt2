package taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import model.entities.Tenant;

import org.apache.log4j.Logger;

import dao.jdbc.JDBCDaoFactory;

public class UserChangeSemself extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(UserChangeSemself.class);     
	
    @Override
    public int doStartTag() throws JspException {
        int id = Integer.parseInt(pageContext.getRequest().getParameter("id"));
       
        try {
            JspWriter out = pageContext.getOut();

			Tenant tenant = new JDBCDaoFactory().createTenantDao().find(id);
			
            out.println("<TABLE border=1>");
            out.println("<TR valign=\"top\">");
            out.println("<TD>Name</TD>");
            out.println("<TD>Adress</TD>");
            out.println("<TD>Login</TD>");
            out.println("<TD>Password</TD>");
            out.println("</TR>");
            out.println("<TR>");
			
			out.println("<input type=\"hidden\" name=\"id\" value=" + tenant.getId() + ">");
            out.println("<TD><input type=\"text\" name=\"name\" value=" + tenant.getName() + "> </TD>");
            out.println("<TD><input type=\"text\" name=\"adress\" value=" + tenant.getAddress() + "> </TD>");
            out.println("<TD><input type=\"text\" name=\"login\" value=" + tenant.getLogin() + "> </TD>");
            out.println("<TD><input type=\"text\" name=\"password\" value=" + tenant.getPassword() + "> </TD>");
            out.println("</TR>");
            out.println("</TABLE>");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}