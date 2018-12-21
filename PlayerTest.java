import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {

    @Test
    void testForPlayerMoney(){
        Player player= new Player( "player1" );
        assertTrue(player.hasMoneyToBuyHotel( 200 ));
    }

    @Test
    void testForPlayerPosition(){
        Player player = new Player( "player1" );
        assertEquals(1,player.position);
    }
}
