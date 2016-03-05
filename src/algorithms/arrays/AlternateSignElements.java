package algorithms.arrays;

import base.ArrayQuestions;
import base.DSABase;

import java.util.Arrays;

/**
 * Created by tmsbn on 3/5/16.
 */
public class AlternateSignElements extends ArrayQuestions implements DSABase {

    int[] inputArray = {1, 4, -20, 5, -6, -11};

    @Override
    public void execute() {

        System.out.println("Original Array is " + Arrays.toString(inputArray));

        int length = inputArray.length;

        //The basic strategy is
        //1. iterate through the array
        //2. Check if an element has the wrong sign
        //3. Find the next occurrence of the element with the right sign
        //4. Do a right rotation, which will bring the found element to start, while preserving the array order
        for (int i = 0; i < length; i++) {

            if ((i % 2 == 0 && inputArray[i] < 0) || (i % 2 == 1 && inputArray[i] > 0)) {
                int nextOpposite = getNextOpposite(i);
                if (nextOpposite != -1) {
                    rightRotate(i, nextOpposite);
                }else{
                    break;
                }
            }
        }
        System.out.println("Rearranged Array is " + Arrays.toString(inputArray));

    }

    private int getNextOpposite(int index) {

        for (int j = index + 1; j < inputArray.length; j++) {
            if (inputArray[index] * inputArray[j] < 0)
                return j;
        }
        return -1;
    }

    private void rightRotate(int start, int end) {

        int temp = inputArray[end];
        for (int i = end; i > start; i--) {
            inputArray[end] = inputArray[end - 1];
        }
        inputArray[start] = temp;
    }


}
