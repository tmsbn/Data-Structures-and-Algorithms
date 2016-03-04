package algorithms.arrays;

import algorithms.annotation.Strategy;
import algorithms.annotation.SwitchMenu;
import base.DSABase;
import base.ArrayQuestions;

import java.util.Arrays;

/**
 * Created by tmsbn on 2/25/16.
 */
public class FrequencyOfArrayElements extends ArrayQuestions implements DSABase {

    int numbers[] = {4, 5, 1, 3, 5, 0, 3};

    @Override
    public void execute() {


        System.out.println("The original array is " + Arrays.toString(numbers));

        new SwitchMenu(this).show();

    }

    // Algorithm 1: O(n^2) time and O(1) space
    @Strategy
    public void naiveAlgorithm() {

        int length = numbers.length;

        for (int i = 0; i < length; i++) {

            int count = 0;
            for (int number : numbers) {
                if (number == i)
                    count++;
            }

            System.out.println(i + ". " + count);
        }
    }

    // Algorithm 2: O(n) time and O(n) space, BUT the array elements HAS be less than size of the array
    @Strategy
    public void frequencyAlgorithm() {

        int length = numbers.length;
        int[] countArray = new int[length];

        for (int number : numbers) {
            //To prevent index out of bound exception
            if (number < length)
                countArray[number]++;
        }

        for (int i = 0; i < length; i++) {
            System.out.println(i + ". " + countArray[i]);
        }
    }

    // Algorithm 3: O(n) time and O(1) space, BUT the array elements HAS be less than size of the array
    @Strategy
    public void frequencyAlgorithmWithSameArray() {

        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            numbers[numbers[i] % length] += length;
        }

        for (int i = 0; i < length; i++) {
            System.out.println(i + ". " + numbers[i] / length);
        }
    }


}
