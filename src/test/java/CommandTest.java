import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {


    @Test
    void isQuitReturnsTrueForInputQ(){
        Command inputCommand = new Command("q");
        assertTrue(inputCommand.isQuit());
        Command inputCommand2 = new Command("Q");
        assertTrue(inputCommand2.isQuit());
    }

    @Test
    void isQuitReturnsFalseForRandomInput(){
        Command inputCommand4 = new Command("h");
        assertFalse(inputCommand4.isQuit());
    }


    @Test
    void isRollReturnsTrueForInputR(){
        Command inputCommand = new Command("r");
        assertTrue(inputCommand.isRoll());
        Command inputCommand2 = new Command("R");
        assertTrue(inputCommand2.isRoll());
    }


    @Test
    void isRollReturnsFalseForRandomInput(){
        Command inputCommand = new Command("h");
        assertFalse(inputCommand.isRoll());
    }

    @Test
    void isMoveReturnsTrueForInputM(){
        Command inputCommand = new Command("m");
        assertTrue(inputCommand.isMove());
        Command inputCommand2 = new Command("M");
        assertTrue(inputCommand2.isMove());
    }

    @Test
    void isMoveReturnsFalseForRandomInput(){
        Command inputCommand2 = new Command("p");
        assertFalse(inputCommand2.isMove());
    }


    @Test
    void isPipReturnsTrueForInputP(){
        Command inputCommand = new Command("p");
        assertTrue(inputCommand.isPip());
        Command inputCommand2 = new Command("P");
        assertTrue(inputCommand2.isPip());
    }


    @Test
    void isPipReturnsFalseForRandomInput(){
        Command inputCommand = new Command("r");
        assertFalse(inputCommand.isPip());
        Command inputCommand2 = new Command("h");
        assertFalse(inputCommand2.isPip());
    }


    @Test
    void isDiceReturnsTrueForInputDAndTwoNumbers(){
        Command inputCommand = new Command("DICE 5 6");
        assertTrue(inputCommand.isDice());
        Command inputCommand2 = new Command("Dice 1 5");
        assertTrue(inputCommand2.isDice());
    }

    @Test
    void isDiceReturnsFalseForRandomInput(){
        Command inputCommand = new Command("gh");
        assertFalse(inputCommand.isDice());
        Command inputCommand2 = new Command("oo");
        assertFalse(inputCommand2.isDice());
    }


    @Test
    void isHintReturnsTrueForInputH(){
        Command inputCommand = new Command("h");
        assertTrue(inputCommand.isHint());
        Command inputCommand2 = new Command("H");
        assertTrue(inputCommand2.isHint());
    }

    @Test
    void isHintReturnsFalseForRandomInput(){
        Command inputCommand = new Command("f");
        assertFalse(inputCommand.isHint());
        Command inputCommand2 = new Command("4");
        assertFalse(inputCommand2.isHint());
    }

    @Test
    void isTestReturnsTrueForInputT(){
        Command inputCommand = new Command("T 1");
        assertTrue(inputCommand.isTest());
        Command inputCommand2 = new Command("t 6");
        assertTrue(inputCommand2.isTest());
    }

    @Test
    void isTestReturnsFalseForRandomInput(){
        Command inputCommand = new Command("1");
        assertFalse(inputCommand.isTest());
        Command inputCommand2 = new Command("g");
        assertFalse(inputCommand2.isTest());
    }

    @Test
    void getArg1ReturnsTheFirstIntegerIfLessThan7(){
        Command inputCommand = new Command("dice 1 5");
        assertEquals(1, inputCommand.getArg1());
        Command inputCommand2 = new Command("DICE 6 2");
        assertEquals(6, inputCommand2.getArg1());
    }

    @Test
    void getArg1ReturnsMinus1IfAtLeast7(){
        Command inputCommand = new Command("d 7 5");
        assertEquals(-1, inputCommand.getArg1());
        Command inputCommand2 = new Command("d 11 2");
        assertEquals(-1, inputCommand2.getArg1());
    }

    @Test
    void getArg2ReturnsTheFirstIntegerIfLessThan7(){
        Command inputCommand = new Command("dice 1 5");
        assertEquals(5, inputCommand.getArg2());
        Command inputCommand2 = new Command("DICE 6 2");
        assertEquals(2, inputCommand2.getArg2());
    }

    @Test
    void getArg2ReturnsMinus1IfAtLeast7(){
        Command inputCommand = new Command("d 7 9");
        assertEquals(-1, inputCommand.getArg2());
        Command inputCommand2 = new Command("d 11 21");
        assertEquals(-1, inputCommand2.getArg2());
    }

    @Test
    void getFilenameReturnsTheFilenameIfInputIsTFollowedByTheFilename(){
        Command inputCommand = new Command("t sampleFilename.txt");
        assertEquals("sampleFilename.txt", inputCommand.getFilename());
    }




}