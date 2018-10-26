class Hotel extends Cell {
    int hotelNumber;
    private String ownerName;
    boolean statusOfHotel;
    private int hotelRent;
    private int hotelWorth;

    Hotel(int hotelNumber) {
        this.hotelNumber = hotelNumber;
        this.ownerName = "";
        this.statusOfHotel = false;
        this.hotelRent = 50;
        this.hotelWorth = 200;
    }

    void setOwnerName(String playerID) {
        ownerName = playerID;
    }

    void setStatusOfHotel() {
        this.statusOfHotel = true;
    }

    boolean getStatusOfHotel() {
        return this.statusOfHotel;
    }

    String getOwnerName() {
        return this.ownerName;
    }

    int getHotelRent() {
        return this.hotelRent;
    }

    int getHotelWorth() {
        return this.hotelWorth;
    }
}

