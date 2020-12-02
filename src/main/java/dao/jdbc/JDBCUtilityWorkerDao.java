package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entities.UtilityWorker;
import dao.UtilityWorkerDao;

public class JDBCUtilityWorkerDao implements UtilityWorkerDao {

	@Override
	public void create(UtilityWorker utilityWorker) {
		try {
			Connection con = null;
			try {
				con = JDBCConnection.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = con.prepareStatement(
							"INSERT INTO utility_worker (worker, time_for_work) values (?, ?)",
							Statement.RETURN_GENERATED_KEYS);
					st.setString(1, utilityWorker.name());
					st.setLong(2, utilityWorker.getTimeForWork());
					st.executeUpdate();

				} finally {
					if (st != null)
						st.close();
					st = null;
				}
			} finally {
				if (con != null)
					con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		}
	@Override
	public int find(String name) {
		int id = 0;
		try {
			Connection cn = null;
			try {
				JDBCConnection connection = JDBCConnection.getInstance();
				cn = connection.getConnection();
				PreparedStatement st = null;
				try {
					st = cn.prepareStatement("SELECT * FROM utility_worker WHERE worker = ?");
					st.setString(1, name);
					ResultSet rs = null;
					try {
						rs = st.executeQuery();
						if (rs.next()) {
							id = rs.getInt(1);
						}
					} finally {
						if (rs != null)
							rs.close();
						rs = null;
					}
				} finally {
					if (st != null)
						st.close();
					st = null;
				}
			} finally {
				if (cn != null)
					cn.close();
				cn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	@Override
	public UtilityWorker find(int id) {
		UtilityWorker utilityWorker = null;
		try {
			Connection cn = null;
			try {
				JDBCConnection connection = JDBCConnection.getInstance();
				cn = connection.getConnection();
				PreparedStatement st = null;
				try {
					st = cn.prepareStatement("SELECT * FROM utility_worker WHERE id = ?");
					st.setInt(1, id);
					ResultSet rs = null;
					try {
						rs = st.executeQuery();
						if (rs.next()) {
							utilityWorker = UtilityWorker.valueOf(rs.getString(2));
						}
					} finally {
						if (rs != null)
							rs.close();
						rs = null;
					}
				} finally {
					if (st != null)
						st.close();
					st = null;
				}
			} finally {
				if (cn != null)
					cn.close();
				cn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilityWorker;
	}

	@Override
	public List<UtilityWorker> findAll() {
		List<UtilityWorker> utilityWorker = new ArrayList<UtilityWorker>();

		try {
			Connection cn = null;
			try {
				cn = JDBCConnection.getInstance().getConnection();
				Statement st = null;
				try {
					st = cn.createStatement();
					ResultSet rs = null;
					try {
						rs = st.executeQuery("SELECT * FROM utility_worker ");
						while (rs.next()) {
							utilityWorker.add(UtilityWorker.valueOf(rs.getString(2)));
						}
					} finally {
						if (rs != null)
							rs.close();
						rs = null;
					}
				} finally {
					if (st != null)
						st.close();
					st = null;
				}
			} finally {
				if (cn != null)
					cn.close();
				cn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilityWorker;
	}

	@Override
	public void delete(int id) {
		try {
			Connection cn = null;
			try {
				cn = JDBCConnection.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = cn.prepareStatement("DELETE FROM utility_worker WHERE id = ?");
					st.setInt(1, id);
					st.executeUpdate();

				} finally {
					if (st != null)
						st.close();
					st = null;
				}
			} finally {
				if (cn != null)
					cn.close();
				cn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	

}
