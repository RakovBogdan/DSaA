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
            int divisor = (int) Math.pow(10, digitPosition);

            for (int i = 0; i < arrayToSort.length; i++) {
                long remainder = arrayToSort[i] % divisor;
                int digit = (int) remainder / (divisor / 10);
                tempArray[digit].insert(arrayToSort[i]);
            }

            int i = 0;

            for (LinkQueue linkQueue: tempArray) {
                while (!linkQueue.isEmpty()) {
                    arrayToSort[i] = linkQueue.remove();
                    i++;
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
        int maxSize = 10_000_000;
        long[] array = new long[maxSize];
        for (int i = 0; i < maxSize; i++) {
            array[i] = (long) (Math.random() * maxSize);
        }

/*        System.out.println(Arrays.toString(array));

        RadixSort.radixSort(array);

        System.out.println(Arrays.toString(array));*/

        long startTime = System.nanoTime();
        RadixSort.radixSort(array);
        long endTime = System.nanoTime();
        long elapsedTimeMillis = (endTime - startTime) / 1_000_000;
        System.out.println(elapsedTimeMillis);

    }
}
