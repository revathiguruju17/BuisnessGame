class Hotel implements Cell {
    private Player owner;
    private int hotelRent;
    private int hotelWorth;

    Hotel() {
        this.owner = null;
        this.hotelRent = 50;
        this.hotelWorth = 200;
    }

    public void doTask(Player player) {
        if (isHotelAvailable() && player.hasMoneyToBuyHotel(getHotelWorth())) {
            this.owner = player;
            player.addHotelToThePlayer();
            player.subtractMoneyToThePlayer( getHotelWorth() );
        } else {
            player.subtractMoneyToThePlayer( getHotelRent() );
            this.owner.addMoneyToThePlayer( getHotelRent() );
        }
    }

    private int getHotelRent() {
        return this.hotelRent;
    }

    private int getHotelWorth() {
        return this.hotelWorth;
    }

    private boolean isHotelAvailable() {
        return this.owner == null;
    }

}

