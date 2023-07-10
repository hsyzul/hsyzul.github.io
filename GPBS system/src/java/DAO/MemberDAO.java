package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Member;

public class MemberDAO {

	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "GPBS";
	private static String password = "gpbs";
	private static String driver = "oracle.jdbc.driver.OracleDriver";

	public void loadDriver(String driver) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection  getConnection(){
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
public boolean login(String email, String pass){
		
		boolean status = false;
		
		loadDriver(driver);
		
		Connection con = getConnection();
		
		String sql = "SELECT * FROM MEMBER WHERE MEMBEREMAIL = ? AND MEMBERPASSWORD = ?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			status = rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return status;
	}
	
	public String insert(Member member) {
		
		loadDriver(driver);
		
		Connection con = getConnection();
		
		String sql = "INSERT INTO MEMBER(MEMBERID, SSMNUMBER, MEMBERFULLNAME, MEMBERADDRESS, MEMBEREMAIL, MEMBERPHONE, MEMBERGENDER, MEMBERDOB, LICENSENUMBER) VALUES(?,?,?,?,?,?,?,TO_DATE(?,'YYYY-MM-DD'),?)";
		
		String result = "SUCCESSFUL";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getId());
			ps.setString(2, member.getSsm());
			ps.setString(3, member.getName());
			ps.setString(4, member.getAdd());
			ps.setString(5, member.getEmail());
			ps.setString(6, member.getPhone());
			ps.setString(7, member.getGender());
			ps.setString(8, member.getDob());
			ps.setString(9, member.getLnum());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "FAILED";
		}
		
		return result;
	}
public 	Member getDetail(String email) {
		
			Member ad = new Member();
		
		loadDriver(driver);
		
		Connection con = getConnection();
		
		String sql = "SELECT * FROM MEMBER WHERE MEMBEREMAIL = ?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			ad = new Member (rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ad;
	}
	
public String update(String id, String name, String phone, String email, String address) {
		
		String stat = "FAILED";
		
		loadDriver(driver);
		
		Connection con = getConnection();
		
		String sql = "UPDATE MEMBER SET MEMBERNAME=?, MEMBERPHONE=?, MEMBEREMAIL=?,MEMBERADDRESS=? WHERE MEMBERID = ?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4,address);
			ps.setString(5, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			stat = "SUCCESS";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stat;
	}
}