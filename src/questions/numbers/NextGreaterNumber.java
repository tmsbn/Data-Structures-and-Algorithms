package questions.numbers;

import base.DSABase;
import base.NumberQuestions;
import utils.InputUtils;

import java.util.Arrays;

/**
 * Created by tmsbn on 6/22/16.
 */
public class NextGreaterNumber extends NumberQuestions implements DSABase {

    @Override
    public void execute() {

        int original = InputUtils.getIntFromUser("Enter a number");
        String string = Integer.toString(original);
        int[] numbers = new int[string.length()];

        for(int i=0;i<numbers.length;i++){

            numbers[i] = Character.getNumericValue(string.charAt(i));
        }

        System.out.print(Arrays.toString(numbers));

    }
}
