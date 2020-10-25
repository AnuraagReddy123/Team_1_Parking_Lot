// Floor class, has floor constructor
//Initializing the Parking_Spot array
// with typeof spot and isElectrical
//22 Parking Spots
//5 Large, 10 Compact, 5 Bike, 2 Handicap
import java.util.Scanner;

class Floor {
    //Variables for class
    public Parking_Spot[] park = new Parking_Spot[22];

    Floor() {


        for (int i = 0; i < 22; i++) {
            if (i < 5) {
                if (i < 3)
                    park[i] = new Parking_Spot("Large", false);
                else
                    park[i] = new Parking_Spot("Large", true);
            } else if (i < 10) {
                if (i < 7)
                    park[i] = new Parking_Spot("Bike", false);
                else
                    park[i] = new Parking_Spot("Bike", true);
            } else if (i < 20) {
                if (i < 18)
                    park[i] = new Parking_Spot("Compact", false);
                else
                    park[i] = new Parking_Spot("Compact", true);
            } else {
                if (i < 21)
                    park[i] = new Parking_Spot("Handicap", false);
                else
                    park[i] = new Parking_Spot("Handicap", true);
            }
        }

    }

    //CustomerInfo  for customers showing
    //->amount to be paid
    //->how to pay
    //->where to pay

    public void CustomerInfo(Owner owner) {
        System.out.println("Welcome to customer info.");
        Scanner sc = new Scanner(System.in);


        System.out.println("Can I Know Your Challan Number -> ");
        int challanNo = InputValidation.inputCheckInt(sc.next());
        if (challanNo > owner.Arrli.size() || challanNo < 1 || owner.Arrli.get(challanNo - 1).hasPaid) {
            System.out.println("Invalid User");
            return;
        }

        int amount = owner.Arrli.get(challanNo - 1).amount();

        if (owner.Arrli.get(challanNo - 1).c.isElectrical) {
            if (owner.Arrli.get(challanNo - 1).c.isElectricalWantToPay) {
                System.out.println("Amount " + 10 * owner.Arrli.get(challanNo - 1).timeStay + " has been added to amount " + amount + " because of charging");
                amount += 10 * owner.Arrli.get(challanNo - 1).timeStay;
            }
        }

        System.out.println("Your Total Ammount is Rs. " + amount);


        System.out.println("How you Want to pay??");

        System.out.println("Press 1 to pay via Cash and 2 to pay via Card");


        int option = InputValidation.inputCheckInt(sc.next());

        if (option == 1) System.out.println(amount + " has been paid through cash.");
        else if (option == 2) System.out.println(amount + " has been received .");
        else {
            System.out.println("Invalid Input");
            return;
        }

        // updating info of payment
        // for clarification at exit gates
        // and making the alloted space empty

        owner.Arrli.get(challanNo - 1).hasPaid = true;
        owner.addprofit(amount);
        owner.Arrli.get(challanNo - 1).c.hasPaidOnCustomerInfo = true;
        park[owner.Arrli.get(challanNo - 1).c.place].isEmpty = true;


    }

}
