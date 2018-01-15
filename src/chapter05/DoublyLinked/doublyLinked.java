package chapter05.DoublyLinked;


class Link {

    public long dData;
    public Link next;
    public Link previous;

    public Link(long dData) { this.dData = dData; }

    public void displayLink() { System.out.print(dData + " "); }
}


class DoublyLinkedList {

    private Link first;
    private Link last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() { return (first == null); }

    public void insertFirst(long dData) {
        Link newLink = new Link(dData);

        newLink.next = first;
        if (isEmpty())
            last = newLink;
        else
            first.previous = newLink;
        first = newLink;

    }

    public void insertLast(long dData) {
        Link newLink = new Link(dData);

        newLink.previous = last;
        if (isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;

        if (first.next == null)
            last = null;
        else
            first.next.previous = null;

        first = first.next;
        return temp;

    }

    public Link deleteLast() {
        Link temp = last;

        if (last.previous == null)
            first = null;
        else
            last.previous.next = null;

        last = last.previous;
        return temp;
    }

    public boolean insertAfter(long key, long dd) {
        Link newLink = new Link(dd);

        Link current = first;
        while (current.dData != key) {
            current = current.next;
            if (current == null)
                return false;
        }

        if (current == last) {
            newLink.next = null;
            last = newLink;
        }
        else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }

        newLink.previous = current;
        current.next = newLink;

        return true;
    }

    public Link delete(long key) {
        Link current = first;

        while(current.dData != key) {
            current = current.next;
            if (current == null)
                return null;
        }

        if (current == first)
            first = current.next;
        else
            current.previous.next = current.next;

        if (current == last)
            last = last.previous;
        else
            current.next.previous = current.previous;

        return current;
    }

    public void displayForward() {
        Link current = first;
        System.out.print("DoubleLinkedList (left --> right: ");
        while (current != null) {
            System.out.print(current.dData + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        Link current = last;
        System.out.print("DoubleLinkedList (right --> left: ");
        while (current != null) {
            System.out.print(current.dData + " ");
            current = current.previous;
        }
        System.out.println();
    }
}


class DoublyLinkedApp {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(22);
        list.insertFirst(44);
        list.insertFirst(66);

        list.insertLast(11);
        list.insertLast(33);
        list.insertLast(55);

        list.displayForward();
        list.displayBackward();

        list.deleteFirst();
        list.deleteLast();
        list.delete(11);
        list.displayForward();

        list.insertAfter(22, 77);
        list.insertAfter(33, 88);
        list.displayForward();

    }
}

