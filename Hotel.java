class Hotel extends Cell {
    private Player owner;
    private boolean statusOfHotel;
    private int hotelRent;
    private int hotelWorth;

    Hotel() {
        this.owner = null;
        this.statusOfHotel = false;
        this.hotelRent = 50;
        this.hotelWorth = 200;
    }

    void doTask(Player player){
        if (!this.statusOfHotel && player.money >= 200) {
            this.owner=player;
            player.numberOfHotelsBought += 1;
            player.money -= this.hotelWorth;
            this.statusOfHotel=true;
        } else if(this.statusOfHotel && !this.owner.equals( player )) {
            player.money -= this.hotelRent;
            this.owner.money += this.hotelRent;
        }
    }
}

