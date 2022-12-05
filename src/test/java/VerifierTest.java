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