package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBclass {

	String connName;
	String userName;
	String password;
	String hostName;
	int port;
	String SID;
	Connection connection;
	static final String PATH = "com.mysql.jdbc.Driver";

	public DBclass() {
		this.connName = "nbad";
		this.userName = "root";
		this.password = "qwe123";
		this.hostName = "localhost";
		this.port = 3306;
		this.SID = "class";

	}

	public DBclass(String pconnName, String puserName, String ppassword,
			String phostName, int pport, String pSID) {
		this.connName = pconnName;
		this.userName = puserName;
		this.password = ppassword;
		this.hostName = phostName;
		this.port = pport;
		this.SID = pSID;

	}

	public void connectMeIn() {

		try {

			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.err.println(e);
			System.exit(-1);
		}

		try {
			// connection = DriverManager.getConnection("jdbc:oracle:thin:@" +
			// this.hostName + ":" + this.port +":"+ this.SID + "," +
			// this.userName + "," + this.password);

			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/nbad", "root", "qwe123");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ResultSet resultSet(String sqlstat) throws SQLException {

		Statement st = connection.createStatement();
		ResultSet res = st.executeQuery(sqlstat);
		return res;

	}

	public void insertResultSet(String sqlstat) throws SQLException {
		Statement st = connection.createStatement();
		st.executeUpdate(sqlstat);

	}


	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

}
