package uk.ac.standrews.cs5031;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class to provides random words from 3 categories.
 * @author Edwin Brady
 * @author Yuhong Chen
 */


public class Words {

    private static String[] Scottish_places = {"Argyll and Bute", "Caithness", "Kingdom of Fife",
            "East Lothian", "Highland", "Dumfries and Galloway",
            "Renfrewshire", "Scottish Borders", "Perth and Kinross"};
    private static String[] countries = {"Scotland", "England", "Wales", "Northern Ireland", "Ireland",
            "France", "Germany", "Netherlands", "Spain", "Portugal",
            "Belgium", "Luxembourg", "Switzerland", "Italy", "Greece"};
    private static String[] Scottish_towns = {"St Andrews", "Edinburgh", "Glasgow", "Kirkcaldy", "Perth",
            "Dundee", "Stirling", "Inverness", "Aberdeen", "Falkirk"};

    static ArrayList<String> customwords;
    private static final int SCOTTISH_PLACES = 1;
    private static final int COUNTRIES = 2;
    private static final int SCOTTISH_TOWNS = 3;


    public static String randomWord(int category) {
        if (category == 1)
            return Scottish_places[(int) (Math.random() * 9)];
        if (category == 2)
            return countries[(int) (Math.random() * 15)];
        return Scottish_towns[(int) (Math.random() * 10)];
    }

    public static String randomWord(String wordsource) {
        String line;
        customwords = new ArrayList<String>();

        try {
            FileReader file = new FileReader(wordsource);
            BufferedReader reader = new BufferedReader(file);
            line = reader.readLine();
            while (line != null) {
                if (!check_valid_characters(line)) {
                    reader.close();
                    return null;
                }
                customwords.add(line);
            }
            return customwords.get((int) (Math.random() * customwords.size()));
        } catch (FileNotFoundException e) {
            System.out.println("File error");
            return "";
        } catch (IOException e) {
            System.out.println("IO error");
            return "";
        }
    }


    public static boolean check_valid_characters(String line) {
        return line.matches("^.*[^a-zA-Z].*$");
    }
}