package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Member {

	private String id;
	private String ssm;
	private String name;
	private String add;
	private String email;
	private String phone;
	private String gender;
	private String dob;
	private String pass;
	private String lnum;
	private String stat;
	private String statD;
	private String adminID;
	
	public String getID() {
		
		String gid = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","GPBS","system");
			
			Statement st = con.createStatement();
			
			String query = "SELECT * FROM MEMBER";
			
			ResultSet rs = st.executeQuery(query);
			
			int count = 0;
			
			while(rs.next()) {
				count++;
			}
			
			gid = Integer.toString(count);
			
			rs.close();
			
			st.close();
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return gid;
	}
	
	public Member(String ssm, String name, String add, String email, String phone, String gender, String dob, String lnum) {
		this.id = getID();
		this.ssm = ssm;
		this.name = name;
		this.add = add;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.dob = dob;
		this.lnum = lnum;
	}

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSsm() {
		return ssm;
	}

	public void setSsm(String ssm) {
		this.ssm = ssm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getLnum() {
		return lnum;
	}

	public void setLnum(String lnum) {
		this.lnum = lnum;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public String getStatD() {
		return statD;
	}

	public void setStatD(String statD) {
		this.statD = statD;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", ssm=" + ssm + ", name=" + name + ", add=" + add + ", email=" + email + ", phone="
				+ phone + ", gender=" + gender + ", dob=" + dob + ", pass=" + pass + ", lnum=" + lnum + ", stat=" + stat
				+ ", statD=" + statD + ", adminID=" + adminID + "]";
	}


	
}
