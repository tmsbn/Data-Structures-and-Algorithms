package questions.arrays;

import annotation.Strategy;
import annotation.SwitchMenu;
import utils.InputUtils;
import base.ArrayQuestions;
import base.DSABase;

import java.util.Arrays;

/**
 * Created by tmsbn on 3/3/16.
 */

public class ArrayRotation extends ArrayQuestions implements DSABase {

    int[] inputArray = {1, 4, 20, 5, 6, 11};
    int shiftBy;


    @Override
    public void execute() {

        System.out.println("Original Array is " + Arrays.toString(inputArray));
        shiftBy = InputUtils.getIntFromUser("Enter the number of rotations to perform");

        new SwitchMenu(this).show();

    }

    //Space Complexity:O(1) & Time complexity:O(n*shiftBy)
    @Strategy
    public void naiveStrategy() {

        int length = inputArray.length;
        for (int i = 0; i < shiftBy; i++) {
            int temp = inputArray[0];
            for (int j = 1; j < length; j++) {
                inputArray[j - 1] = inputArray[j];
            }
            inputArray[length - 1] = temp;
        }
        System.out.println("Rotated Array is " + Arrays.toString(inputArray));
    }

    //Space Complexity:O(n) & Time complexity:O(n)
    @Strategy
    public void duplicateArray() {

        int length = inputArray.length;
        int[] rotatedArray = new int[length];
        for (int i = 0; i < length; i++) {
            rotatedArray[i] = inputArray[(shiftBy + i) % length];
        }
        System.out.println("Rotated Array is " + Arrays.toString(rotatedArray));
    }

    //Space Complexity:O(1) & Time complexity:O(n)
    @Strategy
    public void arrayReversal() {

        reverse(inputArray, 0, shiftBy - 1);
        reverse(inputArray, shiftBy, inputArray.length - 1);

        //time complexity is calculated without counting the reverse step// I think
        reverse(inputArray, 0, inputArray.length - 1);

        System.out.println("Rotated Array is " + Arrays.toString(inputArray));

    }

    private void reverse(int array[], int start, int end) {

        int temp;
        for (int i = start, j = end; i < j; i++, j--) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

}
