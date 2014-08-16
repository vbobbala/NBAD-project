package myPackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingDetails {

	public void insertRecordBooking(int bookid, int userid, int flightid,
			String date, int seats, int accid, int cost) throws SQLException {
		DBclass db = new DBclass();

		String SQL = "INSERT INTO BOOKING VALUES('" + bookid + "','" + userid
				+ "', '" + flightid + "', '" + date + "', '" + seats + "', '"
				+ accid + "', '" + cost + "');";
		try {
			db.connectMeIn();
			db.insertResultSet(SQL);
			db.closeConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Booking> findHistory(int userid) throws SQLException {
		ResultSet rs = null;
		ArrayList<Booking> blist = new ArrayList<Booking>();
		DBclass db = new DBclass();
		String SQL = "SELECT * FROM BOOKING WHERE USERID  = '" + userid + "';";
		db.connectMeIn();
		try {
			rs = db.resultSet(SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (rs.next()) {
			Booking book = new Booking();
			book.setBookingId(rs.getInt("bookingid"));
			book.setFlightid(rs.getInt("flightid"));
			book.setAccountid(rs.getInt("accountid"));
			book.setDate(rs.getString("date"));
			book.setNumberOfSeats(rs.getInt("numberofseats"));
			book.setTotalCost(rs.getInt("totalcost"));
			blist.add(book);
		}

		db.closeConnection();
		return blist;
	}
}
