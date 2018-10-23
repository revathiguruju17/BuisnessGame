public class BusinessGameDriver {
    public static void main(String[] args) {
        setupGame();
    }

    private static void setupGame() {
        String cellElements = "0EEJHETJTEEHJTHEEJHETJTEEHJTHJEEJHETJTEEHJTEHE";
        char[] grid = cellElements.toCharArray();
        OutputDriver.printTheMessage1();
        int numberOfPlayers = InputDriver.scanTheInputAsInteger();
        int[] diceoutput = {4, 4, 4, 6, 7, 8, 5, 11, 10, 12, 2, 3, 5, 6, 7, 8, 5, 11, 10, 12, 2, 3, 5, 6, 7, 8, 5, 11, 10, 12};
        BusinessGame.startGame(grid,numberOfPlayers,diceoutput);
    }
}
