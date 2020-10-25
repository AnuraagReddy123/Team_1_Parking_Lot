//Class Customer contains
//method for setting vehicle, and type
// isElectrical, allotting challan no, asking payment options

import java.util.Scanner;

class Customer {

    //Variables of class

    static int x;
    public String vehicle;
    public String vehicleType;
    public boolean isElectrical = false;
    public int challan_no;
    public String payment_method;
    public boolean hasPaidOnCustomerInfo = false;
    public int floorNo;
    public String name;
    public int place;
    public boolean isElectricalWantToPay = false;

    Scanner sc = new Scanner(System.in);

    public void setVehicle() {
        System.out.println("Enter vehicle type (car,bike,truck,van)");
        vehicle = sc.next();

        // switch case for allocating vehicle type
        // by checking vehicle

        switch (vehicle.toLowerCase()) {
            case "car":
                vehicleType = "Compact";
                break;
            case "bike":
                vehicleType = "Bike";
                break;
            case "truck":
                vehicleType = "Large";
                break;
            case "van":
                vehicleType = "Compact";
                break;
            case "handicap":
                vehicleType = "Handicap";
                break;
            default:
                System.out.println("Invalid Input please Try ");
                setVehicle();
        }

    }


    public void setElectrical() {
        System.out.println("Is your vehicle Electrical (Y/N)");
        String s = sc.next();
        if (s.equals("Y")) isElectrical = true;

        //asking to charge vechile for electrical vehicle

        if (isElectrical) {
            System.out.println("Do you want to Charge your Vehicle in our parking lot? (0/1)\nAn Extra amount of 10 Rs. per hr will be added-> ");
            int op = sc.nextByte();
            if (op == 1) {
                isElectricalWantToPay = true;
            }
        }


    }

    public boolean checkElectrical() {
        return isElectrical;
    }

    // providing challan no

    public void setChallan_no() {
        this.challan_no = ++x;
        System.out.println("***your challan no " + x + " ***");
    }

    public int getChallan_no() {
        return challan_no;
    }

    public void setPayment_method() {
        String temp;
        System.out.println("Select your payment method");
        System.out.println("1)Attendant  2)Automated floor exit 3) Pay Via Customer info. ");
        System.out.println("1, 2 or 3 accordingly");
        int pay_to = sc.nextByte();
        if (pay_to == 1) temp = "Attendant";
        else if (pay_to == 2) temp = "Automated floor exit";
        else temp = "Customer Info.";
        payment_method = temp;
    }

    public String getPayment_method() {
        return payment_method;
    }

    //getting user data

    public void takeCustomerInput() {
        System.out.println("What is your name sir? ");
        name = sc.next();
        setVehicle();
        setElectrical();
    }

    // methods for asking for continuing to park or leaving

    public int methods() {
        System.out.println("Are you new or Leaving our parking?(press 1 or 2 accordingly)");
        int op = InputValidation.inputCheckInt(sc.next());
        if (op == 1) {

            takeCustomerInput();
        } else if (op == 2) {
            setPayment_method();
        } else {
            System.out.println("Invalid Input");
            methods();
        }
        return op;
    }
}
