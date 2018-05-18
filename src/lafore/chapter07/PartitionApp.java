package lafore.chapter07;

class PartArr {

    private long arr[];
    private int nElems;

    public PartArr(int maxSize) {
        arr = new long[maxSize];
        nElems = 0;
    }

    public void add(long value) {
        arr[nElems] = value;
        nElems++;
    }

    public int size() {
        return nElems;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int partition(int left, int right, long pivot) {

        int leftIndex = -1;
        int rightIndex = nElems;

        while (true) {
            while (leftIndex < right && arr[++leftIndex] < pivot)
                ;

            while (rightIndex > left && arr[--rightIndex] > pivot)
                ;

            if (leftIndex >= rightIndex) {
                break;
            } else {
                swap(leftIndex, rightIndex);
            }
        }

        return leftIndex;
    }

    private void swap(int firstIndex, int secondIndex) {
        long tmp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = tmp;
    }

}

public class PartitionApp {
    public static void main(String[] args) {
        int maxSize = 16;
        PartArr arr = new PartArr(maxSize);
        for (int i = 0; i < maxSize; i++) {
            arr.add((long) (Math.random() * 199));
        }
        arr.display();

        arr.partition(0, arr.size() - 1, 99);

        arr.display();
    }
}
