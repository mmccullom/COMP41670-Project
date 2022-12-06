import org.junit.jupiter.api.Test;

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
        assertTrue(Verifier.blackInWhiteHome(b.getCols()));
    }

}