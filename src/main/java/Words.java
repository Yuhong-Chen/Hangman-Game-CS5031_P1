import java.io.*;
import java.util.ArrayList;

/**
 * Class to provides random words from 3 categories or read word from specified external TXT file.
 *
 * @author Edwin Brady
 * @author Yuhong Chen
 */


public class Words {

    public static String[] Scottish_places = {"Argyll and Bute", "Caithness", "Kingdom of Fife",
            "East Lothian", "Highland", "Dumfries and Galloway",
            "Renfrewshire", "Scottish Borders", "Perth and Kinross"};
    public static String[] countries = {"Scotland", "England", "Wales", "Northern Ireland", "Ireland",
            "France", "Germany", "Netherlands", "Spain", "Portugal",
            "Belgium", "Luxembourg", "Switzerland", "Italy", "Greece"};
    public static String[] Scottish_towns = {"St Andrews", "Edinburgh", "Glasgow", "Kirkcaldy", "Perth",
            "Dundee", "Stirling", "Inverness", "Aberdeen", "Falkirk"};

    private static ArrayList<String> customwords = new ArrayList();
    private static final int SCOTTISH_PLACES = 1;
    private static final int COUNTRIES = 2;
    private static final int SCOTTISH_TOWNS = 3;

    /**
     * Provides a random word from one of 3 categories.
     *
     * @param category
     * @return a word in chosen catrgory.
     */
    public static String randomWord(int category) {
        if (category == 1)
            return Scottish_places[(int) (Math.random() * 9)];
        if (category == 2)
            return countries[(int) (Math.random() * 15)];
        return Scottish_towns[(int) (Math.random() * 10)];
    }

    /**
     * Check the file exsists and ends with ".txt". Use bufferd reader to read valid words in lines.
     * Provide a random word from this file.
     *
     * @param wordsource file name
     * @return a word from the file
     */
    public static String randomWord(String wordsource) {
        FileReader fileReader = null;
        File file = null;
        try {
            file = new File(wordsource);
            if (file.getName().endsWith("txt")) {
                fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
                String line = null;

                while ((line = reader.readLine()) != null) {
                    if (check_valid_characters(line)) {
                        customwords.add(line);
                    }
                }
            }
            if (customwords.size() > 0) {
                return customwords.get((int) (Math.random() * customwords.size()));
            } else return null;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        } catch (IOException e) {
            System.out.println("IO error");
            return null;
        }
    }

    /**
     * Check the word in this certain line consists of english characters.
     *
     * @param line a line in provided file.
     * @return
     */
    public static boolean check_valid_characters(String line) {
        return line.matches("[a-zA-Z]+");
    }

    /**
     *
     * @return customwords.
     */
    public ArrayList<String> getCustomwords() {
        return customwords;
    }


    public String[] getScottish_places() {
        return Scottish_places;
    }


    public String[] getCountries() {
        return countries;
    }


    public String[] getScottish_towns() {
        return Scottish_towns;
    }


}