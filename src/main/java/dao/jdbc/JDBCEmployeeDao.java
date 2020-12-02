package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entities.Employee;
import dao.EmployeeDao;

public class JDBCEmployeeDao implements EmployeeDao {

	@Override
	public void create(Employee employee) {
		try {
			Connection con = null;
			try {
				con = JDBCConnection.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = con.prepareStatement("INSERT INTO employee (name, utility_worker_id) values (?, ?)"
                            , Statement.RETURN_GENERATED_KEYS);
					st.setString(1, employee.getName());
					st.setInt(2, new JDBCDaoFactory().createUtilityWorkerDao().find(employee.getUtilityWorker().name()));

		            st.executeUpdate();

					ResultSet key = null;
					try {
						key = st.getGeneratedKeys();
						int userId = 0;
			            if( key.next() ){
			            	userId = key.getInt(1);
			            }
			            employee.setId(userId);
					} finally {
						if (key != null)
							key.close();
							key=null;
					}
				} finally {
					if (st != null)
						st.close();
						st=null;
				}
			} finally {
				if (con != null)
					con.close();
					con =null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public Employee find(int id) {
		Employee employee = null;
		try {
			Connection cn = null;
			try {
				JDBCConnection connection = JDBCConnection.getInstance();
				cn = connection.getConnection();
				PreparedStatement st = null;
				try {
					st = cn.prepareStatement("SELECT * FROM employee WHERE id = ?");
					st.setInt(1, id);
					ResultSet rs = null;
					try {
						rs = st.executeQuery();
						 if( rs.next() ){
							 employee = new Employee(rs.getInt(1), rs.getString(2),  new JDBCDaoFactory().createUtilityWorkerDao().find(rs.getInt(3)));
				            }
					} finally {
						if (rs != null)
							rs.close();
							rs=null;
					}
				} finally {
					if (st != null)
						st.close();
						st=null;
				}
			} finally {
				if (cn != null)
					cn.close();
					cn=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
return employee;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employee = new ArrayList<Employee>();
		 
		try {
			Connection cn = null;
			try {
				cn = JDBCConnection.getInstance().getConnection();
				Statement st = null;
				try {
					st = cn.createStatement();
					ResultSet rs = null;
					try {
						rs = st.executeQuery("SELECT * FROM employee");
						 while (rs.next()) {
				                employee.add(new Employee(rs.getInt(1) , rs.getString(2),  new JDBCDaoFactory().createUtilityWorkerDao().find(rs.getInt(3))));
				            }
					} finally {
						if (rs != null)
							rs.close();
							rs=null;
					}
				} finally {
					if (st != null)
						st.close();
						st=null;
				}
			} finally {
				if (cn != null)
					cn.close();
					cn=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return employee;
	}

	@Override
	public void update(Employee employee) {
		try {
			Connection cn = null;
			try {
				JDBCConnection connection = JDBCConnection.getInstance();
				cn = connection.getConnection();
				PreparedStatement st = null;
				try {
					st = cn.prepareStatement("UPDATE employee SET name = ?, id_utility_worker = ? WHERE id = ?");
					st.setString(1, employee.getName());
					st.setInt(2,  new JDBCDaoFactory().createUtilityWorkerDao().find(employee.getUtilityWorker().name()));
					st.setInt(3, employee.getId());
		            st.executeUpdate();

				} finally {
					if (st != null)
						st.close();
						st=null;
				}
			} finally {
				if (cn != null)
					cn.close();
					cn=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			Connection cn = null;
			try {
				cn = JDBCConnection.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = cn.prepareStatement("DELETE FROM employee WHERE id = ?");
					st.setInt(1, id);
		            st.executeUpdate();

				} finally {
					if (st != null)
						st.close();
						st=null;
				}
			} finally {
				if (cn != null)
					cn.close();
					cn=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
