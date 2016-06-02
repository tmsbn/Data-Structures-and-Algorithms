package questions.arrays;

import annotation.Strategy;
import annotation.SwitchMenu;
import base.ArrayQuestions;
import base.DSABase;

import java.util.Arrays;

/**
 * Created by tmsbn on 3/22/16.
 */
public class IncreasingSequence extends ArrayQuestions implements DSABase {

    int numbers[] = {1, 32, 5, 8, 11, 12};

    @Override
    public void execute() {

        System.out.println("Original Array is " + Arrays.toString(numbers));

        new SwitchMenu(this).show();

    }

    @Strategy
    public void naiveStrategy() {

        int minPosition = 0;
        int min;

        boolean needComma = false;

        System.out.println("The sub sequence is:");

        while (minPosition < numbers.length) {

            min = numbers[minPosition];
            for (int i = minPosition + 1; i < numbers.length; i++) {
                if (min > numbers[i]) {
                    min = numbers[i];
                    minPosition = i;
                }
            }

            if (needComma)
                System.out.print(",");

            System.out.print(min);
            needComma = true;
            minPosition++;

        }
    }

    @Strategy
    public void alternateStrategy() {

        int subSequence[] = new int[numbers.length];
        int subCount = 0;

        subSequence[0] = numbers[0];

        System.out.println("The sub sequence is:");
        for (int i = 1; i < numbers.length; i++) {
            if (subSequence[subCount] < numbers[i]) {
                subCount++;
                subSequence[subCount] = numbers[i];
            } else {
                for (int j = 0; j <= subCount; j++) {
                    if (subSequence[j] >= numbers[i]) {
                        subSequence[j] = numbers[i];
                        break;
                    }
                }
            }
        }

        boolean needComma = false;
        for (int i = 0; i <= subCount; i++) {

            if (needComma)
                System.out.print(",");

            System.out.print(subSequence[i]);
            needComma = true;
        }

    }


}
