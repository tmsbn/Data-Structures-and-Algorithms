package algorithms.arrays;

import base.DSABase;
import base.ArrayQuestions;

import java.util.Arrays;

/**
 * Created by tmsbn on 2/27/16.
 */
public class LeadersInArray extends ArrayQuestions implements DSABase {

    @Override
    public void execute() {

        int[] inputArray = {1, 4, 20, 5, 6};

        System.out.println("Original Array is " + Arrays.toString(inputArray));

        int leader = -1;
        int last = inputArray.length - 1;

        System.out.println("The leaders are:");
        for (int i = last; i >= 0; i--) {

            if (inputArray[i] > leader) {
                leader = inputArray[i];
                System.out.println(leader);
            }
        }
    }
}
