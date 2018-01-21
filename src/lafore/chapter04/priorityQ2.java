package lafore.chapter04;


class PriorityQ2 {

    private long[] arr;
    private int maxsize;
    private int nElems;

    public PriorityQ2(int maxSize) {
        this.maxsize = maxSize;
        arr = new long[maxSize];
        nElems = 0;
    }

    public void insert(long value) {
        arr[nElems] = value;
        nElems++;
    }

    public long remove() {
        int minIndex = nElems-1;
        long min = arr[minIndex];

        for (int i = nElems-2; i>=0; i--) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }

        for (int i = minIndex; i < nElems-1; i++)
            arr[i] = arr[i + 1];
        nElems--;

        return min;
    }

    public long peek() {
        return arr[nElems-1];
    }

    public boolean isEmpty() {
        return (nElems == 0);
    }

    public boolean isFull() {
        return (nElems == maxsize);
    }

    public void display() {

    }
}


class PriorityQ2App {

    public static void main(String[] args) {
        PriorityQ2 pq = new PriorityQ2(5);
        pq.insert(30);
        pq.insert(50);
        pq.insert(10);
        pq.insert(40);
        pq.insert(20);

        while (!pq.isEmpty()) {
            long temp = pq.remove();
            System.out.print(temp + " ");
        }
        System.out.println();
    }
}
