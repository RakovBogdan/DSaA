package chapter05.InterIterator;


import java.io.*;


class Link {

    public long dData;
    public Link next;

    public Link(long dData) { this.dData = dData; }

    public void displayLink() { System.out.print(dData + " "); }
}


class LinkList {

    private Link first;

    public LinkList() { first = null; }

    public Link getFirst() {
        return first;
    }

    public void setFirst(Link first) {
        this.first = first;
    }

    public boolean isEmpty() { return (first == null); }

    public ListIterator getListIterator() {
        return new ListIterator(this);
    }

    public void displayList() {
        System.out.print("LinkList (left --> right: ");
        Link current = first;
        while (current != null) {
            System.out.print(current.dData + " ");
            current = current.next;
        }
        System.out.println();
    }
}


class ListIterator {

    private Link current;
    private Link previous;
    private LinkList ourList;

    public ListIterator(LinkList list) {
        this.ourList = list;
        reset();
    }

    public void reset() {
        this.current = ourList.getFirst();
        this.previous = null;
    }

    public boolean atEnd() { return (current.next == null); }

    public void nextLink() {
        previous = current;
        current = current.next;
    }

    public Link getCurrent() {
        return this.current;
    }

    public void insertAfter(long dd) {
        Link newLink = new Link(dd);

    }
}
