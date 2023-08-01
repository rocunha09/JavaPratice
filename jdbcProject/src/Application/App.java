package Application;

import java.sql.Statement;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;

public class App {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			
			rs = st.executeQuery("select * from pessoas");
			
			while(rs.next()) {
				System.out.println(rs.getInt("id") + ", " + rs.getString("nome"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
