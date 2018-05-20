package lafore.chapter07.exercises;


class ArrayIns {

    private long[] elements;
    private int numberOfElements;

    public ArrayIns(int maxSize) {
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

public class Ex7_1PartitionRightPivot {
    public static void main(String[] args) {
        int maxSize = 1;
        ArrayIns arrayIns = new ArrayIns(maxSize);

        for (int i = 0; i < maxSize; i++) {
            arrayIns.add((long)(Math.random() * maxSize));
        }

        arrayIns.display();
        arrayIns.partitionIt(0, maxSize - 1);
        arrayIns.display();
    }
}
