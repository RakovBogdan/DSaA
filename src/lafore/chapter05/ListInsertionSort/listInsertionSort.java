package lafore.chapter05.ListInsertionSort;


class Link {

    public long dData;
    public Link next;

    public Link(long dData) { this.dData = dData; }

    public void displayLink() { System.out.print(dData  + " "); }
}

class SortedList {

    private Link first;

    public SortedList() { first = null; }

    public SortedList(Link[] linkArr) {
        first = null;
        for (int j=0; j < linkArr.length; j++)
            insert(linkArr[j]);
    }

    public boolean isEmpty() { return (first == null); }

    public void insert(Link k) {

        Link current = first;
        Link previous = null;

        while (current != null && current.dData < k.dData) {
            previous = current;
            current = current.next;
        }
        if (previous == null)
            first = k;
        else
            previous.next = k;
        k.next = current;
    }

    public Link remove() {
        Link temp = first;
        first = first.next;
        return  temp;
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


class ListInsertionSortApp {

    public static void main(String[] args) {

        Link[] linkArray = new Link[10];
        for (int i=0; i < linkArray.length; i++) {
            int n = (int)(Math.random() * 99);
            Link newLink = new Link(n);
            linkArray[i] = newLink;
        }

        System.out.print("Unsorted array:  ");
        for (int i=0; i < linkArray.length; i++) {
            System.out.print(linkArray[i].dData + " ");
        }
        System.out.println("");

        SortedList list = new SortedList(linkArray);
        for (int i=0; i < linkArray.length; i++) {
            linkArray[i] = list.remove();
        }

        System.out.print("Sorted array:  ");
        for (int i=0; i < linkArray.length; i++) {
            System.out.print(linkArray[i].dData + " ");
        }
        System.out.println("");
    }
}