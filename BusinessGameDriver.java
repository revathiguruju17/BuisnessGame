import java.util.ArrayList;
import java.util.List;

public class BusinessGameDriver {
    public static void main(String[] args) {
        setupGame();
    }

    private static void setupGame() {
        String cellElements = "EEJHETJTHTEJT";
        OutputDriver.printTheMessage( "Enter the number of Players" );
        int numberOfPlayers = InputDriver.scanTheInputAsInteger();
        List<Player> players = new ArrayList<>();
        for (int i = 0, j = 1; i < numberOfPlayers; i++, j++) {
            players.add( new Player( "player" + j ) );
        }
        OutputDriver.printTheMessage( "Enter the number of chances for each player" );
        int numberOfChancesForEachPlayer = InputDriver.scanTheInputAsInteger();
        Board grid = new Board();
        BusinessGame.startGame( players, numberOfChancesForEachPlayer, grid.setBoard( cellElements ) );
    }
}

