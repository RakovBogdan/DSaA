package lafore.chapter05.LinkQueue;


class Link {

    public long dData;
    public Link next;

    public Link(long dData) { this.dData = dData; }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}


class FirstLastList {
    private Link first;
    private Link last;

    public FirstLastList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertLast(long dData) {
        Link newLink = new Link(dData);
        if (isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }


    public long deleteFirst() {
        long temp = first.dData;
        if (first.next == null)
            last = null;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List first -> last: ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}


public class LinkQueue {

    private FirstLastList list;

    public LinkQueue() { list = new FirstLastList(); }

    public boolean isEmpty() { return list.isEmpty(); }

    public void insert(long value) { list.insertLast(value); }

        public long remove() { return list.deleteFirst(); }

    public void displayQueue() {
        System.out.print("Queue");
        list.displayList();
    }

    public static void main(String[] args) {
        LinkQueue queue = new LinkQueue();
        queue.insert(20);
        queue.insert(40);
        queue.displayQueue();

        queue.insert(60);
        queue.insert(80);
        queue.displayQueue();

        queue.remove();
        queue.remove();
        queue.displayQueue();
    }
}
