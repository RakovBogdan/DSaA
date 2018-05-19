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
}

public class QuickSortApp1 {

    public static void main(String[] args) {
        int maxSize = 12;
        ArrayQuick1 arrayQuick1 = new ArrayQuick1(maxSize);

        for (int i = 0; i < maxSize; i++) {
            arrayQuick1.addElement((long)(Math.random() * maxSize));
        }

        arrayQuick1.display();
    }
}
