import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordTest {
    @Test
    @DisplayName("Test normal word source file can be processed")
    public void wordSourceFromFileTest1() {
        Words w = new Words();
        w.randomWord(this.getClass().getResource("/word.txt").getFile());
        ArrayList<String> test = new ArrayList<>();
        test.add("Hahaha");
        test.add("enenen");
        assertEquals(test, w.getCustomwords());
    }


    @Test
    @DisplayName("Test non-text word source file can be detected")
    public void wordSourceFromFileTest2() {
        Words w = new Words();
        ArrayList<String> test = new ArrayList<>();
        w.getCustomwords().clear();
        w.randomWord(this.getClass().getResource("/Picture.jpg").getFile());
        assertEquals(test, w.getCustomwords());
    }


    @Test
    @DisplayName("Test the normal function of returning word from chosen category")
    public void categoryTest() {
        Words w = new Words();
        String testWord1 = w.randomWord(1);
        assertTrue(Arrays.asList(w.getScottish_places()).contains(testWord1));

        String testWord2 = w.randomWord(2);
        assertTrue(Arrays.asList(w.getCountries()).contains(testWord2));

        String testWord3 = w.randomWord(3);
        assertTrue(Arrays.asList(w.getScottish_towns()).contains(testWord3));
    }
}
