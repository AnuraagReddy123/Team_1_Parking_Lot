import java.util.Scanner;
import java.util.ArrayList;

//class Main containing
public class PmCaseStudy {

	public static void main(String[] args) {
		ParkingLot parking = new ParkingLot("Group-1");
		Owner owner = new Owner();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {

			//welcome messege
			//taking input of customer and owner
			//asking challan no and providing amount to be paid

			System.out.println("Hello sir, Are You ->  1. Customer OR 2. Owner "
					+ "(press 1 for customer 2 for owner)");
			int typeOfUser = InputValidation.inputCheckInt(sc.next());
			if(typeOfUser==1) {
				parking.welcome();
				Customer c = new Customer();
				int op = c.methods();
				if(op==2) {
					if(c.payment_method.equals("Customer Info.")) {
							parking.floor[c.floorNo].CustomerInfo(owner);
						}else {
							System.out.println("Please tell us your challan no. -> ");
							parking.pay(owner, InputValidation.inputCheckInt(sc.next()));
						}
					System.out.println("You have paid to -> "+c.payment_method);
				}else {
					if(parking.showSpace())
						parking.checkSpace(c, owner);
				}

				//for owner showing
				//profit
				//total vehicles parked
				//list of vehicles currently parked
				//list of vehicles in parking lot

			}else if (typeOfUser == 2){
				System.out.println("Hello sir, What you want to know?");
				System.out.println("1. profit till now\n 2. Total vehicles parked till now \n 3. currently parcked vehicles\n 4. See all entries till now");
				int op = InputValidation.inputCheckInt(sc.next());
				if(op==1) {
					System.out.println("Profit is -> "+owner.getTotalProfit());
				}else if(op==2) {
					System.out.println("Total vehicles parked till now are -> "+ owner.getTotalChallanTillNow());
				}else if(op==3){
					System.out.println("List of vehicles currently in Parking Lot -> ");
					owner.getCurrentInfo();
				}else if (op == 4){
					System.out.println("List of vehicles in Parking Lot till now-> ");
					owner.getTotalInfo();
				}
				else
					System.out.println("Invalid Input");
			}
			else {
				System.out.println("Invalid Input");
			}
		}
	}

	
}