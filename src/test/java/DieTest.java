import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {


    Die dice = new Die();

    @Test
    void CheckRollReturnsAValidDiceRoll(){

        int val = dice.roll();
        assertTrue(1 <= val && val <= 6);

    }

    @Test
    void CheckGetValReturnsDiceValue(){
        int val = dice.getVal();
        assertTrue(1 <= val && val <= 6);
    }



    @Test
    void CheckSetValCorrectly(){
        dice.setVal(6);
        assertEquals(6,dice.getVal());
        dice.setVal(1);
        assertEquals(1,dice.getVal());
    }



}