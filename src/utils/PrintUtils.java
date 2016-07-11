package utils;

/**
 * Created by tmsbn on 6/22/16.
 */
public class PrintUtils {

    public static void printMatrix(int[][] matrix, int lengh, int height){


        for (int i = 0; i < height; i++) {
            for (int j = 0; j < lengh; j++) {
                if (j != 0)
                    System.out.print(" ");
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }


}
