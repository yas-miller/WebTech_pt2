package taglib;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import model.entities.Tenant;

import org.apache.log4j.Logger;

import dao.jdbc.JDBCDaoFactory;

public class UserTable extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(UserTable.class);     
	
	    @Override
	    public int doStartTag() throws JspException {
	        
			
	        try {
	            //Get the writer object for output.
	            JspWriter out = pageContext.getOut();

				JDBCDaoFactory factory = new JDBCDaoFactory();
		    	
				List<Tenant> tenants = factory.createTenantDao().findAll();
				for (Tenant t : tenants) {
					if("admin".equals(t.getLogin())){
						tenants.remove(t);
						break;
					}
				}
				logger.info("tenants:" + tenants);
				
	            out.println("<TABLE border=1>");
	            out.println("<TR valign=\"top\">");
	            out.println("<TD>Id</TD>");
	            out.println("<TD>Name</TD>");
	            out.println("<TD>Adress</TD>");
	            out.println("<TD>Login</TD>");
	            out.println("<TD>Password</TD>");
	            out.println("<TD> </TD>");
	            out.println("<TD> </TD>");
	            out.println("</TR>");
	            
	            for(Tenant t: tenants){
	            	out.println("<TR>");
		            out.println("<TD>" + t.getId() + "</TD>");
		            out.println("<TD>" + t.getName() + "</TD>");
		            out.println("<TD>" + t.getAddress() + "</TD>");
		            out.println("<TD>" + t.getLogin() + "</TD>");
		            out.println("<TD>" + t.getPassword() + "</TD>");
	
		            out.println("<TD><a href='jsp.admin/admin_change_user.jsp?id=" + t.getId() + "' > change</a></TD>");
		            out.println("<TD><a href='jsp.admin/admin_delete_user.jsp?id=" + t.getId() + "' > delete</a></TD>");
		            out.println("</TR>");
	            }
	            
	            out.println("</TABLE>");
	            out.println("<INPUT type=\"submit\" name=\"command\" value=\"Add new User\">");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return SKIP_BODY;
	    }
}
