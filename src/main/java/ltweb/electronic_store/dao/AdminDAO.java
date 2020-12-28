package ltweb.electronic_store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ltweb.electronic_store.contants.Queries;
import ltweb.electronic_store.model.Admin;
import ltweb.electronic_store.utils.AdminConverter;
import ltweb.electronic_store.utils.DBConnect;

public class AdminDAO {
	private Connection conn;
	private DBConnect db = DBConnect.getInstance();
	
	public AdminDAO() {
		this.conn = db.getConnection();
	}
	
	public ArrayList<Admin> getAll() {
		ArrayList<Admin> admin = new ArrayList<Admin>();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_ADMIN);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				admin.add(AdminConverter.convert(rs));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return admin;
	}
	
	
}
