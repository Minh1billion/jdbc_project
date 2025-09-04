package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.CategoryDAO;
import vn.iotstar.model.Category;

public class CategoryDAOImpl extends DBConnection implements CategoryDAO {
	@Override
	public void insert(vn.iotstar.model.Category category) {
		String sql = "INSERT INTO Category (cate_name, icons) VALUES (?, ?)";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setString(2, category.getIcon());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(vn.iotstar.model.Category category) {
		String sql = "UPDATE Category SET cate_name = ?, icons = ? WHERE cate_id = ?";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setString(2, category.getIcon());
			ps.setInt(3, category.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int cateid) {
		String sql = "DELETE FROM Category WHERE cate_id = ?";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cateid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Category get(int id) {
		String sql = "SELECT * FROM category WHERE cate_id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("cate_id"));
				category.setName(rs.getString("cate_name"));
				category.setIcon(rs.getString("icons"));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<Category>();
		String sql = "SELECT * FROM Category";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("cate_id"));
				category.setName(rs.getString("cate_name"));
				category.setIcon(rs.getString("icons"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public Category get(String catename) {
		String sql = "SELECT * FROM category WHERE cate_name = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, catename);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("cate_id"));
				category.setName(rs.getString("cate_name"));
				category.setIcon(rs.getString("icons"));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> search(String keyword) {
		List<Category> categories = new ArrayList<Category>();
		String sql = "SELECT * FROM Category WHERE cate_name LIKE ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("cate_id"));
				category.setName(rs.getString("cate_name"));
				category.setIcon(rs.getString("icons"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}
}
