package questions.strings;

import annotation.Strategy;
import annotation.SwitchMenu;
import base.DSABase;
import base.StringQuestions;
import utils.InputUtils;

/**
 * Created by tmsbn on 7/4/16.
 */
public class ShortestPalindrome extends StringQuestions implements DSABase {

    String input;

    @Override
    public void execute() {

        input = InputUtils.getStringFromUser("Enter a word");
        new SwitchMenu(this).show();

    }

    @Strategy
    public void naiveMethod() {

        int length = input.length();

        if (isPalindrome(input)) {
            System.out.println("This is already a palindrome");
        }

        for (int i = length - 1; i >= 0; i--) {
            String substring = reverseString(input.substring(i));
            String palindrome = substring.concat(input);

            if (isPalindrome(palindrome)) {
                System.out.print("This shortest palindrome is " + palindrome);
                return;
            }

        }

        System.out.print("Fix the code dude!");

    }

    private String reverseString(String input) {


        int length = input.length();
        char[] inputAsChar = input.toCharArray();
        for (int i = 0, j = length - 1; i < length / 2; i++, j--) {

            char temp = input.charAt(i);
            inputAsChar[i] = inputAsChar[j];
            inputAsChar[j] = temp;
        }

        return String.valueOf(inputAsChar);
    }

    private boolean isPalindrome(String input) {

        int length = input.length();

        for (int i = 0; i < length / 2; i++) {

            if (input.charAt(i) != input.charAt(length - 1 - i)) {
                return false;
            }

        }
        return true;

    }


}
