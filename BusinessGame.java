import java.util.List;

class BusinessGame {

    static void startGame(List<Player> players, int numberOfChancesToEachPlayer, List<Cell> board) {
        for (int i = 0; i < numberOfChancesToEachPlayer; i++) {
            for (Player player : players) {
                player.updatePosition( player.rollDice() );
                while (player.position >= board.size()) {
                    player.position = player.position - board.size();
                }
                Cell cell = board.get( player.position );
                cell.doTask( player );
            }
        }
        sortThePlayersBasedOnMoney( players );
        displayThePlayerNameAndMoney( players );
    }

    private static void sortThePlayersBasedOnMoney(List<Player> players) {
        for (Player player : players) {
            player.addHotelWorthToPlayerMoney();
        }
        players.sort( Player::compareTo );
    }

    private static void displayThePlayerNameAndMoney(List<Player> players) {
        for (Player player : players) {
            OutputDriver.printTheMessage( player.toString() );
        }
    }
}

