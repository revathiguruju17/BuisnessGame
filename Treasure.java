class Treasure implements Cell {
    private final int treasureValue;

    Treasure() {
        this.treasureValue = 200;
    }

    private int getTreasureValue(){
        return this.treasureValue;
    }

    public void doTask(Player player) {
        player.addMoneyToThePlayer( getTreasureValue());
    }
}
