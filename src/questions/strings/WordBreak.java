package questions.strings;

import annotation.Strategy;
import annotation.SwitchMenu;
import utils.InputUtils;
import base.DSABase;
import base.StringQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tmsbn on 6/1/16.
 * Given a string of words and a string of characters, find if the string of characters can be broken into individual valid words from the dictionary
 */
public class WordBreak extends StringQuestions implements DSABase {

    Set<String> dictionary = new HashSet<>();
    String word;

    @Override
    public void execute() {

        dictionary = InputUtils.getWordsFromUser("Enter match words");
        word = InputUtils.getStringFromUser("Enter input text");
        new SwitchMenu(this).show();

    }

    /**
     * Key insights:
     * - This can be solved using dynamic programming
     * - Use a boolean array to keep track of sub problems
     * - If position i of boolean array is true, this means that all characters from 0 to i of word string satisfy the criteria of the question
     */
    @Strategy
    public void DynamicProgramming() {

        int length = word.length();
        boolean[] validWords = new boolean[length];

        for (int i = 0; i < length; i++) {

            if (dictionary.contains(word.substring(0, i + 1))) {
                validWords[i] = true;
            }

            if (validWords[i]) {
                for (int j = i + 1; j < length; j++) {
                    if (dictionary.contains(word.substring(i + 1, j + 1))) {
                        validWords[j] = true;
                    }
                }
            }

            if (validWords[length - 1]) {
                System.out.print("It can be broken into words");
                return;
            }
        }
        System.out.print("It cannot be broken into words");
        System.out.print(Arrays.toString(validWords));


    }

    @Strategy
    public void practiceRun() {

        int length = word.length();
        boolean validWords[] = new boolean[length];

        for (int i = 0; i < length; i++) {

            if (dictionary.contains(word.substring(0, i + 1))) {
                validWords[i] = true;
            }

            if (validWords[i]) {
                for (int j = i + 1; j < length; j++) {
                    if (dictionary.contains(word.substring(i + 1, j + 1))) {
                        validWords[j] = true;
                    }
                }
            }

            if (validWords[length - 1]) {
                System.out.print("It can be broken into words");
                return;
            }
        }

        System.out.print("It cannot be broken into words");
        System.out.print(Arrays.toString(validWords));
    }


}
