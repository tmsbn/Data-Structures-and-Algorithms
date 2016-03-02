package algorithms.arrays;

import base.AlgorithmsBase;
import base.ArrayQuestions;

import java.util.Scanner;

/**
 * Created by tmsbn on 3/2/16.
 */
public class FibonacciNumber extends ArrayQuestions implements AlgorithmsBase {

    @Override
    public void execute() {

        System.out.print("Find fibonacci number at index:");
        int input = new Scanner(System.in).nextInt();

        System.out.println("Choose Method:");
        System.out.println("1. Using recursion");
        System.out.println("2. Using dynamic programming");
        System.out.print("Choose Method of Algorithm:");
        int choose = new Scanner(System.in).nextInt();
        System.out.print("\nThe fibonacci number at index " + input + " is ");
        switch (choose) {
            case 1:
                System.out.print(recursiveStrategy(input));
                break;
            case 2:
                System.out.print(dynamicProgramming(input));
                break;
            default:
                break;
        }

    }

    private int dynamicProgramming(int index) {

        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= index; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;


    }

    private int recursiveStrategy(int index) {
        if (index == 0 || index == 1)
            return index;
        else {
            return recursiveStrategy(index - 1) + recursiveStrategy(index - 2);
        }
    }


}
