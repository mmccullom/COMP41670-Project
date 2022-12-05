import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class VerifierTest {
    Board b;
    {
        try {
            b = new Board();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    Verifier vf = new Verifier();




    @Test
    void checkNoWhiteInBlackHomeWhenBoardInitialised(){
        assertTrue(vf.whiteInBlackHome(b.getCols()));
    }

    /*

    @Test
    void checkWhiteInBlackHomeReturnsFalseWhenBlackColumnIsEmpty(){

        var cols = b.getCols();
        //cols.clear();
        Checker checker1 = null;
        try {
            checker1 = new Checker('b');
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //for (int i=19; i<=24; i++)

            cols.get(24).remove(1);

            //cols.get(25).remove(1);


        assertFalse(Verifier.whiteInBlackHome(b.getCols()));
    }
*/
    @Test
    void checkBlacksInWhiteHomeReturnsTrueWhenBoardInitialised(){
        Board b;
        {
            try {
                b = new Board();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        assertTrue(Verifier.blackInWhiteHome(b.getCols()));

    }



}