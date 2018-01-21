package lafore.chapter04;


class Dequeue {

    private long[] arr;
    private int size;
    private int nElems;
    private int left;
    private int right;

    public Dequeue(int size) {
        this.size = size;
        arr = new long[size];
        nElems = 0;
        left = 0;
        right = -1;
    }

    public void insertLeft(long value) {
        left--;
        if (left < 0)
            left = size - 1;
        arr[left] = value;
        nElems++;
    }

    public void insertRight(long value) {
        if (right == size)
            right = -1;
        right++;
        arr[right] = value;
        nElems++;
    }

    public long removeLeft() {
        if (left == size)
            left = 0;
        left++;
        nElems--;
        return arr[left-1];
    }

    public long removeRight() {
        if (right < 0)
            right = size;
        right--;
        nElems--;
        return arr[right+1];
    }

    public long peekRight() {
        return arr[right];
    }

    public boolean isEmpty() {
        return (nElems == 0);
    }

    public boolean isFull() {
        return (nElems == size);
    }

    public void display() {
        System.out.print("Left:" + left + " Right:" + right + " ");
        int index = left;
        for (int i=0; i < nElems; i++) {
            if (index == size)
                index = 0;
            System.out.print(arr[index] + " ");
            index++;
        }
        System.out.println();
    }
}


class DequeueApp {

    public static void main(String[] args) {
        Dequeue deq = new Dequeue(5);
        deq.insertLeft(10);
        deq.insertLeft(20);
        deq.insertLeft(30);
        deq.display();

        deq.insertRight(50);
        deq.insertRight(60);
        deq.display();

        deq.removeLeft();
        deq.display();

    }
}
