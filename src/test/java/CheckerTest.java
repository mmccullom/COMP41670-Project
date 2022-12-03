import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {


    @Test
    void blackCheckerShouldReturnBlack(){
        Checker piece = null;
        try {
            piece = new Checker('b');
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertTrue(piece.isBlack());
    }


    @Test
    void blackCheckerShouldNotReturnWhite(){
        Checker piece = null;
        try {
            piece = new Checker('b');
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertFalse(piece.isWhite());
    }


    @Test
    void whiteCheckerShouldReturnWhite(){
        Checker piece = null;
        try {
            piece = new Checker('w');
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertTrue(piece.isWhite());
    }


    @Test
    void whiteCheckerShouldNotReturnBlack(){
        Checker piece = null;
        try {
            piece = new Checker('w');
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertFalse(piece.isBlack());
    }


}