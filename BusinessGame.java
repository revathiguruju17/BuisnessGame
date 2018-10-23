import java.util.ArrayList;
import java.util.List;

class BusinessGame {

    static void startGame(char[] grid, int numberOfPlayers, int[] diceoutput) {
        int numberOfChancesToEachPlayer = 10;
        List<Hotel> hotels = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            if (grid[i] == 'H') {
                hotels.add(new Hotel(i));
            }
        }
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player("player" + i));
        }
        int diceIndex = 0;
        for (int i = 0; i < numberOfChancesToEachPlayer; i++) {
            for (Player player : players) {
                player.position += diceoutput[diceIndex];
                diceIndex += 1;
                if (player.position >= grid.length) {
                    player.position =  player.position-grid.length;
                }
                doBusiness(grid[player.position], player, players, hotels);
            }
        }
        for (Player player : players) {
            player.money+=(player.numberOfHotelsBought*200);
            OutputDriver.printTheMessage2(player.ID,player.money);
        }
    }

    private static void doBusiness(char cellElement, Player player, List<Player> players, List<Hotel> hotels) {
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
                Hotel hotel = getHotel(hotels, player.position);
                boolean statusOfHotel = hotel.getStatusOfHotel();
                if (!statusOfHotel && player.money >= 200) {
                    hotel.setOwnerName(player.ID);
                    hotel.setStatusOfHotel();
                    player.subtractMoneyFromThePlayer(hotel.getHotelWorth());
                    player.addAnotherHotelToThePlayerAccount();
                }
                if (statusOfHotel && !hotel.getOwnerName().equals(player.ID)) {
                    player.subtractMoneyFromThePlayer(hotel.getHotelRent());
                    Player ownerOfTheHotel = getOwnerOfTheHotel(players, hotel.getOwnerName());
                    ownerOfTheHotel.addMoneyToThePlayer(hotel.getHotelRent());
                }
                break;

        }
    }

    private static Hotel getHotel(List<Hotel> hotels, int hotelID) {
        for (Hotel hotel : hotels) {
            if (hotel.hotelID == hotelID) {
                return hotel;
            }
        }
        return null;
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


