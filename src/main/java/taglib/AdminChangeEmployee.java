package taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import model.entities.Employee;
import model.entities.UtilityWorker;

import org.apache.log4j.Logger;

import dao.jdbc.JDBCDaoFactory;

public class AdminChangeEmployee extends TagSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(AdminChangeEmployee.class);     
	
    @Override
    public int doStartTag() throws JspException {
        int id = Integer.parseInt(pageContext.getRequest().getParameter("id"));
       
        try {
            JspWriter out = pageContext.getOut();

            Employee employee = new JDBCDaoFactory().createEmployeeDao().find(id);
			
            out.println("<TABLE border=1>");
            out.println("<TR valign=\"top\">");
            out.println("<TD>Id</TD>");
            out.println("<TD>Name</TD>");
            out.println("<TD>UtilityWorker</TD>");
            out.println("</TR>");
            
            out.println("<TR>");
            out.println("<TD>" + employee.getId() + "</TD>");
            out.println("<TD><input type=\"text\" name=\"name\" value=" + employee.getName() + "> </TD>");
            
            out.println("<TD>");
            out.println("<select name=\"UtilityWorker\" >");
            for(UtilityWorker u : UtilityWorker.values()){
            	if(u.equals(employee.getUtilityWorker())){
            		 out.println("<option value="  + u + " selected>" + u + "</option>");
            	} else 
            	{
                out.println("<option value=" + u + ">" + u + "</option>");
            	}
            }
            out.println("</select>");
            out.println("</TD>");
            
            out.println("</TR>");
            out.println("</TABLE>");
			out.println("<input type=\"hidden\" name=\"id\" value=" + employee.getId() + ">");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}