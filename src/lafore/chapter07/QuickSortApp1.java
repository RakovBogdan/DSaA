package lafore.chapter07;

class ArrayQuick1 {

    private long[] values;
    private int numberOfElements;

    public ArrayQuick1(int maxSize) {
        this.values = new long[maxSize];
        this.numberOfElements = 0;
    }

    public void addElement(long element) {
        if (numberOfElements < values.length) {
            values[numberOfElements] = element;
        }

        numberOfElements++;
    }

    public void display() {
        for (long value: values) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public void quickSort() {
        recursiveQuickSort(0, numberOfElements - 1);
    }

    private void recursiveQuickSort(int left, int right) {
        if (left >= right) {
            return;
        }

        long pivot = values[right];
        int pivotPosition = partition(left, right, pivot);

        recursiveQuickSort(left, pivotPosition - 1);
        recursiveQuickSort(pivotPosition + 1, right);
    }

    private int partition(int left, int right, long pivot) {

        int leftIndex = left - 1;
        int rightIndex = right;

        while (true) {
            while (values[++leftIndex] < pivot) ;

            while (values[--rightIndex] > pivot && rightIndex > left) ;

            if (leftIndex >= rightIndex) {
                break;
            } else {
                swap(leftIndex, rightIndex);
            }
        }

        swap(leftIndex, right);

        return leftIndex;
    }

    private void swap(int firstIndex, int secondIndex) {
        long tmp = values[firstIndex];
        values[firstIndex] = values[secondIndex];
        values[secondIndex] = tmp;
    }
}

public class QuickSortApp1 {

    public static void main(String[] args) {
        int maxSize = 1_000_000;
        ArrayQuick1 arrayQuick1 = new ArrayQuick1(maxSize);

        for (int i = 0; i < maxSize; i++) {
            arrayQuick1.addElement((long)(Math.random() * maxSize));
        }

//        arrayQuick1.display();
        long startTime = System.nanoTime();
        arrayQuick1.quickSort();
        long endTime = System.nanoTime();
        long elapsedTimeMillis = (endTime - startTime) / 1_000_000;
        System.out.println(elapsedTimeMillis);
//        arrayQuick1.display();
    }
}
