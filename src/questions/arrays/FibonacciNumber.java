package questions.arrays;

import annotation.Strategy;
import annotation.SwitchMenu;
import utils.InputUtils;
import base.DSABase;
import base.ArrayQuestions;

/**
 * Created by tmsbn on 3/2/16.
 */
public class FibonacciNumber extends ArrayQuestions implements DSABase {


    int input;

    @Override
    public void execute() {

        input = InputUtils.getIntFromUser("Find fibonacci number at index:");

        new SwitchMenu(this).show();

    }

    @Strategy
    public void dynamicStrategy() {

        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i < input; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        System.out.println("\nThe fibonacci number at index " + input + " is " + c);
    }

    @Strategy
    public void recursiveStrategy() {
        System.out.print("\nThe fibonacci number at index " + input + " is "+findFibonacciAtIndex(input));
    }

    private int findFibonacciAtIndex(int index) {

        if (index == 0 || index == 1)
            return index;
        else {
            return findFibonacciAtIndex(index - 1) + findFibonacciAtIndex(index - 2);
        }

    }


}
