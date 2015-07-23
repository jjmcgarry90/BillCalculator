import java.util.ArrayList;
import java.util.Scanner;


public class BillCalculator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("How many guests? ");
		int numGuests = scan.nextInt();
		
		System.out.print("How many tenants? ");
		int numTenants = scan.nextInt();
		
		System.out.print("What was the total cost? ");
		double totalCost = scan.nextDouble();
		double tenantCost = totalCost;
		System.out.print("How many days in this month? ");
		int numDaysInMonth = scan.nextInt();
		
		for(int i = 0; i < numGuests; i++) {
			System.out.print("Enter guest name: ");
			String name = scan.next();
			System.out.print("How many days did " + name + " stay? ");
			int numDays = scan.nextInt();
			double cost = totalCost / (numGuests + numTenants) * numDays / numDaysInMonth;
			System.out.print(name + " owes " + cost);
			tenantCost -= cost;
			System.out.println();
		}
		
		System.out.println("Each tenant owes " + tenantCost/numTenants);
	}
}
