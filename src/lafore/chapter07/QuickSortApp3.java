package lafore.chapter07;

class ArrayQuick3 {

    private long[] values;
    private int numberOfElements;

    public ArrayQuick3(int maxSize) {
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
        int size = right - left + 1;
        if (size <= 10) {
            insertionSort(left, right);
        } else {

            long pivot = medianOf3Pivot(left, right);
            int pivotPosition = partition(left, right, pivot);

            recursiveQuickSort(left, pivotPosition - 1);
            recursiveQuickSort(pivotPosition + 1, right);
        }
    }

    private void insertionSort(int left, int right) {
        for (int outerIndex = left + 1; outerIndex <= right; outerIndex++) {
            int innerIndex = outerIndex;
            long tmp = values[innerIndex];

            while (innerIndex > left && values[innerIndex - 1] > tmp) {
                values[innerIndex] = values[innerIndex - 1];
                innerIndex--;
            }

            values[innerIndex] = tmp;
        }
    }

    private int partition(int left, int right, long pivot) {

        int leftIndex = left;
        int rightIndex = right - 1;

        while (true) {
            while (values[++leftIndex] < pivot) ;

            while (values[--rightIndex] > pivot) ;

            if (leftIndex >= rightIndex) {
                break;
            } else {
                swap(leftIndex, rightIndex);
            }
        }

        swap(leftIndex, right - 1);

        return leftIndex;
    }

    private long medianOf3Pivot(int left, int right) {
        int median = (left + right) / 2;

        if (values[left] > values[median]) {
            swap(left, median);
        }
        if (values[left] > values[right]) {
            swap(left, right);
        }
        if (values[median] > values[right]) {
            swap(median, right);
        }

        swap(median, right - 1);

        return values[right - 1];
    }

    private void swap(int firstIndex, int secondIndex) {
        long tmp = values[firstIndex];
        values[firstIndex] = values[secondIndex];
        values[secondIndex] = tmp;
    }
}

public class QuickSortApp3 {

    public static void main(String[] args) {
        int maxSize = 10_000_000;
        ArrayQuick3 arrayQuick3 = new ArrayQuick3(maxSize);

        for (int i = 0; i < maxSize; i++) {
            arrayQuick3.addElement((long)(Math.random() * maxSize));
        }

//        arrayQuick3.display();
        long startTime = System.nanoTime();
        arrayQuick3.quickSort();
        long endTime = System.nanoTime();
        long elapsedTimeMillis = (endTime - startTime) / 1_000_000;
        System.out.println(elapsedTimeMillis);
//        arrayQuick3.display();
    }
}
