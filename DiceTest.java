import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DiceTest {
    @Test
    void test1(){
        Dice dice = new Dice();
        assertTrue(dice.getDiceOutput()>1);
    }

    @Test
    void test2(){
        Dice dice = new Dice();
        assertTrue(dice.getDiceOutput()<13);
    }
}
