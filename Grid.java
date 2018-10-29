import java.util.ArrayList;
import java.util.List;

public class Grid {
    private List<Cell> grid;

    List<Cell> setUpGrid(String cellElements) {
        grid = new ArrayList<>();
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
                    Cell hotel = new Hotel();
                    grid.add( hotel );
            }
        }
        return grid;
    }

    public Cell getCellinTheGrid(int cellPosition) {
        return grid.get( cellPosition );
    }

}
