package questions.numbers;

import base.DSABase;
import base.NumberQuestions;
import utils.InputUtils;

/**
 * Created by tmsbn on 6/22/16.
 */
public class ReverseNumber extends NumberQuestions implements DSABase {

    @Override
    public void execute() {

        int original = InputUtils.getIntFromUser("Get integer from user:");
        int reverse = 0;
        int digit;

        while (original != 0) {

            digit = original % 10;
            reverse = reverse * 10 + digit;
            original = original / 10;
        }

        System.out.println("The reverse is " + reverse);

    }


}
