package questions.arrays;

import annotation.Strategy;
import annotation.SwitchMenu;
import utils.InputUtils;
import base.ArrayQuestions;
import base.DSABase;

/**
 * Created by tmsbn on 3/8/16.
 */
public class NonRepeatingLongestSubstring extends ArrayQuestions implements DSABase {

    String givenString = "abcefc";

    @Override
    public void execute() {

        givenString = InputUtils.getStringFromUser("Enter a string to find the longest non repeating substring");
        new SwitchMenu(this).show();
    }

    @Strategy
    public void naiveAlgorithm() {

        int length = givenString.length();
        int start = 0, maxLength = 0, maxStart = 0;

        for (int i = 1; i < length; i++) {
            for (int j = start; j < i; j++) {

                if (givenString.charAt(i) == givenString.charAt(j) || j == length - 2) {

                    if ((i - start) > maxLength) {
                        maxLength = i - start + ((j == length - 2) ? 1 : 0);
                        maxStart = start;
                    }
                    start = j + 1;
                    break;
                }
            }
        }

        System.out.println(givenString.substring(maxStart, maxStart + maxLength));

    }
}
