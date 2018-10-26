import java.util.ArrayList;
import java.util.List;

public class Grid {
    static List<Cell> setUpGrid(String cellElements) {
        List<Cell> grid = new ArrayList<>();
        for (int i = 0; i < cellElements.length(); i++) {
            switch (cellElements.charAt( i )) {
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
                    Cell hotel = new Hotel( i );
                    grid.add( hotel );
            }
        }
        return grid;
    }
}
