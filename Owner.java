//owner class
//contains profitTillNow, owner name
// getTotalChallanTillNow, getCurrentInfo, getTotalInfo
// and related setter and getters function

import java.util.ArrayList;

class Owner {
    public ArrayList<Challan> Arrli = new ArrayList<>();

    //Variables of class

    private int profitTillNow = 0;
    private String ownerName = "Group-1";


    public void addprofit(int profit) {
        this.profitTillNow += profit;
    }

    public int getTotalProfit() {
        return profitTillNow;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getTotalChallanTillNow() {
        return Arrli.size();
    }

    public void getCurrentInfo() {
        for (int i = 0; i < Arrli.size(); i++) {
            if (Arrli.get(i).hasPaid == false)
                System.out.println(Arrli.get(i).c.vehicle + " of mr. " + Arrli.get(i).c.name + " on floor number. " + Arrli.get(i).c.floorNo + " ");
        }
    }

    public void getTotalInfo() {
        for (int i = 0; i < Arrli.size(); i++) {
            System.out.println(Arrli.get(i).c.vehicle + " of mr. " + Arrli.get(i).c.name + " on floor number. " + Arrli.get(i).c.floorNo + " ");
        }
    }
}
