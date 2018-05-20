package lafore.chapter07.exercises;

class ArrayQuick2 {

    private long[] values;
    private int numberOfElements;

    private int copies;
    private int comparisons;

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
        System.out.println("copies: " + copies + ", comparisons: " + comparisons);
    }

    public void quickSort() {
        recursiveQuickSort(0, numberOfElements - 1);
    }

    private void recursiveQuickSort(int left, int right) {
        int size = right - left + 1;
        comparisons++;
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
        comparisons++;
        if (size <= 1) {
            return;
        }
        comparisons++;
        if (size == 2) {
            comparisons++;
            if (values[left] > values[right]) {
                swap(left, right);
            }
        }
        else {
            int center = right - 1;

            comparisons += 3;
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
            while (values[++leftIndex] < pivot) {
                comparisons++;
            }
            comparisons++;
            while (values[--rightIndex] > pivot) {
                comparisons++;
            }
            comparisons++;

            comparisons++;
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

        comparisons+=3;
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
        copies+=3;
    }
}

public class Ex7_2QuickSortCount {

    public static void main(String[] args) {
        int maxSize = 12;
        ArrayQuick2 arrayQuick2 = new ArrayQuick2(maxSize);

        for (int i = maxSize - 1; i >= 0; i--) {
            arrayQuick2.addElement(i);
        }

        arrayQuick2.display();
        arrayQuick2.quickSort();
        arrayQuick2.display();
    }
}

