package myPackage;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private ArrayList<FlightOrder> flightsOrdered;
	private ArrayList<TravelPackageOrder> travelPackageOrdered;

	public ShoppingCart() {
		flightsOrdered = new ArrayList();
		travelPackageOrdered = new ArrayList();
	}

	
	public ArrayList getFlightsOrdered() {
		return flightsOrdered;
	}

	public ArrayList getTravelPackageOrdered() {
		return travelPackageOrdered;
	}

	public synchronized void addFlight(int flightid) throws SQLException {
		FlightOrder order;
		for (int i = 0; i < flightsOrdered.size(); i++) {
			order = (FlightOrder) flightsOrdered.get(i);
			if (order.getFlightid() == flightid) {
				order.incrementNumItems();
			}
		}
		FlightSearch fob = new FlightSearch();
		// TravelPackage tpobj= new TravelPackage();

		// now add for travel package
		FlightOrder newOrder = new FlightOrder(fob.getFindFlight(flightid), 0);
		flightsOrdered.add(newOrder);
	}

	public synchronized void setNumOrdered(int flightid, int numOrdered)
			throws SQLException {
		FlightOrder order;
		for (int i = 0; i < flightsOrdered.size(); i++) {
			order = (FlightOrder) flightsOrdered.get(i);
			if (order.getFlightid() == flightid) {
				if (numOrdered <= 0) {
					flightsOrdered.remove(i);
				} else {
					order.setNumItems(numOrdered);
				}

			}
		}
		FlightSearch fob = new FlightSearch();
		FlightOrder newOrder = new FlightOrder(fob.getFindFlight(flightid),
				numOrdered);
		flightsOrdered.add(newOrder);
		// System.out.println(order.getNumItems());
	}

	public synchronized int findCost() {
		FlightOrder order;
		int cost = 0;
		for (int i = 0; i < flightsOrdered.size(); i++) {
			order = (FlightOrder) flightsOrdered.get(i);
			// System.out.println(order.getNumItems());
			// System.out.println(order.getFlightid());
			cost = order.getTotalCost();

		}
		return cost;
	}

	public synchronized void setTravelOrdered(int travelid, int numOrdered)
			throws SQLException {
		TravelPackageOrder order;
		for (int i = 0; i < travelPackageOrdered.size(); i++) {
			order = travelPackageOrdered.get(i);
			if (order.getTravelid() == travelid) {
				if (numOrdered <= 0) {
					travelPackageOrdered.remove(i);
				} else {
					order.setNumsetitems(numOrdered);
				}

			}
		}
		FlightSearch fob = new FlightSearch();

		TravelPackageOrder newOrder = new TravelPackageOrder(
				fob.findTravelPackage(travelid), numOrdered);
		travelPackageOrdered.add(newOrder);

	}

	public synchronized int totalCost() {

		int total = 0;
		int total1 = 0;
		int total2 = 0;
		FlightOrder order;
		TravelPackageOrder order1;
		for (int i = 0; i < flightsOrdered.size(); i++) {
			order = (FlightOrder) flightsOrdered.get(i);
			total1 = total1 + order.getTotalCost();
		}
		for (int i = 0; i < travelPackageOrdered.size(); i++) {
			order1 = (TravelPackageOrder) travelPackageOrdered.get(i);
			total2 = total2 + order1.getTotalCost();
		}

		total = total1 + total2;
		return total;
	}

}
