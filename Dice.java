import java.util.Random;

class Dice {
    private static final int max = 12;
    private static final int min = 2;

    int getDiceOutput() {
        Random random = new Random();
        return min + random.nextInt( max - min + 1 );
    }
}
