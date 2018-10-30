class Treasure extends Cell {
    private final int treasureValue;


    Treasure() {
        this.treasureValue = 200;
    }

    void doTask(Player player) {
        player.money += this.treasureValue;
    }
}
