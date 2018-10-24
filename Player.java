class Player {
    final String ID;
    int position;
    int money;
    int numberOfHotelsBought;

    Player(String ID) {
        this.ID = ID;
        this.position = -1;
        this.money = 1000;
        this.numberOfHotelsBought = 0;
    }
}
