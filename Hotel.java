class Hotel extends Cell {
    Player owner;
    private boolean statusOfHotel;
    private int hotelRent;
    private int hotelWorth;

    Hotel() {
        this.owner = null;
        this.statusOfHotel = false;
        this.hotelRent = 50;
        this.hotelWorth = 200;
    }

    void setOwner(Player player) {
        this.owner = player;
    }

    void setStatusOfHotel() {
        this.statusOfHotel = true;
    }

    boolean getStatusOfHotel() {
        return this.statusOfHotel;
    }

    Player getOwner() {
        return this.owner;
    }

    int getHotelRent() {
        return this.hotelRent;
    }

    int getHotelWorth() {
        return this.hotelWorth;
    }
}

