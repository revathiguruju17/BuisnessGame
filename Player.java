class Player {
    private final String ID;
    int position;
    private int money;
    private int numberOfHotelsBought;

    Player(String ID) {
        this.ID = ID;
        this.position = -1;
        this.money = 1000;
        this.numberOfHotelsBought = 0;
    }

    private int getPlayerMoney() {
        return this.money;
    }

    void addMoneyToThePlayer(int amount) {
        this.money += amount;
    }

    void subtractMoneyToThePlayer(int amount) {
        this.money -= amount;
    }

    void updatePosition(int position) {
        this.position += position;
    }

    void addHotelToThePlayer() {
        this.numberOfHotelsBought += 1;
    }

    int compareTo(Player player) {
        int compareMoney = player.getPlayerMoney();
        return compareMoney - this.money;
    }

    void addHotelWorthToPlayerMoney() {
        this.money += (this.numberOfHotelsBought * 200);
    }

    public String toString() {
        return this.ID + " " + this.money;
    }

    int rollDice() {
        return new Dice().getDiceOutput();
    }

    boolean hasMoneyToBuyHotel(int hotelWorth) {
        return this.money>=hotelWorth;
    }
}