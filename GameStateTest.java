import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


import static org.junit.Assert.*;

public class GameStateTest {


    @Test
    @DisplayName("normal argument input to create an instance of GameState, test class fields")
    public void GameStateArgsTest1(){
        GameState testState = new GameState("Yuhong Chen", 10,5 );
        assertEquals("Yuhong Chen",testState.getTargetWord());
        assertEquals(8,testState.getNot().size() );
        assertEquals(0,testState.getGot().size() );
        assertEquals(10,testState.getGuessesLeft());
        assertEquals(5,testState.getHintsLeft());
    }


    @Test
    @DisplayName("test letter guessing check including '?'for hint")
    public void letterCheckTest(){
        GameState testState = new GameState("Yuhong Chen", 10,5 );
        assertEquals(1,testState.checkByLetter('y'));
        assertEquals(-1,testState.checkByLetter('a'));
        assertEquals(0,testState.checkByLetter('?'));
    }


    @Test
    @DisplayName("test word guessing check")
    public void wordCheckTest(){
        GameState testState = new GameState("Yuhong Chen", 10,5 );
        assertEquals(1,testState.checkByWord("yuhong chen"));
        assertEquals(-1,testState.checkByWord("hahah"));
    }


    @Test
    @DisplayName("test if the user has won the game after correctly guessing")
    public void wonTest(){
        GameState testState = new GameState("Yuhong Chen", 10,5 );
        assertFalse(testState.won());
        testState.checkByWord("yuhong chen");
        assertTrue(testState.won());
    }


    @Test
    @DisplayName("test if the user has lost after chances for guessing ran out")
    public void lostTest(){
        GameState testState = new GameState("Yuhong Chen", 1,5 );
        testState.checkByLetter('a');
        assertTrue(testState.lost());
    }
}