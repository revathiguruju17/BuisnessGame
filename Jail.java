class Jail implements Cell {
    private final int jailFine;

    Jail() {
        this.jailFine = 150;
    }

    private int getJailFine() {
        return this.jailFine;
    }

    public void doTask(Player player) {
        player.subtractMoneyToThePlayer( getJailFine() );
    }
}
