import java.util.List;

class BusinessGame {

    static void startGame(List<Player> players, int numberOfChancesToEachPlayer, List<Cell> grid) {
        for (int i = 0; i < numberOfChancesToEachPlayer; i++) {
            for (Player player : players) {
                player.position += player.rollDice();
                if (player.position >= grid.size()) {
                    player.position = player.position - grid.size();
                }
                doBusiness( grid.get( player.position ), player );
            }
        }
        for (Player player : players) {
            player.addHotelMoneyToActualMoney();
        }
        players.sort( Player::compareTo );
        for (Player player : players) {
            OutputDriver.printTheMessage( player.toString() );
        }
    }

    private static void doBusiness(Cell cell, Player player) {
        if (cell instanceof Empty) {
        } else if (cell instanceof Treasure) {
            Treasure treasure = (Treasure) cell;
            player.money += treasure.getTreasureValue();
        } else if (cell instanceof Jail) {
            Jail jail = (Jail) cell;
            player.money -= jail.getFineAmount();
        } else {
            Hotel hotel = (Hotel) cell;
            if (!hotel.getStatusOfHotel() && player.money >= 200) {
                hotel.setOwner( player );
                player.numberOfHotelsBought += 1;
                player.money -= hotel.getHotelWorth();
                hotel.setStatusOfHotel();
            } else if (hotel.getStatusOfHotel() && !hotel.getOwner().equals( player )) {
                player.money -= hotel.getHotelRent();
                hotel.owner.money += hotel.getHotelRent();
            }
        }
    }
}


