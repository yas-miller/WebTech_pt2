package dao.jdbc;

import dao.BrigadeDao;
import dao.DaoFactory;
import dao.EmployeeDao;
import dao.ExpressServiceDao;
import dao.PetitionDao;
import dao.ScaleWorkDao;
import dao.TenantDao;
import dao.UtilityWorkerDao;
import dao.WorkDao;

public class JDBCDaoFactory extends DaoFactory {

	@Override
	public TenantDao createTenantDao() {
		return new JDBCTenantDao();
	}

	@Override
	public PetitionDao createPetitionDao() {
		return new JDBCPetitionDao();
	}

	@Override
	public EmployeeDao createEmployeeDao() {
		return new JDBCEmployeeDao();
	}

	@Override
	public BrigadeDao createBrigadeDao() {
		return new JDBCBrigadeDao();
	}

	@Override
	public WorkDao createWorkDao() {
		return new JDBCWorkDao();
	}

	@Override
	public ExpressServiceDao createExpressServiceDao() {
		return new JDBCExpressServiceDao();
	}

	@Override
	public ScaleWorkDao createScaleWorkDao() {
		return new  JDBCScaleWorkDao();
	}

	@Override
	public UtilityWorkerDao createUtilityWorkerDao() {
		return new JDBCUtilityWorkerDao();
	}

}
