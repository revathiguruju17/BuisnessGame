import java.util.List;

class BusinessGame {

    static void startGame(List<Player> players, int numberOfChancesToEachPlayer, List<Cell> grid) {
        for (int i = 0; i < numberOfChancesToEachPlayer; i++) {
            for (Player player : players) {
                player.position += player.rollDice();
                while (player.position >= grid.size()) {
                    player.position = player.position - grid.size();
                }
                doBusiness( grid.get( player.position ), player );
            }
        }
        for (Player player : players) {
            player.addHotelWorthToPlayerMoney();
        }
        players.sort(Player::compareTo);
        for (Player player : players) {
            OutputDriver.printTheMessage(player.toString());
        }
    }

    private static void doBusiness(Cell cell, Player player) {
        if (cell instanceof Empty) {
            Empty empty = (Empty) cell;
            empty.doTask();
        } else if (cell instanceof Treasure) {
            Treasure treasure = (Treasure) cell;
            treasure.doTask( player );
        } else if (cell instanceof Jail) {
            Jail jail = (Jail) cell;
            jail.doTask( player );
        } else {
            Hotel hotel = (Hotel) cell;
            hotel.doTask( player );
        }
    }
}

