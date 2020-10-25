//class parking_spot
//contains details of spot like isElectrical for checking spot type
//typeOfVehicle for checking spot type
//isEmpty for checking empty space
class Parking_Spot {

    //Variables of class

    private String typeOfSpot;
    public boolean isEmpty;
    private boolean isElectrical;
    private String typeOfVehicle;

    public boolean isElectrical() {
        return isElectrical;
    }


    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }


    public String getTypeOfSpot() {
        return typeOfSpot;
    }

    //Constructor for
    //typeOf Spot and isElectrical

    Parking_Spot(String typeOfSpot, Boolean isElectrical) {
        this.typeOfSpot = typeOfSpot;
        this.isEmpty = true;
        this.isElectrical = isElectrical;

    }

    //To get the status of parking
    public Boolean getStatusParked() {
        return this.isEmpty;
    }


}
