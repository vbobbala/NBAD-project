package myPackage;

public class TravelPackageOrder {
	private TravelPackage tpackage;
	private int numsetitems;

	public TravelPackageOrder(TravelPackage tp, int n) {
		tpackage = tp;
		numsetitems = n;

	}

	public TravelPackage getTpackage() {
		return tpackage;
	}

	public void setTpackage(TravelPackage tp) {
		this.tpackage = tp;
	}

	public int getNumsetitems() {
		return numsetitems;
	}

	public void setNumsetitems(int numsetitems) {
		this.numsetitems = numsetitems;
	}

	public int getTravelid() {
		return (getTpackage().getTravelid());
	}

	public int getCost() {
		return (getTpackage().getCost());
	}

	public void incrementNumsetitems() {
		setNumsetitems(getNumsetitems() + 1);
	}

	public void cancelOrder() {
		setNumsetitems(0);
	}

	public int getTotalCost() {
		// System.out.println(getNumsetitems());
		return (getCost() * getNumsetitems());
	}

}
