package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entities.Brigade;
import dao.BrigadeDao;

public class JDBCBrigadeDao implements BrigadeDao {

	@Override
	public void create(Brigade brigade) {
		try {
			Connection con = null;
			try {
				con = JDBCConnection.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = con.prepareStatement(
							"INSERT INTO brigade (employee_id) values (?)",
							Statement.RETURN_GENERATED_KEYS);
					st.setInt( 1, brigade.getIdEmployee());
					st.executeUpdate();

					ResultSet key = null;
					try {
						key = st.getGeneratedKeys();
						int userId = 0;
						if (key.next()) {
							userId = key.getInt(1);
						}
						brigade.setId(userId);
					} finally {
						if (key != null)
							key.close();
						key = null;
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

	}

	@Override
	public Brigade find(int id) {
		Brigade brigade = null;
		try {
			Connection cn = null;
			try {
				JDBCConnection connection = JDBCConnection.getInstance();
				cn = connection.getConnection();
				PreparedStatement st = null;
				try {
					st = cn.prepareStatement("SELECT * FROM brigade WHERE id = ?");
					st.setInt(1, id);
					ResultSet rs = null;
					try {
						rs = st.executeQuery();
						if (rs.next()) {
							brigade = new Brigade(rs.getInt(1), rs.getInt(2));
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
		return brigade;
	}

	@Override
	public List<Brigade> findAll() {
		 List<Brigade> brigade = new ArrayList<Brigade>();
		 
			try {
				Connection cn = null;
				try {
					cn = JDBCConnection.getInstance().getConnection();
					Statement st = null;
					try {
						st = cn.createStatement();
						ResultSet rs = null;
						try {
							rs = st.executeQuery("SELECT * FROM brigade");
							 while (rs.next()) {
					                brigade.add(new Brigade(rs.getInt(1) , rs.getInt(2)));
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
	        return brigade;
	}

	@Override
	public void update(int id, Brigade brigade) {
		try {
			Connection cn = null;
			try {
				JDBCConnection connection = JDBCConnection.getInstance();
				cn = connection.getConnection();
				PreparedStatement st = null;
				try {
					st = cn.prepareStatement("UPDATE brigade SET (employee_id = ?) WHERE id = ?");
					st.setInt(1, brigade.getIdEmployee());
					st.setInt(2, id);
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
					st = cn.prepareStatement("DELETE FROM brigade WHERE id = ?");
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
