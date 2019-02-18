import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class CommandOptsTest {

    @Test
    @DisplayName("check when option pattern is normal")
    public void optionsPatternTest1() {
        String[] args = {"--guesses", "2", "--hints", "4", "word.txt"};
        CommandOpts opts = new CommandOpts(args);
        assertEquals(2, opts.getMaxguesses());
        assertEquals(4, opts.getMaxhints());
        assertEquals("word.txt", opts.getWordSource());

    }


    @Test
    @DisplayName("check whether the default value of maxHint would apply when option misses input number for maxHints")
    public void optionsPatternTest2() {
        String[] args = {"--guesses", "2", "--hints", "word.txt"};
        CommandOpts opts = new CommandOpts(args);
        assertEquals(2, opts.getMaxguesses());
        assertEquals(3, opts.getMaxhints());
        assertEquals("word.txt", opts.getWordSource());
    }


    @Test
    @DisplayName("check whether the default value of maxHints would apply when option misses input number for maxGuess")
    public void optionsPatternTest3() {
        String[] args = {"--guesses", "--hints", "4", "word.txt"};
        CommandOpts opts = new CommandOpts(args);
        assertEquals(10, opts.getMaxguesses());
        assertEquals(4, opts.getMaxhints());
        assertEquals("word.txt", opts.getWordSource());
    }


    @Test
    @DisplayName("check when no word file source is provided")
    public void optionsPatternTest4() {
        String[] args = {"--guesses", "2", "--hints", "4"};
        CommandOpts opts = new CommandOpts(args);
        assertEquals(2, opts.getMaxguesses());
        assertEquals(4, opts.getMaxhints());
        assertEquals("", opts.getWordSource());
    }


    @Test
    @DisplayName("check when no argument input")
    public void optionsPatternTest5() {
        String[] args = {""};
        CommandOpts opts = new CommandOpts(args);
        assertEquals(10, opts.getMaxguesses());
        assertEquals(3, opts.getMaxhints());
        assertEquals("", opts.getWordSource());
    }


    @Test
    @DisplayName("check for non-positive guesses and hints argument")
    public void optionsPatternTest6() {
        String[] args = {"--guesses", "0", "--hints", "-1"};
        CommandOpts opts = new CommandOpts(args);
        assertEquals(10, opts.getMaxguesses());
        assertEquals(3, opts.getMaxhints());
        assertEquals("", opts.getWordSource());
    }

}

