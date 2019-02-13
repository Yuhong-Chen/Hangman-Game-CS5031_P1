import java.util.Scanner;


/**
 * The main class.
 *
 * @author Edwin Brady
 * @author Yuhong Chen
 */


public class HangmanMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameState g = null;
        CommandOpts opts;

        opts = new CommandOpts(args);

        Hangman.processGame(sc, opts, g);
    }
}
