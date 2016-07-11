package questions.arrays;

import annotation.Strategy;
import annotation.SwitchMenu;
import base.ArrayQuestions;
import base.DSABase;
import utils.InputUtils;

/**
 * Created by tmsbn on 7/7/16.
 */
public class KnapsackProblem extends ArrayQuestions implements DSABase {

    private int weights[] = {10, 20, 30};
    private int values[] = {60, 50, 30};

    private int maxWeight;

    @Override
    public void execute() {

        maxWeight = InputUtils.getIntFromUser("Enter maximum weight");

        new SwitchMenu(this).show();
    }

    @Strategy
    public void recursiveStrategy() {

        System.out.println("The ideal value is " + calculateMaxWeight(weights.length - 1, maxWeight));
    }

    @Strategy
    public void dynamicProgramming() {

        int[][] opt = new int[weights.length + 1][maxWeight + 1];
        int[] dWeights = add0AtStart(weights);
        int[] dValues = add0AtStart(values);

        for (int i = 1; i < weights.length + 1; i++) {
            for (int j = 1; j < maxWeight + 1; j++) {

                if (dWeights[i] > j) {
                    opt[i][j] = opt[i - 1][j];
                } else {
                    opt[i][j] = Math.max(dValues[i] + opt[i - 1][j - dWeights[i]], opt[i - 1][j]);
                }
            }
        }

        System.out.println("The ideal value is " + opt[weights.length][maxWeight]);

    }


    private int calculateMaxWeight(int n, int maxWeight) {

        if (maxWeight <= 0 || n < 0)
            return 0;
        else if (weights[n] > maxWeight)
            return calculateMaxWeight(n - 1, maxWeight);
        else {
            return Math.max(values[n] + calculateMaxWeight(n - 1, maxWeight - weights[n]),
                    calculateMaxWeight(n - 1, maxWeight)
            );
        }
    }

    private static int[] add0AtStart(int[] given) {
        int[] result = new int[given.length + 1];
        System.arraycopy(given, 0, result, 1, result.length - 1);
        return result;
    }
}