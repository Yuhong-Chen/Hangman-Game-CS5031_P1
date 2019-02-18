import java.io.File;

/**
 * Class to read user's command options about numbers of guesses and hints to be set.
 *
 * @author Edwin Brady
 * @author Yuhong Chen
 */


public class CommandOpts {

    private int maxguesses;
    private int maxhints;

    private static final int DEFAULT_MAX_GUESSES = 10;
    private static final int DEFAULT_MAX_HINTS = 3;

    private static String wordsource;


    /**
     * Constructor.
     * Set maxguesses and maxhints as specified in the command line.
     * The source can be string or file.
     *
     * @param args
     */
    public CommandOpts(String[] args) {
        setMaxguesses(DEFAULT_MAX_GUESSES);
        setMaxhints(DEFAULT_MAX_HINTS);

        wordsource = "";

        for (int i = 0; i < args.length; ++i) {
            try {
                if (args[i].equals("--guesses")) {
                    setMaxguesses(Integer.parseInt(args[i + 1]));
                    i++;
                } else if (args[i].equals("--hints")) {
                    setMaxhints(Integer.parseInt(args[i + 1]));
                    i++;
                } else if (checkWordSourceIsFile(args[i])) {
                    wordsource = args[i];
                }
            } catch (NumberFormatException e) {
                System.out.println("You may have missed input the value for guesses or hints? Default settings are applied now.");
            }
        }
    }

    /**
     * Check the ecternal word source intended to use is a file.
     * @param wordsource the name of the file.
     * @return
     */
    boolean checkWordSourceIsFile(String wordsource) {
        try {
            File f = new File(wordsource);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * @return wordsource.
     */
    public String getWordSource() {
        return wordsource;
    }

    /**
     *
     * @return maxguesses.
     */
    public int getMaxguesses() {
        return maxguesses;
    }

    /**
     * Check whether the input max guesses is positive. Set the maxGuesses as positive input or default value.
     * @param maxguesses
     */
    public void setMaxguesses(int maxguesses) {
        if (maxguesses > 0) {
            this.maxguesses = maxguesses;
        } else {
            System.out.println("The max guesses must be a positive integer!Default settings are applied now.");
        }
    }

    /**
     *
     * @return maxhints.
     */
    public int getMaxhints() {
        return maxhints;
    }

    /**
     *  Check whether the input max hints is positive. Set the maxHints as positive input or default value.
     * @param maxhints
     */
    public void setMaxhints(int maxhints) {
        if (maxhints > 0) {
            this.maxhints = maxhints;
        } else {
            System.out.println("The max hints cannot be negative!Default settings are applied now.");
        }
    }
}