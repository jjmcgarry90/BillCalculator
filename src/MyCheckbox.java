import javax.swing.JCheckBox;


public class MyCheckbox extends JCheckBox {
	private int day;
	private Occupant occupant; 
	
	public MyCheckbox(Occupant o) {
		setOccupant(o);
	}

	public Occupant getOccupant() {
		return occupant;
	}

	public void setOccupant(Occupant occupant) {
		this.occupant = occupant;
	}
}
