package questions.strings;

import annotation.Strategy;
import annotation.SwitchMenu;
import base.DSABase;
import base.StringQuestions;
import utils.InputUtils;

import java.util.Arrays;

/**
 * Created by tmsbn on 7/4/16.
 */
public class PatternMatching extends StringQuestions implements DSABase {

    private String text, pattern;

    @Override
    public void execute() {

        text = InputUtils.getStringFromUser("Enter text");
        pattern = InputUtils.getStringFromUser("Enter pattern");

        new SwitchMenu(this).show();
    }

    @Strategy
    public void naiveMethod() {

        int t = text.length();
        int p = pattern.length();

        for (int i = 0; i <= t - p; i++) {
            for (int j = 0; j < p; j++) {

                if (text.charAt(j + i) != pattern.charAt(j)) {
                    break;
                }

                if (j == p - 1) {
                    System.out.println("First match found at index " + i);
                    return;
                }
            }

        }
        System.out.println("No match found");


    }


    @Strategy
    public void KMP() {

        int length = pattern.length();
        int textLength = text.length();
        int[] table = new int[length];
        table[0] = 0;

        int i = 1;
        int j = 0;

        while (i < length) {

            if (pattern.charAt(i) == pattern.charAt(j)) {

                table[i] = j + 1;
                i++;
                j++;

            } else {

                if (j == 0) {

                    table[i] = 0;
                    i++;

                } else {

                    j = table[j - 1];
                }

            }
        }

        System.out.println("Partial Match table:" + Arrays.toString(table));

        i = 0;
        j = 0;

        while (i < textLength) {

            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
                i++;

            } else {

                if (j == 0) {
                    i++;
                } else
                    j = table[j - 1];
            }

            if (j == length) {
                System.out.println("Match found at index " + (i - j));
                return;
            }
        }

        System.out.println("No match found");


    }

}
