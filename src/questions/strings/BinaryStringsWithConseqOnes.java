package questions.strings;

import annotation.Strategy;
import annotation.SwitchMenu;
import base.DSABase;
import base.StringQuestions;
import utils.InputUtils;

/**
 * Created by tmsbn on 6/5/16.
 */
public class BinaryStringsWithConseqOnes extends StringQuestions implements DSABase {

    int lengthOfBinary;

    @Override
    public void execute() {

        lengthOfBinary = InputUtils.getIntFromUser("Enter the length of binary string");
        new SwitchMenu(this).show();

    }

    @Strategy
    public void fibonacciSeries() {

        int c0 = 1;
        int c1 = 1;

        for (int i = 1; i < lengthOfBinary; i++) {
            int temp = c0;
            c0 = c0 + c1;
            c1 = temp;
        }

        System.out.print(c0 + c1);
    }

    @Strategy
    public void naiveAlgorithm() {

        int numberOfStrings = (int) Math.pow(2, lengthOfBinary) - 1;
        int ans = 0;

        for (int i = 0; i < numberOfStrings; i++) {

            if (!Integer.toBinaryString(i).matches("[01]*11[01]*")) {
                ans++;
            }
        }
        System.out.print(ans);
    }

}
