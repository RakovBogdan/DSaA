package lafore.chapter07.exercises;


class ArrayMedianPartition {

    private long[] elements;
    private int numberOfElements;
    private int medianPosition;

    public ArrayMedianPartition(int maxSize) {
        this.elements = new long[maxSize];
        numberOfElements = 0;
    }

    public void add(long value) {
        if (numberOfElements < elements.length) {
            elements[numberOfElements] = value;
            numberOfElements++;
        }
    }

    public void display() {
        for (int i = 0; i < numberOfElements; i++) {
            System.out.print(elements[i] + " ");
        }

        System.out.println();
    }

    public void printMedianElement() {
        this.medianPosition = (numberOfElements - 1) / 2;
        findMedianRecursion(0, numberOfElements - 1);
    }

    private void findMedianRecursion(int left, int right) {

        int pivotPosition = partitionIt(left, right);

        if (pivotPosition == this.medianPosition) {
            System.out.println("Position:" + pivotPosition + ", element:" + elements[pivotPosition]);
            return;
        }

        if (pivotPosition > medianPosition) {
            findMedianRecursion(left, pivotPosition - 1);
        } else {
            findMedianRecursion(pivotPosition + 1, right);
        }
    }

    public int partitionIt(int left, int right) {
        if (right - left <= 0) {
            return left;
        }

        int leftIndex = left - 1;
        int rightIndex = right;

        while (true) {
            while (elements[++leftIndex] < elements[right]) ;

            while (elements[--rightIndex] > elements[right] && rightIndex > left) ;

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
        long tmp = elements[firstIndex];
        elements[firstIndex] = elements[secondIndex];
        elements[secondIndex] = tmp;
    }
}

public class Ex7_3MedianPartition {
    public static void main(String[] args) {
        int maxSize = 11;
        ArrayMedianPartition arrayMedianPartition = new ArrayMedianPartition(maxSize);

        for (int i = 0; i < maxSize; i++) {
            arrayMedianPartition.add((long)(Math.random() * maxSize));
        }

        arrayMedianPartition.display();
        arrayMedianPartition.printMedianElement();
        arrayMedianPartition.display();
    }
}

