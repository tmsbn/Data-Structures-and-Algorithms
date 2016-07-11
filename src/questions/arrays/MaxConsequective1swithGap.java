package questions.arrays;

import base.ArrayQuestions;
import base.DSABase;

/**
 * Created by tmsbn on 6/28/16.
 */
public class MaxConsequective1swithGap extends ArrayQuestions implements DSABase {

    @Override
    public void execute() {

        int array[] = {0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0};
        int length = array.length;

        //to store the count of all the 1's before and after every 0
        int countArray[] = new int[length];

        int count = 0;
        for (int i = 0; i < length; i++) {

            if (array[i] == 0) {

                countArray[i] = count;
                count = 0;


            } else if (array[i] == 1) {
                count++;

            }
        }

        count = 0;

        for (int i = length - 1; i >= 0; i--) {

            if (array[i] == 0) {

                countArray[i] += count;
                count = 0;


            } else if (array[i] == 1) {
                count++;

            }


        }
        int maxCount = 0, maxIndex = 0;
        for (int i = 0; i < length; i++) {

            if (maxCount < countArray[i]) {
                maxCount = countArray[i];
                maxIndex = i;
            }

        }

        System.out.println("Index of 0 to replace to get longest continuous sequence of 1 is " + maxIndex);

    }


}
