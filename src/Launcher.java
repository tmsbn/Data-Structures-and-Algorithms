import questions.arrays.*;
import questions.sorting.*;
import questions.strings.WordBreak;
import utils.StringUtils;
import base.DSABase;

import java.util.*;

/**
 * Created by tmsbn on 2/19/16.
 */
public class Launcher {

    public static void main(String args[]) {

        List<Class<? extends DSABase>> classes = getQuestionsList();
        String shouldContinue = "";


        while (shouldContinue != null) {
            System.out.print("ALGORITHMS MENU" + StringUtils.lineSeparator);

            int count = 1;

            Class superClass = null;

            for (Class c : classes) {

                if (superClass == null || !(c.getSuperclass().equals(superClass))) {

                    superClass = c.getSuperclass();
                    System.out.print("\n" + superClass.getSimpleName() + StringUtils.lineSeparator);
                }
                System.out.println((count++) + ". " + StringUtils.splitCamelCase(c.getSimpleName()));
            }


            System.out.print("\nEnter the index of Class:");
            Scanner inputScanner = new Scanner(System.in);
            int input = inputScanner.nextInt();

            if (input > 0 && input <= classes.size()) {
                try {

                    input--;
                    System.out.print("\nExecuting " + classes.get(input).getSimpleName() + StringUtils.lineSeparator);
                    DSABase DSABase = classes.get(input).newInstance();
                    DSABase.execute();

                    System.out.println(StringUtils.lineSeparator + "Press enter to continue. Any other key to exit");
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

    private static List<Class<? extends DSABase>> getQuestionsList() {

        ArrayList<Class<? extends DSABase>> classes = new ArrayList<>();
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
        classes.add(FindDuplicates.class);
        classes.add(MajorityElement.class);
        classes.add(QuickSort.class);
        classes.add(MaximumAvgSubArray.class);
        classes.add(NextGreaterElement.class);
        classes.add(FibonacciNumber.class);
        classes.add(ArrayRotation.class);
        classes.add(FirstNonRepeatingCharacter.class);
        classes.add(AlternateSignElements.class);
        classes.add(CoinChange.class);
        classes.add(NonRepeatingLongestSubstring.class);
        classes.add(IncreasingSequence.class);
        classes.add(WordBreak.class);

        Collections.sort(classes, new Comparator<Class<? extends DSABase>>() {
            @Override
            public int compare(Class<? extends DSABase> o1, Class<? extends DSABase> o2) {
                return o1.getSuperclass().getSimpleName().compareTo(o2.getSuperclass().getSimpleName());
            }
        });


        return classes;

    }


}
