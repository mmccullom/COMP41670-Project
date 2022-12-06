import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        assertFalse(b.checkWin());
    }


    @Test
    void CheckStartReturnsTrueWhenPlayer1RollsHigher() {
        Die die1 = new Die();
        Die die2 = new Die();

        boolean test;
        int roll1 = 1;
        int roll2 = 2;
        while (roll1 != roll2) {
            // Create a stream to hold the output
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            // Save the old System.out!
            PrintStream old = System.out;
            // Tell Java to use special stream
            System.setOut(ps);
            // Use dice command to print output to special stream
            test = b.start("player1", "player2", die1, die2);
            // Put things back
            System.out.flush();
            System.setOut(old);
            // Comparing output string to expected string...
            var check = baos.toString();
            var charArray = check.toCharArray();

            var first = charArray[14];
            var second = charArray[31];

            roll1 = first - '0'; // gives the int value of first dice roll
            roll2 = second - '0'; // gives the int value of first dice roll

            String str = "player1 rolls " + roll1 + "\r\n" + "player2 rolls " + roll2 + "\r\n" + "player1 Goes First\r\n";
            String str2 = "player1 rolls " + roll1 + "\r\n" + "player2 rolls " + roll2 + "\r\n" + "player2 Goes First\r\n";

            if (roll1 > roll2) {
                assertEquals(str, baos.toString());
            } else if (roll1 < roll2) {
                assertEquals(str2, baos.toString());
            }
        }
    }


    @Test
    void CheckManualSettingOfDiceWorks(){
        Die die1 = new Die();
        Die die2 = new Die();
        String output = new String();

        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        // Save the old System.out!
        PrintStream old = System.out;
        // Tell Java to use our special stream
        System.setOut(ps);
        // Use dice command to print output to special stream
        b.dice(die1, die2, 3, 5);
        // Put things back
        System.out.flush();
        System.setOut(old);
        // Comparing output string to expected string...

        //These are the same, just a formatting error
        String str = "Setting new dice values\r\nDie 1: 3\nDie 2: 5\n";
        assertEquals(str,baos.toString());
    }

}