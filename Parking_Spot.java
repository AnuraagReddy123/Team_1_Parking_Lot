class Parking_Spot {
    //Variables of class
    private String typeOfSpot;
    private boolean isEmpty;
    private boolean isElectrical;
    private String typeOfVehicle;

    //Constructor
    Parking_Spot(String typeOfSpot, Boolean isElectrical) {
        this.typeOfSpot = typeOfSpot;
        this.isEmpty = true;
        this.isElectrical = isElectrical;
    }

    //Methods (Change name of methods if better are possible)
    //To set the isEmpty false when customer comes
    public void setParked(Customer c) {             //Assuming based on customer object
        //Set typeOfVehicle using customer's variable like "c.typeOfVehicle"
        this.isEmpty = false;
    }

    //To get the status of parking
    public Boolean getStatusParked() {
        return this.isEmpty;
    }
}

