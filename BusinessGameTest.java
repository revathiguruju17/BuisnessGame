import java.util.ArrayList;
import java.util.List;

public class BusinessGameTest {
    public static void main(String[] args) {
        OutputDriver.printTheMessage( "Enter the number of Players" );
        int numberOfPlayers = InputDriver.scanTheInputAsInteger();
        OutputDriver.printTheMessage( "Enter the number of chances for each player" );
        int numberOfChancesForEachPlayer = InputDriver.scanTheInputAsInteger();
        setupGame( numberOfPlayers, numberOfChancesForEachPlayer );
    }

    private static void setupGame(int numberOfPlayers, int numberOfChancesForEachPlayer) {
        char cells[] = {'E','E','J','H','E','T','J','T','H','T','E','J','T'};
        List<Player> players = new ArrayList<>();
        for (int i = 0, j = 1; i < numberOfPlayers; i++, j++) {
            players.add( new Player( "player" + j ) );
        }
        Board board = new Board();
        BusinessGame.startGame( players, numberOfChancesForEachPlayer, board.setBoard( cells ) );
    }
}

