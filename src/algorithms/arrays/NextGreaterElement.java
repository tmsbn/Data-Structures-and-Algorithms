package algorithms.arrays;

import algorithms.annotation.Strategy;
import algorithms.annotation.SwitchMenu;
import base.DSABase;
import base.ArrayQuestions;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by tmsbn on 3/1/16.
 */
public class NextGreaterElement extends ArrayQuestions implements DSABase {

    int[] inputArray = {24, 23, 54, 12, 20, 7, 27};


    @Override
    public void execute() {

        System.out.println("The original array is " + Arrays.toString(inputArray));

        new SwitchMenu(this).show();

    }

    @Strategy
    public void stackMethod() {

        System.out.println("Next greater element is:");

        Stack<Integer> integerStack = new Stack<>();
        for (int number : inputArray) {

            if (integerStack.isEmpty() || integerStack.peek() > number) {
                integerStack.push(number);
            } else {
                while (!integerStack.isEmpty() && integerStack.peek() <= number)
                    System.out.println("Max Element is " + integerStack.pop() + " for " + number);
                integerStack.push(number);
            }
        }

    }

    @Strategy
    public void naiveAlgorithm() {

        System.out.println("Next greater element is:");
        int length = inputArray.length;

        boolean comma = false;
        for (int i = 0; i < length; i++) {

            int maxElement = -1;
            for (int j = i; j < length; j++) {

                if (inputArray[j] > inputArray[i]) {
                    maxElement = inputArray[j];
                    break;
                }
            }

            if (comma) System.out.print(",");
            System.out.print(maxElement != -1 ? maxElement : "null");
            comma = true;
        }
    }


}
