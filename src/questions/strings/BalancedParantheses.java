package questions.strings;

import annotation.Strategy;
import annotation.SwitchMenu;
import base.DSABase;
import base.StringQuestions;
import utils.InputUtils;

/**
 * Created by tmsbn on 6/5/16.
 */
public class BalancedParantheses extends StringQuestions implements DSABase {

    String expression;

    @Override
    public void execute() {

        expression = InputUtils.getStringFromUser("Enter a string");
        new SwitchMenu(this).show();
    }

    @Strategy
    public void naiveAlgorithm() {

        int count = 0;
        int length = expression.length();
        for (int i = 0; i < length; i++) {

            if (expression.charAt(i) == '(') {
                count++;
            } else if (expression.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                break;
            }
        }

        System.out.println("This string is " + (count == 0 ? "valid" : "invalid"));

    }
}
