package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entities.ExpressService;
import dao.ExpressServiceDao;

public class JDBCExpressServiceDao implements ExpressServiceDao {

	@Override
	public void create(ExpressService expressService) {
		try {
			Connection cn = null;
			try {
				cn = JDBCConnection.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = cn.prepareStatement(
							"INSERT INTO express_service (express_service) values (?)",
							Statement.RETURN_GENERATED_KEYS);
					st.setString(1, expressService.name());
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
					st = cn.prepareStatement("SELECT * FROM express_service WHERE express_service = ?");
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
	public ExpressService find(int id) {
		ExpressService expressService = null;
		try {
			Connection cn = null;
			try {
				JDBCConnection connection = JDBCConnection.getInstance();
				cn = connection.getConnection();
				PreparedStatement st = null;
				try {
					st = cn.prepareStatement("SELECT * FROM express_service WHERE id = ?");
					st.setInt(1, id);
					ResultSet rs = null;
					try {
						rs = st.executeQuery();
						if (rs.next()) {
							expressService = ExpressService.valueOf(rs
									.getString(2));
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
		return expressService;
	}

	@Override
	public List<ExpressService> findAll() {
		List<ExpressService> expressService = new ArrayList<ExpressService>();

		try {
			Connection con = null;
			try {
				con = JDBCConnection.getInstance().getConnection();
				Statement st = null;
				try {
					st = con.createStatement();
					ResultSet rs = null;
					try {
						rs = st.executeQuery("SELECT * FROM express_service ");
						while (rs.next()) {
							expressService.add(ExpressService.valueOf(rs
									.getString(2)));
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
				if (con != null)
					con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return expressService;
	}

	@Override
	public void delete(int id) {
		try {
			Connection cn = null;
			try {
				cn = JDBCConnection.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = cn.prepareStatement("DELETE FROM express_service WHERE id = ?");
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
