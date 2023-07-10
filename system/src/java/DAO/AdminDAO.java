package DAO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import model.admin;

public class AdminDAO {
	 private static final boolean memberID = false;
	static Connection con=null;
	 static ResultSet rs = null; 
	 static PreparedStatement ps=null;
	 static Statement stmt=null;
	 int adminID;
	 
	//get admin by admin id
	 public static admin getAdminById(int adminID) {
		 admin admn=new admin();
		 try {
			 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","GPBS","gpbs");
			 ps=con.prepareStatement("select * from admin where adminID=?");
				ps.setInt(1, adminID);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					admn.setAdminID(rs.getInt("adminID"));
					admn.setAdminEmail(rs.getString("adminEmail"));
					admn.setAdminName(rs.getString("adminName"));
					admn.setAdminPhone(rs.getString("adminPhone"));
					admn.setAdminPassword(rs.getString("password"));
				}
		 }catch(Exception e) {
				e.printStackTrace();
			
			}
		 return admn;

		 }
	 
	 public static void appReq() throws SQLException {
		 
		 String Stat="approve";
		 ps.setBoolean(1, memberID);
		 rs = ps.executeQuery();
				 
		 try {
			 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","GPBS","gpbs");
			 ps=con.prepareStatement("UPDATE MEMBER SET(Status=?) WHERE MEMBERID=? FROM MEMBER");
		 
		 }catch(Exception e) {
				e.printStackTrace();
		 
		 }
		
	 }
		
		 public static void rejReq(String stat) throws SQLException {
		 
		 String Stat="reject";
		 ps.setBoolean(1, memberID);
		 rs = ps.executeQuery();	 
		 try {
			 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","GPBS","gpbs");
			 ps=con.prepareStatement("UPDATE MEMBER SET(Status=?) WHERE MEMBERID=? FROM MEMBER");
		 
		 }catch(Exception e) {
				e.printStackTrace();
		 
	 }
		 
	 }
		 
		 
	 
	 
}

