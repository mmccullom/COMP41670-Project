import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {
    @Test
    void getSrcColumnReturnsCorrectColumn(){
        Move move1 = new Move(1, 3, false, false);
        assertEquals(1,move1.getSrcCol());
    }

    @Test
    void getDestColumnReturnsCorrectColumn(){
        Move move1 = new Move(1, 3, false, false);
        assertEquals(3,move1.getDestCol());
    }

    @Test
    void getRemoveOpponentReturnsFalseCorrectly(){
        Move move1 = new Move(1, 3, false, false);
        assertFalse(move1.getRemoveOpponent());
    }

    @Test
    void getRemoveOpponentReturnsTrueCorrectly(){
        Move move1 = new Move(1, 3, true, false);
        assertTrue(move1.getRemoveOpponent());
    }

    @Test
    void isDie1ReturnsFalseCorrectly(){
        Move move1 = new Move(1, 3, true, false);
        assertFalse(move1.isDieOne());
    }

    @Test
    void isDie1ReturnsTrueCorrectly(){
        Move move1 = new Move(1, 3, true, true);
        assertTrue(move1.isDieOne());
    }

}