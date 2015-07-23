
public class Occupant {
	private String name;
	private double owedAmount;
	private boolean isTenant;
	
	public Occupant(String name, boolean isTenant) {
		setName(name);
		setTenant(isTenant);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public double getOwedAmount() {
		return owedAmount;
	}


	public void setOwedAmount(double owedAmount) {
		this.owedAmount = owedAmount;
	}


	public boolean isTenant() {
		return isTenant;
	}


	public void setTenant(boolean isTenant) {
		this.isTenant = isTenant;
	}

}
