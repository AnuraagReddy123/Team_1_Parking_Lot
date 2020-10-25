// Challan class, has challanNum, hasPaid, timeStay
// Challan constructor
// function amount for calculating customers amount to be paid
class Challan {
    Customer c = new Customer();

    //Variables of class

    public int challanNum;
    public boolean hasPaid = false;
    public int timeStay;

    Challan(Customer c) {
        this.c = c;
    }

    //calculating the amount to be paid as
    //per given rates for the no of hour

    int amount() {
        int duration = timeStay;
        int money = 0;
        while (duration > 0l) {
            if (duration > 3l)
                money += 5;
            if (duration <= 3l && duration > 1l)
                money += 10;
            if (duration <= 1l)
                money += 20;
            duration--;
        }
        return money;
    }

}
