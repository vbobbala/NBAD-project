package myPackage;

import java.sql.SQLException;
import java.sql.ResultSet;
//import java.sql.Statement;
//import java.sql.Connection;

public class User1 {

	DBclass conn= new DBclass();
	
	int userid;
	String password;
	String dob;
	String email;

	public User1() {
		super();
	}


	public User1(int userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
	}
	

	public User1(int userid, String password, String dob, String email) {
		super();
		this.userid = userid;
		this.password = password;
		this.dob = dob;
		this.email = email;
	}


	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void insertRecordUsers(int usr, String pass, String dob,
			String email) throws SQLException {
		

		String SQL = "INSERT INTO user VALUES('"+ usr + "', '"
				+ pass + "', '" + dob + "', '" + email + "');";
		try{
			conn.connectMeIn();
			conn.insertResultSet(SQL);
			conn.closeConnection();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

	public String getUserPassword(int userid2) {

		ResultSet rs;

		String retpass = null;
		String SQL = "SELECT user.PASSWORD FROM USER WHERE USER.USERID = "
				+ "'" + userid2 + "'";

		try {
			
			conn.connectMeIn();
			rs = conn.resultSet(SQL);
			rs.next();
			retpass = rs.getString(1);
			//System.out.println(retpass);
			conn.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("get Password");
			e.printStackTrace();

		}

		return retpass;
	}

	public void selectAllUsers() {
		String SQL = "select * from USER";
		ResultSet rs;
		try {
			conn.connectMeIn();
			rs = conn.resultSet(SQL);
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			conn.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
