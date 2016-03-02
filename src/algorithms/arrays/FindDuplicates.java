package algorithms.arrays;

import base.AlgorithmsBase;
import base.ArrayQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by tmsbn on 2/27/16.
 */
public class FindDuplicates extends ArrayQuestions implements AlgorithmsBase {

    @Override
    public void execute() {

        int[] inputArray = {1, 4, 2, 5, 6, 3, 3, 5};
        System.out.println("Original Array is " + Arrays.toString(inputArray));

        System.out.println("Find duplicates using-");
        System.out.println("1. Using Count Array");
        System.out.println("2. Using negation ");
        System.out.print("\nChoose Method of Algorithm:");

        int input = new Scanner(System.in).nextInt();


        switch (input) {
            case 2:
                negationStrategy(inputArray);
                break;
            case 1:
                countArrayStrategy(inputArray);
                break;
            default:
                break;
        }

    }

    private void countArrayStrategy(int[] inputArray) {

        int length = inputArray.length;
        int[] countArray = new int[length];
        for (int i : inputArray) {
            countArray[i]++;
        }

        System.out.println("The duplicates are");
        boolean comma = false;
        for (int i = 0; i < length; i++) {


            if (countArray[i] > 1) {
                if (comma) {
                    System.out.print(",");
                }
                System.out.print(i);
                comma = true;
            }

        }
    }

    private void negationStrategy(int[] inputArray) {

        int length = inputArray.length;

        Set<Integer> duplicates = new HashSet<>();

        for (int i = 0; i < length; i++) {

            int index = Math.abs(inputArray[i]);
            if (inputArray[index] < 0) {
                duplicates.add(index);
            } else {
                inputArray[index] *= -1;
            }
        }

        System.out.println("The duplicates are");
        boolean comma = false;
        for (int i : duplicates) {

            if (comma) {
                System.out.print(",");
            }
            System.out.print(i);
            comma = true;
        }

    }
}
