package com.dev.dummy.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.dev.dummy.bean.UserBeanLombok;

public class UserDAOJDBCImpl implements UserDAO {
	UserBeanLombok user;
	FileReader reader;
	Properties prop;

	public UserDAOJDBCImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader = new FileReader("jdbc.properties");
			prop = new Properties();
			prop.load(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<UserBeanLombok> getAllInfo() {
		List<UserBeanLombok> list = new ArrayList<UserBeanLombok>();
		String query = prop.getProperty("selectQuery");
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				user = new UserBeanLombok();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserBeanLombok getInfo(int userid) {
		String query = prop.getProperty("selectQueryParam");
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password")); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, userid);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					user = new UserBeanLombok();
					user.setUserid(rs.getInt(1));
					user.setUsername(rs.getString(2));
					user.setEmail(rs.getString(3));
				}
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insertUser(UserBeanLombok user) {
		String query = prop.getProperty("insertQuery");
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password")); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, user.getUserid());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			
			int count = pstmt.executeUpdate();
			if(count>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(int userid, String password) {
		return false;
	}
}
