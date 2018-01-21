package lafore.chapter04;


class DeqStack {

    private Dequeue deq;
    private int size;

    public DeqStack(int size) {
        this.size = size;
        deq = new Dequeue(size);
    }

    public void push(long value) {
        deq.insertRight(value);
    }

    public long pop() {
        return deq.removeRight();
    }

    public long peek() {
        return deq.peekRight();
    }

    public boolean isEmpty() {
        return deq.isEmpty();
    }

    public boolean isFull() {
        return deq.isFull();
    }
}


class DeqStackApp {

    public static void main(String[] args) {
        DeqStack theStack = new DeqStack(10);
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while (!theStack.isEmpty()) {
            long value = theStack.pop();
            System.out.print(value + " ");
        }
    }
}
