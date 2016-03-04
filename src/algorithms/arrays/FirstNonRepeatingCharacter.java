package algorithms.arrays;

import algorithms.annotation.Strategy;
import algorithms.annotation.SwitchMenu;
import algorithms.utils.StringUtils;
import base.ArrayQuestions;
import base.DSABase;

/**
 * Created by tmsbn on 3/4/16.
 */
public class FirstNonRepeatingCharacter extends ArrayQuestions implements DSABase {

    String input;

    @Override
    public void execute() {

        input = StringUtils.getStringFromUser("Please enter the input string");

        new SwitchMenu(this).show();

    }

    //Time complexity O(n*n), space complexity O(n)
    @Strategy
    public void naiveStrategy() {

        int length = input.length();

        for (int i = 0; i < length; i++) {
            boolean isRepeating = false;

            for (int j = 0; j < length; j++) {
                if (i != j && input.charAt(i) == input.charAt(j)) {
                    isRepeating = true;
                    break;
                }
            }
            if (!isRepeating) {
                System.out.println("First non repeating character is " + input.charAt(i));
                return;
            }

        }
        System.out.println("There are no non repeating characters in the string");
    }
}
