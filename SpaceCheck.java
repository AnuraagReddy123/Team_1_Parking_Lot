// class SpaceCheck extending display
// checking requirements for available space
// check space is in parking lot, which is calling Display and spacechecka and showspace methods
class SpaceCheck extends Display {
    static int displayViaParkingSpot(Parking_Spot[] parkingSpot, Customer c) {

        for (int i = 0; i < 22; i++) {
            if (parkingSpot[i].isEmpty && parkingSpot[i].getTypeOfSpot().equals(c.vehicleType) && parkingSpot[i].isElectrical() == c.isElectrical) {

                parkingSpot[i].isEmpty = false;
                return i;
            }
        }
        return -1;
    }

    // displayViaFloor
    // finding and showing allocated floor

    static boolean diaplayViaFloor(Floor[] floor, Customer c) {
        for (int i = 0; i < 5; i++) {
            int place = displayViaParkingSpot(floor[i].park, c);
            if (place >= 0) {
                System.out.println("We Found a Perfect place for you, please go to floor " + (i + 1));
                c.floorNo = (i + 1);
                c.place = place;
                return true;
            }
        }
        return false;
    }
}
