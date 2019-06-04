package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {

	 private final String DRIVER_NAME = "org.h2.Driver";
	 private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
	 private final String DB_USER = "sa";
	 private final String DB_PASS = "";

	 public List<Mutter> findAll(){
		 Connection conn = null;
		 List<Mutter> mutterList = new ArrayList<Mutter>();

		 try {
			 Class.forName(DRIVER_NAME);
			 conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			 String sql = "SELECT ID,NAME,TEXT FROM MUTTER ORDER BY ID DESC";
			 PreparedStatement pStmt = conn.prepareStatement(sql);

			 ResultSet rs = pStmt.executeQuery();

			 while(rs.next()) {
				 int id = rs.getInt("ID");
				 String userName = rs.getString("NAME");
				 String text = rs.getString("TEXT");
				 Mutter mutter = new Mutter(id, userName, text);
				 mutterList.add(mutter);
			 }
		 	 }catch(SQLException e) {
				 e.printStackTrace();
				 return null;
			 }catch (ClassNotFoundException e) {
				 e.printStackTrace();
				 return null;
			 }finally {
				 if(conn != null){
					 try {
						 conn.close();
					 }catch(SQLException e) {
						 e.printStackTrace();
						 return null;
					 }
			 }
		 }
		 return mutterList;
	 }
	 public boolean create(Mutter mutter) {
		 Connection conn = null;
		 try {
			 conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			 String sql = "INSERT INTO MUTTER(NAME, TEXT) VALUES(?,?)";
			 PreparedStatement pStmt = conn.prepareStatement(sql);
			 pStmt.setString(1, mutter.getUserName());
			 pStmt.setString(2, mutter.getText());

			 int result = pStmt.executeUpdate();

			 if(result != 1) {
				 return false;
			 }
		 }catch(SQLException e) {
			 e.printStackTrace();
			 return false;
		 }finally {
			 if(conn != null) {
				 try {
					 conn.close();
				 }catch(SQLException e) {
					 e.printStackTrace();
				 }
			 }
		 }
		 return true;
	 }

 }