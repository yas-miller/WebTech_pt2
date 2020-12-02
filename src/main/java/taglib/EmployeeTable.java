package taglib;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import model.entities.Employee;

import org.apache.log4j.Logger;

import dao.jdbc.JDBCDaoFactory;

public class EmployeeTable extends TagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(EmployeeTable.class);     
	
	    @Override
	    public int doStartTag() throws JspException {
	        
			
	        try {
	            //Get the writer object for output.
	            JspWriter out = pageContext.getOut();

				JDBCDaoFactory factory = new JDBCDaoFactory();
		    	
				List<Employee> employees = factory.createEmployeeDao().findAll();

				logger.info("employees:" + employees);
				
	            out.println("<TABLE border=1>");
	            out.println("<TR valign=\"top\">");
	            out.println("<TD>Id</TD>");
	            out.println("<TD>Name</TD>");
	            out.println("<TD>Utility Worker</TD>");
	            out.println("<TD> </TD>");
	            out.println("<TD> </TD>");
	            out.println("</TR>");
	            
	            for(Employee e: employees){
	            	out.println("<TR>");
		            out.println("<TD>" + e.getId() + "</TD>");
		            out.println("<TD>" + e.getName() + "</TD>");
		            out.println("<TD>" + e.getUtilityWorker() + "</TD>");
					
		            out.println("<TD><a href='jsp.admin/admin_change_employee.jsp?id=" + e.getId() + "' /> change</a></TD>");
		            out.println("<TD><a href='jsp.admin/admin_delete_employee.jsp?id=" + e.getId() + "' /> delete</a></TD>");
		            out.println("</TR>");
	            } 
	            out.println("</TABLE>");
	            out.println("<INPUT type=\"submit\" name=\"command\" value=\"Додати нового співробітника\">");
	        
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return SKIP_BODY;
	    }
}