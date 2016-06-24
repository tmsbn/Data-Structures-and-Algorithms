import base.DSABase;
import questions.arrays.*;
import questions.linked_lists.*;
import questions.numbers.NextGreaterNumber;
import questions.numbers.ReverseNumber;
import questions.sorting.*;
import questions.strings.*;
import questions.tree_questions.IsABinarySearchTree;
import utils.FileUtils;
import utils.StringUtils;

import java.io.IOException;
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

            Class prevSuperClass = null;

            for (Class c : classes) {

                if (prevSuperClass == null || !(c.getSuperclass().equals(prevSuperClass))) {

                    prevSuperClass = c.getSuperclass();
                    System.out.print("\n" + prevSuperClass.getSimpleName() + StringUtils.lineSeparator);
                }
                System.out.println((count++) + ". " + StringUtils.splitCamelCase(c.getSimpleName()));
            }


            System.out.print("\nEnter the index of Class:");
            Scanner inputScanner = new Scanner(System.in);
            int input;
            String userInput;

            while (true) {
                userInput = inputScanner.nextLine();
                if (userInput.isEmpty()) {

                    try {
                        input = FileUtils.read("data.txt");
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (userInput.matches("^\\d+$")) {

                    input = Integer.parseInt(userInput);
                    try {
                        FileUtils.write(input, "data.txt");
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                } else {
                    System.out.println("Please enter a number or press Enter to go to the last question!");
                }
            }


            // int previousInput = FileUtils.read("data.txt");


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
        classes.add(ReverseWords.class);
        classes.add(DNAPatternMatching.class);
        classes.add(BalancedParantheses.class);
        classes.add(BinaryStringsWithConseqOnes.class);
        classes.add(ReverseLinkedList.class);
        classes.add(MergeOrderedLinkedList.class);
        classes.add(IntersectionLinkedList.class);
        classes.add(LoopInAList.class);
        classes.add(TreeToDoubleList.class);
        classes.add(IsABinarySearchTree.class);
        classes.add(WordPlay.class);
        classes.add(LRUCache.class);
        classes.add(MinimumCostPathMatrix.class);
        classes.add(ReverseNumber.class);
        classes.add(NextGreaterNumber.class);

        Collections.sort(classes, new Comparator<Class<? extends DSABase>>() {
            @Override
            public int compare(Class<? extends DSABase> o1, Class<? extends DSABase> o2) {
                return o1.getSuperclass().getSimpleName().compareTo(o2.getSuperclass().getSimpleName());
            }
        });


        return classes;

    }


}
