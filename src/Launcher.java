import algorithms.arrays.FrequencyOfArrayElements;
import algorithms.sorting.*;
import base.AlgorithmsBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tmsbn on 2/19/16.
 */
public class Launcher {

    public static void main(String args[]) {

        List<Class<? extends AlgorithmsBase>> classes = getAlgorithmsList();
        String shouldContinue = "";


        while (shouldContinue != null) {
            System.out.println("ALGORITHMS MENU\n****************");

            int count = 1;
            int breakClass = 0;

            Class superClass = null;

            for (Class c : classes) {

                if (superClass == null || !(c.getSuperclass().equals(superClass))) {

                    superClass = c.getSuperclass();
                    System.out.println("\n"+superClass.getSimpleName()+"\n----------------------");
                }
                System.out.println((count++) + ". " + c.getSimpleName());
            }


            System.out.print("\nEnter the index of Class:");
            Scanner inputScanner = new Scanner(System.in);
            int input = inputScanner.nextInt() + breakClass;

            if (input > 0 && input <= classes.size()) {
                try {

                    input--;
                    System.out.println("\nExecuting " + classes.get(input).getSimpleName() + "....\n");
                    AlgorithmsBase algorithmsBase = classes.get(input).newInstance();
                    algorithmsBase.execute();

                    System.out.println("\nPress enter to continue. Any other key to exit");
                    Scanner exitScanner = new Scanner(System.in);
                    shouldContinue = exitScanner.nextLine();
                    if (!shouldContinue.equals(""))
                        shouldContinue = null;

                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }


            } else {
                System.out.print("Invalid Selection, Please try again\n");
            }

        }
    }

    public static List<Class<? extends AlgorithmsBase>> getAlgorithmsList() {

        List<Class<? extends AlgorithmsBase>> classes = new ArrayList<>();
        classes.add(BubbleSort.class);
        classes.add(SelectionSort.class);
        classes.add(MergeSort.class);
        classes.add(InsertionSort.class);
        classes.add(HeapSort.class);
        classes.add(FrequencyOfArrayElements.class);

        return classes;

    }


}
