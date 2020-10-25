import java.util.Scanner;

class ParkingLot {

    String owner;
    Floor[] floor = new Floor[5];

    //initializing floor array with floor object

    {
        for (int i = 0; i < 5; i++) floor[i] = new Floor();
    }


    public ParkingLot(String owner) {
        this.owner = owner;
    }

    Scanner sc = new Scanner(System.in);

    // welcome message
    //with entry, exit and floor info

    public void welcome() {
        System.out.println("Hello sir, You are welcome in The Desi Parking owned by Mr. " + this.owner);

        System.out.println("We have a total of 3 entry and 3 exit(in case of fire),"
                + " and contain 5 floor, hope you like our services");

    }

    //checking empty space

    public boolean showSpace() {
        System.out.println("System is checking the available parking lot, please wait.... ");
        if (!Display.diaplayViaFloor(floor)) {
            System.out.println("Sorry, No Space Avalible. ");
            return false;
        }

        return true;
    }

    //checking empty space

    public boolean checkSpace(Customer c, Owner owner) {
        if (!SpaceCheck.diaplayViaFloor(floor, c)) {
            System.out.println("Sorry we are out of space for your vehicle");
            return false;
        }

        // making challan for the new cos.
        // fixing duration of vehicle parked
        // and checking for valid input

        Challan ch = new Challan(c);
        System.out.println("Please tell the total time (in hrs) of your stay. -> ");
        ch.timeStay = InputValidation.inputCheckInt(sc.next());
        if (ch.timeStay < 0) {
            System.out.println("Invalid Input Please try again");
            ch.timeStay = sc.nextInt();
        }

        //setting challan no

        c.setChallan_no();

        // we have a challan and we will add it to the owner class.

        owner.Arrli.add(ch);

        return true;
    }

    // pay for cheching paid customer

    public void pay(Owner owner, int challanNo) {

        if (owner.Arrli.get(challanNo - 1).hasPaid) {
            System.out.println("This Customer has already paid!!!!");
            return;
        }

        // checking valid chalan no

        if (challanNo > owner.Arrli.size() || challanNo < 1) {
            System.out.println("Invalid Input!!");
            return;
        }

        //if electrical adding charging amount to total payeble amount
        //showing total amount

        int amount = owner.Arrli.get(challanNo - 1).amount();
        if (owner.Arrli.get(challanNo - 1).c.isElectrical) {
            if (owner.Arrli.get(challanNo - 1).c.isElectricalWantToPay) {
                System.out.println("Amount " + 10 * owner.Arrli.get(challanNo - 1).timeStay + " has been added to amount " + amount + " because of charging");
                amount += 10 * owner.Arrli.get(challanNo - 1).timeStay;
            }
        }
        System.out.print("I hope you enjoyed our services, your total amount is -> " + amount);


        //asking payment methods
        //and showing paid message

        if (!owner.Arrli.get(challanNo - 1).c.hasPaidOnCustomerInfo) {
            System.out.println();
            System.out.println("How you Want to pay??");

            System.out.println("Press 1 to pay via Cash and 2 to pay via Card");


            int option = InputValidation.inputCheckInt(sc.next());

            if (option == 1) System.out.println(amount + " has been paid through cash.");
            else if (option == 2) System.out.println(amount + " has been recived .");
            else {
                System.out.println("Invalid Input");
                return;
            }

            owner.addprofit(amount);

        } else {
            System.out.println(" Which you have paid sucessfully.");
        }

        //changing haspaid to true
        //and making the alloted place empty
        //with a thankyou message

        owner.Arrli.get(challanNo - 1).hasPaid = true;
        int indexOfFreedParkingLot = owner.Arrli.get(challanNo - 1).c.place;
        int floorNo = owner.Arrli.get(challanNo - 1).c.floorNo;

        floor[floorNo - 1].park[indexOfFreedParkingLot].isEmpty = true;

        System.out.println("Thank you!!!!, Hope you visit again.");

    }

}
