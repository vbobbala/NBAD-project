package myPackage;

public class FlightOrder {

	private Flight flight;
	private int numItems;

	public FlightOrder(Flight flight, int numItems) {
		setFlight(flight);
		setNumItems(numItems);

	}

	public Flight getFlight() {
		return (flight);
	}

	protected void setFlight(Flight f) {
		this.flight = f;
	}

	public int getFlightid() {

		return (getFlight().getFlightid());

	}

	public int getCost() {
		return (getFlight().getCost());
	}

	public int getNumItems() {
		return numItems;
	}

	public void setNumItems(int n) {
		this.numItems = n;

	}

	public void incrementNumItems() {
		setNumItems(getNumItems() + 1);
	}

	public void cancelOrder() {
		setNumItems(0);
	}

	public int getTotalCost() {
		// System.out.println(getNumItems());
		return (getCost() * getNumItems());
	}

}
