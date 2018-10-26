import java.util.List;

class BusinessGame {

    static void startGame(List<Player> players, int[] diceOutput, int numberOfChancesToEachPlayer, List<Cell> grid) {
        int diceIndex = 0;
        for (int i = 0; i < numberOfChancesToEachPlayer; i++) {
            for (Player player : players) {
                player.position += diceOutput[diceIndex];
                diceIndex += 1;
                if (player.position >= grid.size()) {
                    player.position = player.position - grid.size();
                }
                doBusiness( grid.get( player.position ), player, players);
            }
        }
        for (Player player : players) {
            player.money += (player.numberOfHotelsBought * 200);
        }
        players.sort( Player::compareTo );
        for (Player player : players) {
            OutputDriver.printTheMessage( player.ID + " " + player.money );
        }

    }

    private static void doBusiness(Cell cell, Player player, List<Player> players) {
        if (cell instanceof Empty) {
        } else if (cell instanceof Treasure) {
            Treasure treasure = (Treasure) cell;
            player.money += treasure.getTreasureValue();
        } else if (cell instanceof Jail) {
            Jail jail = (Jail) cell;
            player.money -= jail.getFineAmount();
        }
        else{
            Hotel hotel = (Hotel) cell;
            if(!hotel.getStatusOfHotel() && player.money>=200){
                hotel.setOwnerName( player.ID );
                player.numberOfHotelsBought+=1;
                player.money-= hotel.getHotelWorth();
                hotel.setStatusOfHotel();
            }
            else if(hotel.getStatusOfHotel() && !hotel.getOwnerName().equals( player.ID )){
                player.money-=hotel.getHotelRent();
                Player owner = getOwnerOfTheHotel(hotel.getOwnerName(),players);
                owner.money+= hotel.getHotelRent();
            }

        }
    }

    private static Player getOwnerOfTheHotel(String ownerName, List<Player> players) {
        Player owner=new Player( "" );
        for(Player player: players){
            if(player.ID.equals( ownerName )){
                 owner = player;
                 break;
            }
        }
        return owner;
    }

}


