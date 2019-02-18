import java.util.Scanner;


/**
 * Class to prompt user to choose category if no input word scource file, create a new Gamestate instance accordingly.
 * Process guessing and show game results.
 *
 * @author Edwin Brady
 * @author Yuhong Chen
 */


public class Hangman {

    /**
     * Create GameState object using provided word source or internal source, reply to each guess and show the game results.
     *
     * @param sc Scanner instance.
     * @param opts CommandOpts instance.
     * @param g GameState instance.
     */
    static void processGame(Scanner sc, CommandOpts opts, GameState g) {
        //create GameState object using provided word source or internal source
        if (opts.getWordSource() == "" || Words.randomWord(opts.getWordSource()) == null) {
            promptCategoryChoice();
            g = new GameState(Words.randomWord(sc.nextInt()), opts.getMaxguesses(), opts.getMaxhints());
        } else {
            g = new GameState(Words.randomWord(opts.getWordSource()), opts.getMaxguesses(), opts.getMaxhints());
        }
        //reply to each guess
        while (!g.won() && !g.lost()) {
            printSystemMessage(g);
        }
        showResults(g);
    }

    /**
     * Prompt the user to make a word category choice.
     */
    private static void promptCategoryChoice() {
        System.out.println("  1. Scottish places");
        System.out.println("  2. Countries");
        System.out.println("  3. Scottish towns");
        System.out.print("Pick a category:");
    }

    /**
     * Reply to every guess or hint-asking in the format of "current obscure word + good/wrong guess/hints left".
     * @param g
     */
    private static void printSystemMessage(GameState g) {
        int singleGuessResult = g.checkGuess();
        g.showWord(g.getTargetWord());
        System.out.println("Guesses remaining: " + g.getGuessesLeft());
        if (singleGuessResult == 1) System.out.println("Good guess!");
        if (singleGuessResult == -1) System.out.println("Wrong guess!");
        if (singleGuessResult == 0) System.out.println("You have " + g.getHintsLeft() + " hint chances left! Come on!");
    }

    /**
     * Show game results in the format of "won + guesses attempts / lost + the target word".
     * @param g
     */
    private static void showResults(GameState g) {
        if (g.won()) {
            System.out.println("Well done!");
            System.out.println("You took " + g.getGuessesAttempted() + " guesses");
        } else {
            System.out.println("You lost! The TargetWord was " + g.getTargetWord());
        }
    }
}