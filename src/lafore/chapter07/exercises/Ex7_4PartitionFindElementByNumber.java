package lafore.chapter07.exercises;

class ArrayPartitionFindIndex {

    private long[] elements;
    private int numberOfElements;
    private int indexPosition;

    public ArrayPartitionFindIndex(int maxSize) {
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

    public void printElementByIndex(int indexToPrint) {
        this.indexPosition = indexToPrint;
        findIndexRecursion(0, numberOfElements - 1);
    }

    private void findIndexRecursion(int left, int right) {

        int pivotPosition = partitionIt(left, right);

        if (pivotPosition == this.indexPosition) {
            System.out.println("Position:" + pivotPosition + ", element:" + elements[pivotPosition]);
            return;
        }

        if (pivotPosition > indexPosition) {
            findIndexRecursion(left, pivotPosition - 1);
        } else {
            findIndexRecursion(pivotPosition + 1, right);
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

public class Ex7_4PartitionFindElementByNumber {
    public static void main(String[] args) {
        int maxSize = 11;
        ArrayPartitionFindIndex arrayPartitionFindIndex = new ArrayPartitionFindIndex(maxSize);

        for (int i = 0; i < maxSize; i++) {
            arrayPartitionFindIndex.add((long)(Math.random() * maxSize));
        }

        arrayPartitionFindIndex.display();
        arrayPartitionFindIndex.printElementByIndex(5);
        arrayPartitionFindIndex.display();
    }
}


