import algorithms.arrays.*;
import algorithms.sorting.*;
import base.AlgorithmsBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tmsbn on 2/19/16.
 */
public class Launcher {

    public static void main(String args[]) {

        List<Class<? extends AlgorithmsBase>> classes = groupAlgorithmsList(getAlgorithmsList());
        String shouldContinue = "";


        while (shouldContinue != null) {
            System.out.println("ALGORITHMS MENU\n****************");

            int count = 1;

            Class superClass = null;

            for (Class c : classes) {

                if (superClass == null || !(c.getSuperclass().equals(superClass))) {

                    superClass = c.getSuperclass();
                    System.out.println("\n" + superClass.getSimpleName() + "\n----------------------");
                }
                System.out.println((count++) + ". " + splitCamelCase(c.getSimpleName()));
            }


            System.out.print("\nEnter the index of Class:");
            Scanner inputScanner = new Scanner(System.in);
            int input = inputScanner.nextInt();

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

    private static List<Class<? extends AlgorithmsBase>> getAlgorithmsList() {

        List<Class<? extends AlgorithmsBase>> classes = new ArrayList<>();
        classes.add(BubbleSort.class);
        classes.add(PermutationsInString.class);
        classes.add(SelectionSort.class);
        classes.add(MergeSort.class);
        classes.add(FrequencyOfArrayElements.class);
        classes.add(InsertionSort.class);
        classes.add(HeapSort.class);
        classes.add(BinarySearch.class);
        classes.add(LeadersInArray.class);
        classes.add(FindAPeakInArray.class);


        return classes;

    }

    private static List<Class<? extends AlgorithmsBase>> groupAlgorithmsList(List<Class<? extends AlgorithmsBase>> classes) {

        HashMap<String, List<Class<? extends AlgorithmsBase>>> classMap = new HashMap<>();

        for (Class c : classes) {
            String superClassName = c.getSuperclass().getName();

            List<Class<? extends AlgorithmsBase>> classArrayList;
            if ((classArrayList = classMap.get(superClassName)) == null) {
                classArrayList = new ArrayList<>();
            }

            classArrayList.add(c);
            classMap.put(superClassName, classArrayList);
        }

        List<Class<? extends AlgorithmsBase>> sortedClassList = new ArrayList<>();

        for (String key : classMap.keySet()) {
            sortedClassList.addAll(classMap.get(key));
        }

        return sortedClassList;

    }

    static String splitCamelCase(String s) {
        return s.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        );
    }


}
