import java.util.ArrayList;
import java.util.List;

public class BusinessGameDriver {
    public static void main(String[] args) {
        setupGame();
    }

     static void setupGame() {
        String cellElements = "EEJHETJTEEHT";
        List<Cell> grid = new ArrayList<>();
        setUpGrid(cellElements,grid);
        char[] Grid = cellElements.toCharArray();
        OutputDriver.printTheMessage("Enter the number of Players");
        int numberOfPlayers = InputDriver.scanTheInputAsInteger();
        int[] diceOutput = {4, 4, 4, 6, 7, 8, 5, 11, 10, 12, 2,7};
        List<Player> players =new ArrayList<>();
        for (int i = 0,j=1; i < numberOfPlayers; i++,j++) {
            players.add(new Player("player" + j));
        }
        int numberOfChancesForEachPlayer=4;
        BusinessGame.startGame(players,diceOutput,numberOfChancesForEachPlayer,grid);
    }

     static List<Cell> setUpGrid(String cellElements,List<Cell> grid) {
        for(int i=0;i<cellElements.length();i++){
            switch (cellElements.charAt( i )){
                case 'E':
                  Cell empty = new Empty();
                  grid.add( empty );
                  break;
                case 'J':
                   Cell jail = new Jail();
                   grid.add( jail );
                   break;
                case 'T':
                    Cell treasure = new Treasure();
                    grid.add( treasure );
                    break;
                case 'H':
                    Cell hotel = new Hotel(i);
                    grid.add( hotel );
            }
        }
        return grid;
    }
}
