import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

class BoardTest {

    Board b;

    {
        try {
            b = new Board();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void CheckWinReturnsFalseWhenGameNotWon(){
        //unsure how to get board into winning state to test the opposite!!
        assertFalse(b.checkWin());
    }


    //update test when figure out how to manually set results of dice roll
    @Test
    void CheckStartReturnsTrueWhenPlayer1RollsHigher(){
       Die die1 = new Die();
       Die die2 = new Die();
       assertTrue(b.start("player1", "player2", die1, die2));
       assertTrue(b.start("player1", "player2", die1, die2));
    }

    @Test
    void CheckManualSettingOfDiceWorks(){
        Die die1 = new Die();
        Die die2 = new Die();
        String output = new String();


        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        // IMPORTANT: Save the old System.out!
        PrintStream old = System.out;
        // Tell Java to use your special stream
        System.setOut(ps);
        // Use dice command to print output to special stream
        b.dice(die1, die2, 3, 5);
        // Put things back
        System.out.flush();
        System.setOut(old);
        // Comparing output string to expected string...

        //These are the same, just a formatting error
        assertEquals("Setting new dice values\nDie 1: 3\nDie 2: 5\n",baos.toString());
    }


}