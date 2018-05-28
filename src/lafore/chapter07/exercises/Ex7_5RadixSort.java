package lafore.chapter07.exercises;

import lafore.chapter05.LinkQueue.LinkQueue;

import java.util.Arrays;

class RadixSort {
    static void radixSort(long[] arrayToSort) {
        LinkQueue[] tempArray = new LinkQueue[10];
        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = new LinkQueue();
        }

        long maxValue = arrayToSort[0];

        for (int i = 1; i < arrayToSort.length; i++) {
            if (arrayToSort[i] > maxValue) {
                maxValue = arrayToSort[i];
            }
        }

        int digitPosition = 1;
        while (maxValue > 0) {

            for (int i = 0; i < arrayToSort.length; i++) {
                tempArray[getDigit(arrayToSort[i], digitPosition)].insert(arrayToSort[i]);
            }

            int i = 0;
            while (i < arrayToSort.length) {
                for (LinkQueue linkQueue: tempArray) {
                    while (!linkQueue.isEmpty()) {
                        arrayToSort[i] = linkQueue.remove();
                        i++;
                    }
                }
            }

            digitPosition++;
            maxValue /= 10;
        }

    }

    static int getDigit(long value, int digitPosition) {
        int divisor = (int) Math.pow(10, digitPosition);
        long remainder = value % divisor;
        int digit = (int) remainder / (divisor / 10);
        return digit;
    }
}

public class Ex7_5RadixSort {
    public static void main(String[] args) {
        int arraySize = 100;
        long[] array = new long[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = (long) (Math.random() * arraySize);
        }

        System.out.println(Arrays.toString(array));

        RadixSort.radixSort(array);

        System.out.println(Arrays.toString(array));

    }
}
