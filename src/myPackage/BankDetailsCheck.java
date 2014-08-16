package myPackage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankDetailsCheck {
	DBclass db = new DBclass();

	public int findBalance(String accname, int accnum, int routnum)
			throws SQLException {
		db.connectMeIn();
		int balance = 0;
		ResultSet rs = null;
		String SQL = "SELECT DISTINCTROW ACCOUNT.BALANCE FROM ACCOUNT WHERE ACCOUNT.HOLDERNAME = "
				+ "'"
				+ accname
				+ "'"
				+ " AND ACCOUNT.ACCOUNTID = "
				+ "'"
				+ accnum
				+ "'"
				+ " AND ACCOUNT.ROUTINGNUMBER = "
				+ "'"
				+ routnum + "'";

		try {
			rs = db.resultSet(SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rs.next()) {
			balance = Integer.parseInt(rs.getString(1));

		} else {
			System.out.println("Invalid Account");
		}
		db.closeConnection();
		return balance;
	}

	public int checkAccount(String accname, int routnum) throws Throwable {
		db.connectMeIn();
		ResultSet rs = null;
		int accountNum = 0;
		String SQL = "SELECT DISTINCTROW ACCOUNT.ACCOUNTID FROM ACCOUNT WHERE ACCOUNT.HOLDERNAME = "
				+ "'"
				+ accname
				+ "'"
				+ " AND ACCOUNT.ROUTINGNUMBER = "
				+ "'"
				+ routnum + "'";
		try {
			rs = db.resultSet(SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rs.next()) {

			accountNum = Integer.parseInt(rs.getString(1));
		} else {
			System.out.println("no such account");
		}
		db.closeConnection();
		return accountNum;
	}

	public void updateBalance(String accname, int accnum, int routnum, int bal) {
		String SQL;
		SQL = "UPDATE ACCOUNT SET ACCOUNT.BALANCE=" + "'" + bal + "'"
				+ "WHERE ACCOUNT.ACCOUNTID = " + "'" + accnum + "'"
				+ "AND ACCOUNT.HOLDERNAME = " + "'" + accname + "'"
				+ " AND ACCOUNT.ROUTINGNUMBER = " + "'" + routnum + "'";
		db.connectMeIn();
		try {
			db.insertResultSet(SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeConnection();
	}

}
