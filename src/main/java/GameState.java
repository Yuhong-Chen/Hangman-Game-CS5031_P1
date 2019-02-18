import java.util.ArrayList;
import java.util.Scanner;


/**
 * Class to read and check user's guess, provide hints, check if user winning the game or not.
 *
 * @author Edwin Brady
 * @author Yuhong Chen
 */


public class GameState {
    private static String TargetWord;
    private static int guessesAttempted;
    private static int guessesLeft;
    private static int hintsLeft;

    private static ArrayList<Character> got;
    private static ArrayList<Character> not;
    private static ArrayList<Character> hintAvailable;


    public Scanner sc = new Scanner(System.in).useDelimiter("\n");

    /**
     * Constructor,set a state for each target with specified upper limits of guesses and hints.
     * Initially, store all the characters of the target into the "not" arraylist,which will be used to store characters
     * not guessed yet. The characters correctly guessed are store in the "got" arraylist.
     *
     * @param target
     * @param guess
     * @param hints
     */
    public GameState(String target, int guess, int hints) {
        this.TargetWord = target;
        not = new ArrayList<Character>();
        got = new ArrayList<Character>();
        hintAvailable = new ArrayList<Character>();


        //Add all letters from TargetWord to "not" list
        for (int i = 0; i < target.length(); ++i) {
            if (!not.contains(Character.toLowerCase(target.charAt(i))) && target.charAt(i) != ' ')
                not.add(Character.toLowerCase(target.charAt(i)));
        }


        for (int i = 0; i < target.length(); ++i) {
            if (!hintAvailable.contains(Character.toLowerCase(target.charAt(i))) && target.charAt(i) != ' ')
                hintAvailable.add(Character.toLowerCase(target.charAt(i)));
        }


        //initialize the game.
        this.guessesAttempted = 0; // guesses made
        guessesLeft = guess; // guesses remaining
        this.hintsLeft = hints;
    }



    /**
     * Show characters that are correctly guessed, while "-" stands for letters still left to guess.
     * @param word
     */
    void showWord(String word) {
        for (int i = 0; i < word.length(); ++i) {
            if (got.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
    }


    /**
     * Check guess either by letter or word with recording one increment of guess action, regardless of right or wrong guess.
     *
     * @return integer value indicates the input type is word, algebra or "?" for later system message display.
     */
    public int checkGuess() {
        char letterInput;
        System.out.print("Guess a letter or word (? for a hint): ");
        String input = sc.next().toLowerCase();

        if (input.length() > 1) {
            return checkByWord(input);
        } else {
            letterInput = input.charAt(0);
            return checkByLetter(letterInput);
        }
    }


    public int checkByLetter(char letterInput) {
        if (letterInput == '?') {
            provideHint();
            recordShots();
            return 0;
        } else if (not.contains(letterInput)) {
            not.remove(not.indexOf(letterInput));
            got.add(letterInput);
            recordShots();
            return 1;
        } else {
            recordShots();
            return -1;
        }
    }


    public int checkByWord(String input) {
        if (input.equals(TargetWord.toLowerCase())) {
            not.clear();
            recordShots();
            return 1;
        } else {
            recordShots();
            return -1;
        }
    }

    /**
     *
     * @return ture if the user has won.
     */
    public boolean won() {
        return not.size() == 0;
    }

    /**
     *
     * @return ture if the user has lost.
     */
    public boolean lost() {
        return not.size() > 0 && guessesLeft == 0;
    }

    /**
     * Increment by one every time a guess or hint-asking is made.
     */
    private void recordShots() {
        guessesAttempted++;
        guessesLeft--;
    }


    /**
     * Provide a letter in target word without repeats.
     */
    void provideHint() {
        if (hintsLeft == 0) {
            System.out.println("No more hints allowed");
        } else {
            int indexOfhintForThistime = (int) (Math.random() * hintAvailable.size());
            System.out.print("Try: ");
            System.out.println(hintAvailable.get(indexOfhintForThistime));
            hintAvailable.remove(indexOfhintForThistime);

            hintsLeft--;
        }
    }


    public String getTargetWord() {
        return TargetWord;
    }


    public int getGuessesLeft() {
        return guessesLeft;
    }


    public int getGuessesAttempted() {
        return guessesAttempted;
    }


    public int getHintsLeft() {
        return hintsLeft;
    }


    public ArrayList getNot() {
        return not;
    }


    public ArrayList getGot() {
        return got;
    }
}
