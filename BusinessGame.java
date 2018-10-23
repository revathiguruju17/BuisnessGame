import java.util.ArrayList;
import java.util.List;

class BusinessGame {

    static void startGame(char[] gridElements, int numberOfPlayers, int[] diceoutput) {
        int numberOfChancesToEachPlayer = 10, j = 0;
        List<Hotel> hotels = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < gridElements.length; i++) {
            if (gridElements[i] == 'H') {
                hotels.add(new Hotel(i));
            }
        }
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player("player" + i));
        }
        for (int i = 0; i < numberOfChancesToEachPlayer; i++) {
            for (Player player : players) {
                char cellElement = gridElements[player.position + diceoutput[j]];
                doBusiness(cellElement, player, players, hotels, player.position);
            }
        }
    }

    private static void doBusiness(char cellElement, Player player, List<Player> players, List<Hotel> hotels, int index) {
        switch (cellElement) {
            case 'E':
                break;
            case 'J':
                player.subtractMoneyFromThePlayer(new Jail().getFineAmount());
                break;
            case 'T':
                player.addMoneyToThePlayer(new Treasure().getTreasureValue());
                break;
            case 'H':
                boolean statusOfHotel = hotels.get(index).getStatusOfHotel();
                if (!statusOfHotel && player.money >= 200) {
                    hotels.get(index).setOwnerName(player.ID);
                    hotels.get(index).setStatusOfHotel();
                    player.subtractMoneyFromThePlayer(hotels.get(index).getHotelWorth());
                    player.addAnotherHotelToThePlayerAccount();
                }
                if (statusOfHotel && !hotels.get(index).getOwnerName().equals(player.ID)) {
                    player.subtractMoneyFromThePlayer(hotels.get(index).getHotelRent());
                    Player ownerOfTheHotel = getOwnerOfTheHotel(players, hotels.get(index).getOwnerName());
                    ownerOfTheHotel.addMoneyToThePlayer(hotels.get(index).getHotelRent());
                }
                break;

        }
    }

    private static Player getOwnerOfTheHotel(List<Player> players, String ownerName) {
        for (Player player : players) {
            if (player.ID.equals(ownerName)) {
                return player;
            }
        }
        return null;
    }
}


