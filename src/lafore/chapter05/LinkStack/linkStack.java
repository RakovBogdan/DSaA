package lafore.chapter05.LinkStack;


class Link {

    public Link next;
    public long dData;

    public Link(long dData) {
        this.dData = dData;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}

class LinkList {

    private Link first;

    public LinkList() { first = null; }

    public boolean isEmpty() { return (first == null); }

    public void insertFirst(long dData) {
        Link newLink = new Link(dData);
        newLink.next = first;
        first = newLink;
    }

    public long deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp.dData;
    }

    public void displayList () {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}


class LinkStack {

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


class LinkStackApp {

    public static void main(String[] args) {
        LinkStack stack = new LinkStack();
        stack.push(20);
        stack.push(40);
        stack.displayStack();

        stack.push(60);
        stack.push(80);
        stack.displayStack();

        stack.pop();
        stack.pop();
        stack.displayStack();
    }
}
