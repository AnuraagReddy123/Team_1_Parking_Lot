class Floor {
    //Variables for class
    private Parking_Spot[] park = new Parking_Spot[22];

    Floor () {
        //Initializing the Parking_Spot array
        //22 Parking Spots
        //5 Large, 10 Compact, 5 Bike, 2 Handicap
        for (int i = 0; i < 22; i++) {
            if (i < 5) {
                if (i < 3)
                    park[i] = new Parking_Spot("Large", false);
                else
                    park[i] = new Parking_Spot("Large", true);
            }
            else if (i < 10) {
                if (i < 7)
                    park[i] = new Parking_Spot("Bike", false);
                else
                    park[i] = new Parking_Spot("Bike",true);
            }
            else if (i < 20) {
                if (i < 18)
                    park[i] = new Parking_Spot("Compact", false);
                else
                    park[i] = new Parking_Spot("Compact",true);
            }
            else {
                if (i < 21)
                    park[i] = new Parking_Spot("Handicap", false);
                else
                    park[i] = new Parking_Spot("Handicap", true);
            }
        }
    }

}
