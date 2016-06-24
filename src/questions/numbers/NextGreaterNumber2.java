package questions.numbers;

import base.DSABase;
import base.NumberQuestions;
import utils.InputUtils;

import java.util.Arrays;

/**
 * Created by tmsbn on 6/22/16.
 */
public class NextGreaterNumber2 extends NumberQuestions implements DSABase {

    @Override
    public void execute() {

        int number = InputUtils.getIntFromUser("Enter a number");
        String numberAsString = Integer.toString(number);
        int[] numberAsArray = new int[numberAsString.length()];

        int length = numberAsString.length();

        for (int i = 0; i < numberAsString.length(); i++) {
            numberAsArray[i] = Character.getNumericValue(numberAsString.charAt(i));
        }

        //System.out.println(Arrays.toString(numberAsArray));

        int index = 0;

        for (int i = length - 1; i > 0; i--) {
            if (numberAsArray[i - 1] < numberAsArray[i]) {
                index = i - 1;
                break;
            }
        }

        for (int i = length - 1; i > index; i--) {

            if (numberAsArray[i] > numberAsArray[index]) {
                swap(i, index, numberAsArray);
                break;
            }
        }

        int nextGreaterNumber = 0;

        for (int i = 0; i < length; i++) {
            nextGreaterNumber += Math.pow(10, i) * numberAsArray[length - 1 - i];
        }

        System.out.println("the next greater number is " + nextGreaterNumber);

    }

    private void swap(int i, int j, int[] numbers) {

        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }


}
