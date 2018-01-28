package lafore.chapter06;

class DArray {

    int nElems = 0;
    long[] arr;

    public DArray(int maxSize) {
        arr = new long[maxSize];
    }

    public void add(long element) {
        arr[nElems++] = element;
    }
    
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public void mergeSort() {
        long[] workspace = new long[nElems];
        recMergeSort(workspace, 0, nElems - 1);
    }

    private void recMergeSort(long[] workspace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(workspace, lowerBound, mid);
            recMergeSort(workspace, mid + 1, upperBound);
            merge(workspace, lowerBound, mid + 1, upperBound);
        }
    }

    private void merge(long[] workspace, int lowIndex, int highIndex, int endOfHigh) {
        int workSpaceIndex = 0;
        int startIndex = lowIndex;
        int lowerBound = highIndex -1;
        int size = endOfHigh - lowIndex + 1;

        while (lowIndex <= lowerBound && highIndex <= endOfHigh) {
            if (arr[lowIndex] < arr[highIndex]) {
                workspace[workSpaceIndex++] = arr[lowIndex++];
            } else {
                workspace[workSpaceIndex++] = arr[highIndex++];
            }
        }

        while (lowIndex <= lowerBound) {
            workspace[workSpaceIndex++] = arr[lowIndex++];
        }
        while (highIndex <= endOfHigh) {
            workspace[workSpaceIndex++] = arr[highIndex++];
        }

        for (int i = 0; i < size; i++) {
            arr[i + startIndex] = workspace[i];
        }
    }
}

public class MergeSortApp {

    public static void main(String[] args) {
        DArray dArray = new DArray(100);
        dArray.add(64);
        dArray.add(21);
        dArray.add(33);
        dArray.add(70);
        dArray.add(12);
        dArray.add(85);
        dArray.add(44);
        dArray.add(3);
        dArray.add(99);
        dArray.add(0);
        dArray.add(108);
        dArray.add(36);

        dArray.display();

        dArray.mergeSort();

        dArray.display();

        int maxSize = 100_000;
        DArray arr = new DArray(maxSize);

        for(int j=0; j<maxSize; j++) {
            long n = (long)( Math.random() * 100000 );
            arr.add(n);
        }

        long startTime = System.nanoTime();
        arr.mergeSort();
        long endTime = System.nanoTime();
        long elapsedTimeMillis = (endTime - startTime) / 1_000_000;
        System.out.println(elapsedTimeMillis);
//        arr.display();
    }
}
