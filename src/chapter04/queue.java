package chapter04;


class Queue {

    private long[] arr;
    private int front = 0;
    private int rear = -1;
    private int nElems;
    private int size;

    public Queue(int size) {
        this.size = size;
        arr = new long[size];
        nElems = 0;
    }

    public void insert(long value) {
        if(rear == size-1)
            rear = -1;
        arr[++rear] = value;
        nElems++;

    }

    public long remove() {
        if (front == size)
            front = 0;
        nElems--;
        return arr[front++];
    }

    public void display() {
        if (nElems == 0) {
            System.out.println("Queue is Empty");
        } else {
            int i = front;
            while (i != rear) {
                System.out.print(arr[i] + " ");
                i++;
                if (i == size)
                    i = 0;
            }
            System.out.print(arr[i]);
            System.out.println();
        }
    }

    public long getValueAt(int j) {
        return arr[j];
    }

    public long peekFront() {
        return arr[front];
    }

    public boolean isEmpty() {
        return (nElems == 0);
    }

    public boolean isFull() {
        return (nElems == size);
    }

    public int size() {
        return nElems;
    }
}

class QueueApp {

    public static void main(String[] args) {

        Queue queue = new Queue(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.display();

        queue.remove();
        queue.remove();
        queue.remove();
        queue.display();

        queue.insert(50);
        queue.insert(60);
        queue.insert(70);
        queue.insert(80);
        queue.display();




    }
}
