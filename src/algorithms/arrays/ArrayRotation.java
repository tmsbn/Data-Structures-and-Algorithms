package algorithms.arrays;

import algorithms.annotation.Strategy;
import algorithms.annotation.SwitchMenu;
import algorithms.utils.StringUtils;
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
        shiftBy = StringUtils.getInputFromUser("Enter the number of rotations to perform");

        new SwitchMenu(this).show();

    }

    //Space Complexity:O(1) & Time complexity:O(n*shiftBy)
    @Strategy
    public void naiveAlgorithm() {

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
    public void usingDuplicateArray() {

        int length = inputArray.length;
        int[] rotatedArray = new int[length];
        for (int i = 0; i < length; i++) {
            rotatedArray[i] = inputArray[(shiftBy + i) % length];
        }
        System.out.println("Rotated Array is " + Arrays.toString(rotatedArray));
    }
}
