package questions.arrays;

import annotation.Strategy;
import annotation.SwitchMenu;
import base.DSABase;
import base.ListQuestions;
import utils.PrintUtils;

/**
 * Created by tmsbn on 6/21/16.
 */
public class MinimumCostPathMatrix extends ListQuestions implements DSABase {

    private int[][] matrix;
    private int[][] dMatrix;

    @Override
    public void execute() {

        matrix = new int[][]{{3, 2, 8}, {1, 9, 7}, {0, 5, 2}, {6, 7, 3}};
        dMatrix = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        PrintUtils.printMatrix(matrix, 3, 4);

        new SwitchMenu(this).show();


    }

    @Strategy
    public void recursiveSolution() {

        System.out.print("The minimum cost to traverse the path is :" + minCostPath(matrix, 3, 2));

    }

    private int minCostPath(int[][] matrix, int i, int j) {

        if (i < 0 || j < 0)
            return Integer.MAX_VALUE;
        else if (i == 0 && j == 0)
            return matrix[0][0];
        else
            return matrix[i][j] + minimum(minCostPath(matrix, i - 1, j - 1), minCostPath(matrix, i - 1, j), minCostPath(matrix, i, j - 1));

    }

    @Strategy
    public void dynamicProgramming() {

        dMatrix[0][0] = matrix[0][0];

        for (int i = 1; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                dMatrix[i][0] = dMatrix[i][0] + matrix[j][0];
            }
        }


        for (int i = 1; i < 3; i++) {
            for (int j = 0; j <= i; j++) {
                dMatrix[0][i] = dMatrix[0][i] + matrix[0][j];
            }
        }



        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 3; j++) {
                dMatrix[i][j] = minimum(matrix[i][j] + dMatrix[i][j - 1], matrix[i][j] + dMatrix[i - 1][j - 1], matrix[i][j] + dMatrix[i - 1][j]);
            }
        }
        PrintUtils.printMatrix(dMatrix, 3, 4);

        System.out.print("The minimum cost to traverse the path is :" + dMatrix[3][2]);



    }

    private int minimum(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
