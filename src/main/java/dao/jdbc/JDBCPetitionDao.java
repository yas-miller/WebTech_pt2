package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entities.Petition;
import dao.PetitionDao;

public class JDBCPetitionDao implements PetitionDao {
	@Override
	public void create(Petition petition) {
		try {
			Connection con = null;
			try {
				con = JDBCConnection.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = con.prepareStatement("INSERT INTO petition (express_service_id, scale_work_id, time, tenant_id) values (?, ?, ?, ?)"
                            , Statement.RETURN_GENERATED_KEYS);
					st.setInt(1, new JDBCDaoFactory().createExpressServiceDao().find(petition.getExpressService().name()));
					st.setInt(2, new JDBCDaoFactory().createScaleWorkDao().find(petition.getScaleWork().name()));
					st.setLong(3, petition.getTime());
					st.setInt(4, petition.getIdTenant());

		            st.executeUpdate();

					ResultSet key = null;
					try {
						key = st.getGeneratedKeys();
						int userId = 0;
			            if( key.next() ){
			            	userId = key.getInt(1);
			            }
			            petition.setId(userId);
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
	public Petition find(int id) {
		Petition petition = null;
		try {
			Connection cn = null;
			try {
				JDBCConnection connection = JDBCConnection.getInstance();
				cn = connection.getConnection();
				PreparedStatement st = null;
				try {
					st = cn.prepareStatement("SELECT * FROM petition WHERE id = ?");
					st.setInt(1, id);
					ResultSet rs = null;
					try {
						rs = st.executeQuery();
						 if( rs.next() ){
							 petition = new Petition(rs.getInt(1), new JDBCDaoFactory().createExpressServiceDao().find(rs.getInt(2)), 
									 new JDBCDaoFactory().createScaleWorkDao().find(rs.getInt(3)), rs.getLong(4), rs.getInt(5));
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
		return petition;
	}

	@Override
	public List<Petition> findAll() {
		List<Petition> petition = new ArrayList<Petition>();
		 
		try {
			Connection cn = null;
			try {
				cn = JDBCConnection.getInstance().getConnection();
				Statement st = null;
				try {
					st = cn.createStatement();
					ResultSet rs = null;
					try {
						rs = st.executeQuery("SELECT * FROM petition ");
						 while (rs.next()) {
				                petition.add(new Petition(rs.getInt(1), new JDBCDaoFactory().createExpressServiceDao().find(rs.getInt(2)), 
				                		new JDBCDaoFactory().createScaleWorkDao().find(rs.getInt(3)), rs.getLong(4), rs.getInt(5)));
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
        return petition;
	}

	@Override
	public void update(Petition petition) {
		try {
			Connection cn = null;
			try {
				JDBCConnection connection = JDBCConnection.getInstance();
				cn = connection.getConnection();
				PreparedStatement st = null;
				try {
					st = cn.prepareStatement("UPDATE petition SET express_service_id = ?, scale_work_id = ?,"
							+ " time = ?, tenant_id = ? WHERE id = ? ");
					st.setInt(1, new JDBCDaoFactory().createExpressServiceDao().find(petition.getExpressService().name()));
					st.setInt(2, new JDBCDaoFactory().createScaleWorkDao().find(petition.getScaleWork().name()));
					st.setLong(3, petition.getTime());
					st.setInt(4, petition.getIdTenant());
					st.setInt(5, petition.getId());
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
					st = cn.prepareStatement("DELETE FROM petition WHERE id = ?");
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
