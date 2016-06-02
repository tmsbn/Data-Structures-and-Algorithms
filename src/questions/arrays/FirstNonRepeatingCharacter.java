package questions.arrays;

import annotation.Strategy;
import annotation.SwitchMenu;
import utils.InputUtils;
import base.ArrayQuestions;
import base.DSABase;

/**
 * Created by tmsbn on 3/4/16.
 */
public class FirstNonRepeatingCharacter extends ArrayQuestions implements DSABase {

    String input;

    @Override
    public void execute() {

        input = InputUtils.getStringFromUser("Please enter a sample string");

        new SwitchMenu(this).show();

    }

    //Time complexity O(n*n), space complexity O(1)
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

    //Time complexity O(n), space complexity O(256)
    @Strategy
    public void countStrategy() {

        int length = input.length();
        int[] countArray = new int[256];


        for (int i = 0; i < length; i++) {
            countArray[input.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (countArray[i] == 1) {
                System.out.println("First non repeating character is " + (char) i);
                return;
            }
        }

        System.out.println("There are no non repeating characters in the string");
    }
}
