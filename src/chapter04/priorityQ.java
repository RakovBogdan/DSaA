package chapter04;


class PriorityQ {

    private long[] arr;
    private int maxsize;
    private int nElems;

    public PriorityQ(int maxSize) {
        this.maxsize = maxSize;
        arr = new long[maxSize];
        nElems = 0;
    }

    public void insert(long value) {
        int j;

        if (nElems==0)
            arr[nElems++] = value;
        else {
            for (j=nElems-1; j>=0; j--) {
                if (value > arr[j]) {
                    arr[j + 1] = arr[j];
                } else
                    break;
            }
            arr[j + 1] = value;
            nElems++;
        }
    }

    public long remove() {
        return arr[--nElems];
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
}


class PriorityQApp {

    public static void main(String[] args) {
        PriorityQ pq = new PriorityQ(5);
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




















