package algorithms;

import base.AlgorithmsBase;

import java.util.Arrays;

/**
 * Created by tmsbn on 2/22/16.
 */
public class HeapSort implements AlgorithmsBase {
    @Override
    public void execute() {

        int numbers[] = {4, 5, 1, 3, 5, 10, 3};
        System.out.println("The original array is " + Arrays.toString(numbers));

        int last = numbers.length - 1;
        int lastInternalNode = (last - 1) / 2;

        for (int i = lastInternalNode; i >= 0; i--) {
            maxHeapify(numbers, i);
        }

        System.out.println("The heapified array is " + Arrays.toString(numbers));

    }

    private void maxHeapify(int[] array, int currentIndex) {


        int largest = currentIndex;
        int left = currentIndex * 2 + 1;
        int right = currentIndex * 2 + 2;

        if (left < array.length && array[left] > array[currentIndex])
            largest = left;
         if (right < array.length && array[right] > array[largest])
            largest = right;

        if (largest != currentIndex) {
            swap(currentIndex, largest, array);
            maxHeapify(array, largest);
        }

    }

    private void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
