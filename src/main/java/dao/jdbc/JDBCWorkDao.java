package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entities.Work;
import dao.WorkDao;

public class JDBCWorkDao implements WorkDao {

	@Override
	public void create(Work work) {
		try {
			Connection con = null;
			try {
				con = JDBCConnection.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = con.prepareStatement("INSERT INTO work (time, address, petition_id, brigade_id) values (?, ?, ?, ?)"
                            , Statement.RETURN_GENERATED_KEYS);
					st.setLong(1, work.getTime());
					st.setString(2, work.getAddress());
					st.setInt(3, work.getIdPetition());
					st.setInt(4, work.getIdBrigade());

		            st.executeUpdate();

					ResultSet key = null;
					try {
						key = st.getGeneratedKeys();
						int userId = 0;
			            if( key.next() ){
			            	userId = key.getInt(1);
			            }
			            work.setId(userId);
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
	public Work find(int id) {
		Work work = null;
		try {
			Connection cn = null;
			try {
				JDBCConnection connection = JDBCConnection.getInstance();
				cn = connection.getConnection();
				PreparedStatement st = null;
				try {
					st = cn.prepareStatement("SELECT * FROM work WHERE id = ?");
					st.setInt(1, id);
					ResultSet rs = null;
					try {
						rs = st.executeQuery();
						 if( rs.next() ){
							 work = new Work(rs.getInt(1), rs.getLong(2),rs.getString(3), rs.getInt(4), rs.getInt(5));
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
		return work;
	}

	@Override
	public List<Work> findAll() {
		List<Work> work = new ArrayList<Work>();
		 
		try {
			Connection cn = null;
			try {
				cn = JDBCConnection.getInstance().getConnection();
				Statement st = null;
				try {
					st = cn.createStatement();
					ResultSet rs = null;
					try {
						rs = st.executeQuery("SELECT * FROM work");
						 while (rs.next()) {
				                work.add(new Work(rs.getInt(1), rs.getLong(2),rs.getString(3), rs.getInt(4), rs.getInt(5)));
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
        return work;
	}

	@Override
	public void update(int id, Work work) {
		try {
			Connection cn = null;
			try {
				JDBCConnection connection = JDBCConnection.getInstance();
				cn = connection.getConnection();
				PreparedStatement st = null;
				try {
					st = cn.prepareStatement("UPDATE work SET (time = ?, address = ?, petition_id = ?, id_brigade_id = ?) WHERE id = ?");
					st.setLong(1, work.getTime());
					st.setString(2, work.getAddress());
					st.setInt(3, work.getIdPetition());
					st.setInt(4, work.getIdBrigade());
					st.setInt(5, id);
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
					st = cn.prepareStatement("DELETE FROM work WHERE id = ?");
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
