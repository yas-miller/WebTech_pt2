package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entities.Tenant;
import dao.TenantDao;

public class JDBCTenantDao implements TenantDao {

	@Override
	public void create(Tenant tenant) {
		try {
			Connection con = null;
			try {
				con = JDBCConnection.getInstance().getConnection();
				PreparedStatement st = null;
				try {
					st = con.prepareStatement("INSERT INTO tenant (name, address, login, password) values (?, ?, ?, ?)"
                            , Statement.RETURN_GENERATED_KEYS);
					st.setString(1, tenant.getName());
					st.setString(2, tenant.getAddress());
					st.setString(3, tenant.getLogin());
					st.setString(4, tenant.getPassword());
		            st.executeUpdate();

					ResultSet key = null;
					try {
						key = st.getGeneratedKeys();
						int userId = 0;
			            if( key.next() ){
			            	userId = key.getInt(1);
			            }
			            tenant.setId(userId);
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
	public Tenant find(int id) {
		Tenant tenant = null;
				try {
					Connection cn = null;
					try {
						JDBCConnection connection = JDBCConnection.getInstance();
						cn = connection.getConnection();
						PreparedStatement st = null;
						try {
							st = cn.prepareStatement("SELECT * FROM tenant WHERE id = ?");
							st.setInt(1, id);
							ResultSet rs = null;
							try {
								rs = st.executeQuery();
								 if( rs.next() ){
									 tenant = new Tenant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
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
		return tenant;
	}

	@Override
	public List<Tenant> findAll() {
        List<Tenant> tenants = new ArrayList<Tenant>();
 
		try {
			Connection cn = null;
			try {
				cn = JDBCConnection.getInstance().getConnection();
				Statement st = null;
				try {
					st = cn.createStatement();
					ResultSet rs = null;
					try {
						rs = st.executeQuery("SELECT * FROM tenant ");
						 while (rs.next()) {
				                tenants.add(new Tenant(rs.getInt(1) , rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
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
        return tenants;
	}

	@Override
	public void update(Tenant tenant) {
		try {
			Connection cn = null;
			try {
				JDBCConnection connection = JDBCConnection.getInstance();
				cn = connection.getConnection();
				PreparedStatement st = null;
				try {
					st = cn.prepareStatement("UPDATE tenant SET name = ?, address = ?, login = ?, password = ? WHERE id = ? ");
					st.setString(1, tenant.getName());
					st.setString(2, tenant.getAddress());
					st.setString(3, tenant.getLogin());
					st.setString(4, tenant.getPassword());
					st.setInt(5, tenant.getId());
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
					st = cn.prepareStatement("DELETE FROM tenant WHERE id = ?");
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

	@Override
	public String getNameWithLoginAndPassword(String login, String password) {
		String name = null;
		try {
			Connection cn = null;
			try {
				JDBCConnection connection = JDBCConnection.getInstance();
				cn = connection.getConnection();
				PreparedStatement st = null;
				try {
					st = cn.prepareStatement("SELECT * FROM tenant WHERE login = ? AND password = ?");
					st.setString(1, login);
					st.setString(2, password);
					ResultSet rs = null;
					try {
						rs = st.executeQuery();
						/*
						 * ��������, ���������� �� ������������ � ���������
						 * ������� � �������
						 */
						if(rs.next()){
							Tenant tenant = new Tenant(rs.getInt(1) , rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5));
							name = tenant.getName();
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
		return name;
	}
	
	@Override
	public int getId(String login, String password) {
		int id = 0;
		try {
			Connection cn = null;
			try {
				JDBCConnection connection = JDBCConnection.getInstance();
				cn = connection.getConnection();
				PreparedStatement st = null;
				try {
					st = cn.prepareStatement("SELECT * FROM tenant WHERE login = ? AND password = ?");
					st.setString(1, login);
					st.setString(2, password);
					ResultSet rs = null;
					try {
						rs = st.executeQuery();
						/*
						 * ��������, ���������� �� ������������ � ���������
						 * ������� � �������
						 */
						if(rs.next()){
							id = rs.getInt(1);
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
		return id;
	}

}
