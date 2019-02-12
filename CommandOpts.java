package uk.ac.standrews.cs5031;


import java.io.File;

/**
 * Class to read user's command options about numbers of guesses and hints to be set.
 * @author Edwin Brady
 * @author Yuhong Chen
 */


public class CommandOpts {

    private  int maxguesses;
    private  int maxhints;

    private static final int DEFAULT_MAX_GUESSES = 15;
    private static final int DEFAULT_MAX_HINTS = 3;

    public String wordsource;


    /**
     * Constructor.
     * Set maxguesses and maxhints as specified in the command line.
     * The source can be string or file.
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
            }
            catch(NumberFormatException e){
                System.out.println("Guesses and Hints must be positive integer! Default settings applied now.");
            }
        }
    }


    boolean checkWordSourceIsFile(String wordsource) {
        File f = new File(wordsource);
        return (f.isFile());
    }


    public int getMaxguesses() {
        return maxguesses;
    }

    public void setMaxguesses(int maxguesses) {
        this.maxguesses = maxguesses;
    }

    public int getMaxhints() {
        return maxhints;
    }

    public void setMaxhints(int maxhints) {
        this.maxhints = maxhints;
    }
}