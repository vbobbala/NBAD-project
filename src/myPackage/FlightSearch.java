package myPackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightSearch {
	DBclass db = new DBclass();

	public ArrayList<Flight> getFlightInfo(String sur, String des,
			String seats, String ecls, String date) {
		ResultSet rs;
		ArrayList<Flight> list = new ArrayList<Flight>();

		db.connectMeIn();

		String sql = "SELECT DISTINCTROW * FROM flight WHERE FLIGHT.SOURCE = "
				+ "'" + sur + "'" + " AND FLIGHT.DESTINATION = " + "'" + des
				+ "'";

		try {
			rs = db.resultSet(sql);
			while (rs.next()) {
				Flight flight = new Flight();

				flight.setSource(rs.getString("source"));
				flight.setDestination(rs.getString("destination"));
				flight.setSeatsAvailable(rs.getInt("seatsavailable"));
				flight.setDate(rs.getString("date"));
				flight.setEclass(rs.getString("eclass"));
				flight.setFlightid(rs.getInt("flightid"));
				flight.setArrivaltime(rs.getString("arrivaltime"));
				flight.setDeparturetime(rs.getString("departuretime"));
				flight.setCost(rs.getInt("cost"));
				list.add(flight);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch bloc1k
			e.printStackTrace();
		}
		db.closeConnection();

		return list;

	}

	public Flight getFindFlight(int flightid) throws SQLException {

		ResultSet rs = null;
		db.connectMeIn();
		Flight flight = new Flight();
		// System.out.println(flightid);

		String sql = "SELECT * FROM FLIGHT WHERE FLIGHTID = " + "'" + flightid
				+ "'";

		try {
			rs = db.resultSet(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (rs.next()) {

			flight.setSource(rs.getString("source"));
			flight.setDestination(rs.getString("destination"));
			flight.setSeatsAvailable(rs.getInt("seatsavailable"));
			flight.setDate(rs.getString("date"));
			flight.setEclass(rs.getString("eclass"));
			flight.setFlightid(rs.getInt("flightid"));
			flight.setArrivaltime(rs.getString("arrivaltime"));
			flight.setDeparturetime(rs.getString("departuretime"));
			flight.setCost(rs.getInt("cost"));
			flight.setSeatsBooked(rs.getInt("seatsbooked"));
			flight.setSeatsTotal(rs.getInt("seatstotal"));

		}
		db.closeConnection();

		return flight;
	}

	public void updateSeats(int avSeats, int boSeats, int id)
			throws SQLException {
		DBclass db = new DBclass();

		String SQL = "UPDATE FLIGHT SET FLIGHT.SEATSAVAILABLE=" + "'" + avSeats
				+ "'" + "WHERE FLIGHT.FLIGHTID = " + "'" + id + "'";

		String SQL1 = "UPDATE FLIGHT SET FLIGHT.SEATSBOOKED=" + "'" + boSeats
				+ "'" + "WHERE FLIGHT.FLIGHTID = " + "'" + id + "'";
		db.connectMeIn();

		db.insertResultSet(SQL);
		db.insertResultSet(SQL1);

		db.closeConnection();

	}

	public TravelPackage findTravelPackage(int travelid) throws SQLException {

		DBclass db = new DBclass();
		ResultSet rs = null;

		String SQL = "SELECT * FROM TRAVEL WHERE TRAVELID=" + "'" + travelid
				+ "'";
		db.connectMeIn();
		try {

			rs = db.resultSet(SQL);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TravelPackage tpobj = new TravelPackage();
		while (rs.next()) {
			tpobj.setCost(rs.getInt("cost"));

		}
		// System.out.println("tpobj.getCost()" + tpobj.getCost());

		db.closeConnection();
		return tpobj;
	}

}
