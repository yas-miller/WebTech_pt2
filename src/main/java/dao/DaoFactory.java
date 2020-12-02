package dao;

import java.util.Properties;

import org.apache.log4j.Logger;

public abstract class DaoFactory {
	static Logger logger = Logger.getLogger(DaoFactory.class);
	 	public abstract TenantDao createTenantDao();
	    public abstract PetitionDao createPetitionDao();
	    public abstract EmployeeDao createEmployeeDao();
	    public abstract BrigadeDao createBrigadeDao();    
	 	public abstract WorkDao createWorkDao();
	 	
	    public abstract ExpressServiceDao createExpressServiceDao();
	    public abstract ScaleWorkDao createScaleWorkDao();
	    public abstract UtilityWorkerDao createUtilityWorkerDao();
	    
	    public static DaoFactory getInstance(){
	        try {
	            Properties config = new Properties();
	            return (DaoFactory) Class.forName(config.getProperty("dao.factory", "dao.jdbc.JDBCDaoFactory")).newInstance();
	        } catch (Exception ex) {
	            logger.error("Exception: " + ex);
	            return null;
	        }
	    }
	}