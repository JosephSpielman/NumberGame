import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


class DecisionTest {

    @Test
     void returnNewGameTrue() {
        assertTrue(Decision.continuePlaying("y"));
    }
    @Test
    void returnNewGameFalse() {
        assertFalse(Decision.continuePlaying("n"));
    }
    @Test
    void getLowerPlayerMessage(){
        assertEquals("Your guess was too low.",Decision.incorrectMessage(2,1));
    }

    @Test
    void getHigherPlayerMessage(){
        assertEquals("Your guess was too high.",Decision.incorrectMessage(1,2));
    }
    @Test
    void getPlayerName(){
        assertEquals("Jim",Decision.getPlayerName("Jim"));
    }
    @Test
    void yesContinuePlaying(){assertEquals(true,Decision.continuePlaying("y"));}
    @Test
    void noContinuePlaying(){assertEquals(false,Decision.continuePlaying("n"));}
}