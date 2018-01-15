package chapter05.SortedList;


class Link {

    public Link next;
    public long dData;

    public Link(long dData) { this.dData = dData; }

    public void displayLink() { System.out.print(dData + " "); }
}


class SortedList {

    private Link first;

    public SortedList() { first = null; }

    public boolean isEmpty() { return (first == null); }

    public void insert(long dData) {
        Link newLink = new Link(dData);
        Link current = first;
        Link previous = null;

        while (current != null && current.dData < dData) {
            previous = current;
            current = current.next;
        }
        if (previous == null)
            first = newLink;
        else
            previous.next = newLink;
        newLink.next = current;
    }

    public long remove() {
        Link temp = first;
        first = first.next;
        return  temp.dData;
    }

    public void display() {
        System.out.println("SortedList (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}


class SortedListApp {

    public static void main(String[] args) {
        SortedList list = new SortedList();
        list.insert(20);
        list.insert(40);
        list.display();

        list.insert(10);
        list.insert(30);
        list.insert(50);
        list.display();

        list.remove();
        list.display();

    }
}