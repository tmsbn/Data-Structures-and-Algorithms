package questions.strings;

import annotation.Strategy;
import annotation.SwitchMenu;
import base.DSABase;
import base.StringQuestions;
import utils.InputUtils;

/**
 * Created by tmsbn on 6/18/16.
 */
public class WordPlay extends StringQuestions implements DSABase {

    String sentence = "";

    @Override
    public void execute() {

        sentence = InputUtils.getStringFromUser("Enter a sentence");
        new SwitchMenu(this).show();
    }

    @Strategy
    public void incrementLetters() {

        char[] charArray = sentence.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != ' ') {
                charArray[i] = (char) (charArray[i] + 1);
            }
        }

        System.out.print(charArray);

    }

    @Strategy
    public void keyboardNext() {

        char[] charArray = sentence.toCharArray();
        String keyboardLayout = "qwertyuiopasdfghjklzxcvbnm";
        int keyboardLength = keyboardLayout.length();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ')
                continue;

            for (int j = 0; j < keyboardLength; j++) {
                if (charArray[i] == keyboardLayout.charAt(j)) {
                    charArray[i] = keyboardLayout.charAt((j + 1) % keyboardLength);
                    break;
                }
            }
        }

        System.out.print(charArray);

    }
}
