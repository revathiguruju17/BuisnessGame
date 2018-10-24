import java.util.ArrayList;
import java.util.List;

class BusinessGame {

    static void startGame(char[] grid, List<Player> players, int[] diceOutput, int numberOfChancesToEachPlayer) {
        int diceIndex = 0;
        List<Hotel> hotels = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            if (grid[i] == 'H') {
                hotels.add(new Hotel(i));
            }
        }
        for (int i = 0; i < numberOfChancesToEachPlayer; i++) {
            for (Player player : players) {
                player.position += diceOutput[diceIndex];
                diceIndex += 1;
                if (player.position >= grid.length) {
                    player.position =  player.position-grid.length;
                }
                doBusiness(grid[player.position], player, players, hotels);
            }
        }

        String winner=players.get(0).ID;
        int maximum=0;
        for (Player player : players) {
            player.money+=(player.numberOfHotelsBought*200);
            if(maximum<player.money){
                maximum=player.money;
                winner=player.ID;
            }
            OutputDriver.printTheMessage2(player.ID,player.money);
        }
        OutputDriver.printTheMessage3(winner);
    }

    private static void doBusiness(char cellElement, Player player, List<Player> players, List<Hotel> hotels) {
        switch (cellElement) {
            case 'E':
                break;
            case 'J':
                player.money-=new Jail().getFineAmount();
                break;
            case 'T':
                player.money+=new Treasure().getTreasureValue();
                break;
            case 'H':
                Hotel hotel = getHotel(hotels, player.position);
                boolean statusOfHotel = hotel.getStatusOfHotel();
                if (!statusOfHotel && player.money >= 200) {
                    hotel.setOwnerName(player.ID);
                    hotel.setStatusOfHotel();
                    player.money-=hotel.getHotelWorth();
                    player.numberOfHotelsBought+=1;
                }
                if (statusOfHotel && !hotel.getOwnerName().equals(player.ID)) {
                    player.money-=hotel.getHotelRent();
                    Player ownerOfTheHotel = getOwnerOfTheHotel(players, hotel.getOwnerName());
                    ownerOfTheHotel.money+=hotel.getHotelRent();
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


