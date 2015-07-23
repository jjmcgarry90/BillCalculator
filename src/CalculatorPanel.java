import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class CalculatorPanel extends JPanel implements ActionListener {
	private MyCheckbox[][] days;
	private double totalCost;
	private double dailyCost;
	private Occupant[] persons;
	
	public CalculatorPanel(double totalCost, int daysInPeriod, Occupant ... persons) {
		setPreferredSize(new Dimension(1000,800));
		setLayout(new GridLayout(daysInPeriod+2,persons.length+1));
		this.persons=persons;
		this.totalCost=totalCost;
		dailyCost = totalCost/daysInPeriod;
		days = new MyCheckbox[daysInPeriod][persons.length];
		
		add(new JLabel("DAY"));

		for (int i=0; i<persons.length; i++)
			this.add(new JLabel(persons[i].getName()));
		
		for (int i=0; i<(daysInPeriod);i++) {
			add(new JLabel(String.valueOf(i+1)));
			for(int j=0; j<persons.length; j++) {
				MyCheckbox checkbox = new MyCheckbox(persons[j]);
				if (persons[j].isTenant())
					checkbox.setSelected(true);
				days[i][j] = checkbox;
				add(checkbox);
			}
		}
		
		Button calculator = new Button("Calculate cost");
		calculator.addActionListener(this);
		add(calculator);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (Occupant o : persons) 
			o.setOwedAmount(0);
		
		//
		for(int i = 0 ; i < days.length ; i++) {
			MyCheckbox[] day = days[i];
			int numOccupants=0;
			for (MyCheckbox cb : day) {
				if (cb.isSelected())
					numOccupants++;
			}
			double costPerPerson = dailyCost/numOccupants;
			for (MyCheckbox cb : day) {
				if (cb.isSelected()) {
					Occupant o = cb.getOccupant();
					o.setOwedAmount(o.getOwedAmount()+costPerPerson);
				}
			}
		}
		
		StringBuilder output = new StringBuilder("");
		for (Occupant o : persons)
			output.append(o.getName() + " : $" + o.getOwedAmount() + "\n");
		
		
		output.append("Total: ");
		output.append(totalCost);
	
		JOptionPane.showMessageDialog(null,output, "Totals",JOptionPane.PLAIN_MESSAGE);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("MAIN");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int daysInPeriod = Integer.parseInt(JOptionPane.showInputDialog(frame,"How many days are in the billing period?"));
		double totalCost = Double.parseDouble(JOptionPane.showInputDialog(frame, "Total cost to split?"));
		
		Occupant jessie = new Occupant("Jessie", true);
		Occupant drew = new Occupant("James", true);
		Occupant james = new Occupant("Drew", true);
		Occupant courtney = new Occupant("Courtney", false);
		Occupant blair = new Occupant("Blair", false);
		Occupant debbie = new Occupant("Debbie",false);
		
		CalculatorPanel panel = new CalculatorPanel(totalCost,daysInPeriod, jessie, drew, james, courtney, blair, debbie);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
