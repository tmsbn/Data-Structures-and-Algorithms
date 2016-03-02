package algorithms.arrays;

import base.AlgorithmsBase;
import base.ArrayQuestions;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by tmsbn on 3/1/16.
 */
public class NextGreaterElement extends ArrayQuestions implements AlgorithmsBase {

    @Override
    public void execute() {

        int[] inputArray = {24, 23, 54, 12, 20, 7, 27};

        System.out.println("The original array is " + Arrays.toString(inputArray));

        System.out.println("\n1 .Naive Algorithm");
        System.out.println("2. Stack Method");
        System.out.print("\nChoose Method of Algorithm:");

        int input = new Scanner(System.in).nextInt();
        switch (input) {
            case 1:
                naiveAlgorithm(inputArray);
                break;
            case 2:
                stackMethod(inputArray);
                break;
            default:
                break;


        }

    }

    private void stackMethod(int[] numbers) {

        System.out.println("Next greater element is:");

        Stack<Integer> integerStack = new Stack<>();
        for (int number : numbers) {

            if (integerStack.isEmpty() || integerStack.peek() > number) {
                integerStack.push(number);
            } else {
                while (!integerStack.isEmpty() && integerStack.peek() <= number)
                    System.out.println("Max Element is " + integerStack.pop() + " for " + number);
                integerStack.push(number);
            }
        }

    }

    private void naiveAlgorithm(int[] inputArray) {

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
