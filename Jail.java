class Jail extends Cell {
    private final int jailFine;

    Jail() {
        this.jailFine = 150;
    }

    int getFineAmount() {
        return this.jailFine;
    }
}
