import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {


    Score TheScore = new Score("Mark", "Mike", 10);

    @Test
    void CheckIncrementPlayerOneWorksCorrectly(){
        assertEquals(0,TheScore.getPlayer1Score());
        TheScore.incrementPlayer1Score(10);
        assertEquals(10,TheScore.getPlayer1Score());
    }

    @Test
    void CheckIncrementPlayerTwoWorksCorrectly(){
        assertEquals(0,TheScore.getPlayer2Score());
        TheScore.incrementPlayer2Score(10);
        assertEquals(10,TheScore.getPlayer2Score());
    }

    @Test
    void CheckStakeReturnsStake(){
       assertEquals(1,TheScore.getStake());
    }

    @Test
    void CheckDoubleStakeSuccessfullyDoublesTheStake(){
        TheScore.doubleStake();
        assertEquals(2,TheScore.getStake());
    }


    @Test
    void CheckPlayer1NameGetsReturnedCorrectly(){
        assertEquals("Mark",TheScore.getPlayer1Name());
    }

    @Test
    void CheckPlayer2NameGetsReturnedCorrectly(){
        assertEquals("Mike",TheScore.getPlayer2Name());
    }


    @Test
    void CheckAbilityToGivePlayer1TheCubeAndCheckWhoHasIt(){
        TheScore.givePlayer1Cube();
        assertTrue(TheScore.getPlayer1HasCube());
    }

    @Test
    void CheckAbilityToGivePlayer2TheCubeAndCheckWhoHasIt(){
        TheScore.givePlayer2Cube();
        assertTrue(TheScore.getPlayer2HasCube());
    }

    @Test
    void CheckGetLengthReturnsLength(){
        TheScore.getLength();
        assertEquals(10,TheScore.getLength());
    }



    @Test
    void CheckToStringReturnsCorrectString(){
        TheScore.givePlayer1Cube();
        String str = "[D] Mark: 0 | Mike: 0 | Match Length: 10\n";
        assertEquals(str,TheScore.toString());
    }


    @Test
    void CheckToStringWithStakeReturnsCorrectString(){
        TheScore.givePlayer1Cube();
        String str = "[D] Mark: 0 | Mike: 0 | Current Stake: 1 | Match Length: 10\n";
        assertEquals(str,TheScore.toStringWithStake());
    }

    }

