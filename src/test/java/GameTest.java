import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    Game loop1 = new Game();

    @Test
    void CheckGetStringOnlyWorksForInputROrA(){
        var scanner1 = new Scanner("A");
        var scanner2 = new Scanner("R");
        var scanner3 = new Scanner("a");
        var scanner4 = new Scanner("r");

        assertEquals("A", loop1.getString(scanner1));
        assertEquals("R", loop1.getString(scanner2));
        assertEquals("A", loop1.getString(scanner3));
        assertEquals("R", loop1.getString(scanner4));

    }
}