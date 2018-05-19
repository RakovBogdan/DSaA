package lafore.chapter07;

class ArrayQuick2 {

    private long[] values;
    private int numberOfElements;

    public ArrayQuick2(int maxSize) {
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
        if (size <= 3) {
            sortThreeOrLessPartition(left, right);
        } else {

            long pivot = medianOf3Pivot(left, right);
            int pivotPosition = partition(left, right, pivot);

            recursiveQuickSort(left, pivotPosition - 1);
            recursiveQuickSort(pivotPosition + 1, right);
        }
    }

    private void sortThreeOrLessPartition(int left, int right) {
        int size = right - left + 1;
        if (size <= 1) {
            return;
        }
        else if (size == 2) {
            if (values[left] > values[right]) {
                swap(left, right);
            }
        }
        else if (size == 3) {
            int center = right - 1;

            if (values[left] > values[center]) {
                swap(left, center);
            }
            if (values[left] > values[right]) {
                swap(left, right);
            }
            if (values[center] > values[right]) {
                swap(center, right);
            }
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

public class QuickSortApp2 {

    public static void main(String[] args) {
        int maxSize = 1_900_000;
        ArrayQuick2 arrayQuick2 = new ArrayQuick2(maxSize);

        for (int i = 0; i < maxSize; i++) {
            arrayQuick2.addElement((long)(Math.random() * maxSize));
        }

//        arrayQuick2.display();
        long startTime = System.nanoTime();
        arrayQuick2.quickSort();
        long endTime = System.nanoTime();
        long elapsedTimeMillis = (endTime - startTime) / 1_000_000;
        System.out.println(elapsedTimeMillis);
//        arrayQuick2.display();
    }
}
