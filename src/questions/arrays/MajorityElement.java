package questions.arrays;

import base.DSABase;
import base.ArrayQuestions;

import java.util.Arrays;

/**
 * Created by tmsbn on 2/27/16.
 */
public class MajorityElement extends ArrayQuestions implements DSABase {

    @Override
    public void execute() {
        int[] inputArray = {4, 1, 1, 23, 3, 3, 3, 3, 3};
        System.out.println("Original Array is " + Arrays.toString(inputArray));
        boyerMooreVoteAlgorithm(inputArray);

    }

    //Time complexity is O(n), making it very efficient
    //The algorithm relies on the fact that, a majority element has to occur consecutively in all cases
    // except one case: x,y,x,y,x - Here x is the majority element but occurs in the end
    private void boyerMooreVoteAlgorithm(int[] inputArray) {

        int candidate=0, count = 0;
        for (int i : inputArray) {
            if (count == 0) {
                candidate = i;
                count = 1;
            } else {
                if (candidate == i)
                    count++;
                else
                    count--;
            }
        }
        count = 0;

        //Candidate may or may not satisfy the majority criteria
        // eg: 1,2,3,4,5,6,6,6,6, here the candidate is 6 but not a majority element
        for (int i : inputArray) {
            if (i == candidate)
                count++;
        }
        System.out.println("Majority element " + (count > inputArray.length / 2 ? "is "+candidate : "not found"));

    }
}
