package questions.arrays;

import annotation.Strategy;
import annotation.SwitchMenu;
import utils.InputUtils;
import base.ArrayQuestions;
import base.DSABase;

import java.util.Arrays;

/**
 * Created by tmsbn on 3/6/16.
 */
public class CoinChange extends ArrayQuestions implements DSABase {

    int changeCoins[] = {1, 5, 10, 25};
    int sum = 55;

    @Override
    public void execute() {

        System.out.println("Types of coin available  are " + Arrays.toString(changeCoins));
        sum = InputUtils.getIntFromUser("Enter a sum to find the minimum coins required for change");
        new SwitchMenu(this).show();
    }

    @Strategy
    public void dynamicProgramming() {

        int[] noCoins = new int[sum + 1];
        int[] changeArray = new int[sum + 1];
        noCoins[0] = 0;

        for (int i = 1; i <= sum; i++) {

            int minValue = Integer.MAX_VALUE;
            for (int changeCoin : changeCoins) {

                if (changeCoin <= i) {
                    int answer = noCoins[i - changeCoin] + 1;
                    if (answer < minValue) {
                        minValue = answer;
                        noCoins[i] = minValue;
                        changeArray[i] = changeCoin;
                    }
                } else
                    break;

            }

        }
        System.out.print("The minimum number of coin required for change is " + noCoins[sum]);
    }

    @Strategy
    public void recursionStrategy() {

    }
}
