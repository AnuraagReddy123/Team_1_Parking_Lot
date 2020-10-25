//class Display
//for showing total empty space
//and its spot type and also
//electrical spot
class Display {
    static boolean displayViaParkingSpot(Parking_Spot[] parkingSpot) {
        boolean isSpace = false;
        for (int i = 0; i < 22; i++) {
            if (parkingSpot[i].getStatusParked()) {
                isSpace = true;
                System.out.print("place found of type -> " + parkingSpot[i].getTypeOfSpot());
                if (parkingSpot[i].isElectrical()) {
                    System.out.println(" Which is also Electrical.");
                } else {
                    System.out.println();
                }
            }
        }
        return isSpace;
    }

    static boolean diaplayViaFloor(Floor[] floor) {
        int freeFloor = 5;
        for (int i = 0; i < 5; i++) {

            System.out.println("On Floor " + (i + 1));

            if (!displayViaParkingSpot(floor[i].park)) {
                freeFloor--;
                System.out.println("Parking Spot Not Avalible.");
            }
        }
        if (freeFloor == 0) return false;
        else return true;
    }
}
