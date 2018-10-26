import java.util.ArrayList;
import java.util.List;

public class BusinessGameDriver {
    public static void main(String[] args) {
        setupGame();
    }

    static void setupGame() {
        String cellElements = "EEJHETJTEEHT";
        OutputDriver.printTheMessage( "Enter the number of Players" );
        int numberOfPlayers = InputDriver.scanTheInputAsInteger();
        int[] diceOutput = {4, 4, 4, 6, 7, 8, 5, 11, 10, 12, 2, 7};
        List<Player> players = new ArrayList<>();
        for (int i = 0, j = 1; i < numberOfPlayers; i++, j++) {
            players.add( new Player( "player" + j ) );
        }
        int numberOfChancesForEachPlayer = 4;
        BusinessGame.startGame( players, diceOutput, numberOfChancesForEachPlayer, Grid.setUpGrid(cellElements));
    }

}

