package questions.arrays;

import base.DSABase;
import base.ArrayQuestions;

import java.util.Scanner;

/**
 * Created by tmsbn on 2/25/16.
 */
public class PermutationsInString extends ArrayQuestions implements DSABase {

    @Override
    public void execute() {

        System.out.print("Enter a string to find all permutations:");
        String string = new Scanner(System.in).next();

        //we use stringBuilder, because in Java, Strings are immutable
        permute(new StringBuilder(string), 0, string.length() - 1);
    }


    private void permute(StringBuilder stringBuilder, int start, int end) {

        if (start == end) {
            System.out.println(stringBuilder.toString());
        } else {

            for (int i = start; i <= end; i++) {

                swap(i, start, stringBuilder);
                permute(stringBuilder, start + 1, end);
                //we swap again to use backtracking technique
                swap(i, start, stringBuilder);
            }
        }
    }

    private void swap(int i, int j, StringBuilder stringBuilder) {

        char temp=stringBuilder.charAt(i);
        stringBuilder.setCharAt(i,temp);
        stringBuilder.setCharAt(j, stringBuilder.charAt(i));
    }
}
