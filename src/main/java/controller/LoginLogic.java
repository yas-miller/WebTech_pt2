package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import dao.jdbc.JDBCConnection;

public class LoginLogic {
	static Logger logger = Logger.getLogger(LoginLogic.class);
	public static boolean checkLogin(String login, String password) {
		// �������� ������ � ������
		logger.info("Ckecking login and password.");
		try {
			Connection cn = null;
			try {
				JDBCConnection connection = JDBCConnection.getInstance();
				cn = connection.getConnection();
				logger.debug("Connection is successful!");
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
						logger.debug("Login and password exist!");
						return rs.next();
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
			logger.error("SQLException!");
			return false;
		} 
	}
}