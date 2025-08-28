package vn.iotstar.dao.impl;

import vn.iotstar.dao.UserDao;
import vn.iotstar.connection.DBConnection;
import vn.iotstar.model.User;
import java.util.Date;
import java.sql.*;

public class UserDaoImpl implements UserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public User get(String username) {
		String sql = "SELECT * FROM [User] WHERE username = ? ";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("username"));
				user.setFullName(rs.getString("fullname"));
				user.setPassWord(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createdDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(User user) {
		String sql = "INSERT INTO [User](email, username, fullname, password, avatar, roleid,phone, createddate) VALUES (?,?,?,?,?,?,?,?)";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getFullName());
			ps.setString(4, user.getPassWord());
			ps.setString(5, user.getAvatar());
			ps.setInt(6, user.getRoleid());
			ps.setString(7, user.getPhone());
			java.util.Date utilDate = user.getCreatedDate();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			ps.setDate(8, sqlDate);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from [User] where username = ?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}
	
	@Override
	public boolean checkExistEmail(String email) {
	    boolean exists = false;
	    String sql = "SELECT * FROM [User] WHERE email = ?";
	    try {
	        conn = new DBConnection().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, email);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            exists = true;
	        }
	        ps.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return exists;
	}

	@Override
	public boolean checkExistPhone(String phone) {
	    boolean exists = false;
	    String sql = "SELECT * FROM [User] WHERE phone = ?";
	    try {
	        conn = new DBConnection().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, phone);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            exists = true;
	        }
	        ps.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return exists;
	}
}
