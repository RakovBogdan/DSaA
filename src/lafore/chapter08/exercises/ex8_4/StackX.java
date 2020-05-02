package lafore.chapter08.exercises.ex8_4;

class StackX {

    private int maxSize;
    private Tree[] stackArray;
    private int top;

    public StackX(int size) {
        maxSize = size;
        stackArray = new Tree[maxSize];
        top = -1;
    }

    public void push(Tree element) {
        stackArray[++top] = element;
    }

    public Tree pop() {
        return stackArray[top--];
    }
}
