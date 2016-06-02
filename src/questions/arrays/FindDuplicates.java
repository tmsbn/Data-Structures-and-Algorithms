package questions.arrays;

import annotation.SwitchMenu;
import annotation.Strategy;
import base.DSABase;
import base.ArrayQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tmsbn on 2/27/16.
 */
public class FindDuplicates extends ArrayQuestions implements DSABase {

    int[] inputArray = {1, 4, 2, 5, 6, 3, 3, 5};

    @Override
    public void execute() {

        System.out.println("Original Array is " + Arrays.toString(inputArray));

        new SwitchMenu(this).setTitle("Find duplicates using").show();

    }

    @Strategy
    public void countArrayStrategy() {

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

    @Strategy
    public void negationStrategy() {

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
