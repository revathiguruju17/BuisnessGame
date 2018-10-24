import java.util.ArrayList;
import java.util.List;

public class BusinessGameDriver {
    public static void main(String[] args) {
        setupGame();
    }

    private static void setupGame() {
        String cellElements = "EEJHETJTEEHT";
        char[] grid = cellElements.toCharArray();
        OutputDriver.printTheMessage1();
        int numberOfPlayers = InputDriver.scanTheInputAsInteger();
        int[] diceOutput = {4, 4, 4, 6, 7, 8, 5, 11, 10, 12, 2,7};
        List<Player> players =new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player("player" + i));
        }
        int numberOfChancesForEachPlayer=4;
        BusinessGame.startGame(grid,players,diceOutput,numberOfChancesForEachPlayer);
    }
}
