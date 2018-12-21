import java.util.ArrayList;
import java.util.List;

public class BusinessGameTest {
    public static void main(String[] args) {
        OutputDriver.printTheMessage( "Enter the number of Players" );
        int numberOfPlayers = InputDriver.readInput();
        OutputDriver.printTheMessage( "Enter the number of chances for each player" );
        int numberOfChancesForEachPlayer = InputDriver.readInput();
        setupGame( numberOfPlayers, numberOfChancesForEachPlayer );
    }

    private static void setupGame(int numberOfPlayers, int numberOfChancesForEachPlayer) {
        char[] cells = {'E', 'E', 'J', 'H', 'E', 'T', 'J', 'T', 'H', 'T', 'E', 'J', 'T'};
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add( new Player( "player" + (i+1) ) );
        }
        Board board = new Board();
        BusinessGame.startGame( players, numberOfChancesForEachPlayer, board.setBoard( cells ) );
    }
}

