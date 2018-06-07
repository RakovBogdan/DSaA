package lafore.chapter05.LinkStack;

public class Stack {

    LinkList list = new LinkList();

    public void push(long dData) {
        list.insertFirst(dData);
    }

    public long pop() {
        return list.deleteFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void displayStack() {
        System.out.print("Stack: top -> bottom: ");
        list.displayList();
    }

}
