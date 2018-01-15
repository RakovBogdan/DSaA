package chapter05.Exercises;


class SortedLinkList
{
    private Link first;

    public SortedLinkList()
    {
        first = null;
    }
    
    public void insert(double dData) {
        Link newLink = new Link(dData);
        
        Link current = first;
        Link previous = null;
        while (current != null && current.dData < dData)
        {
            previous = current;
            current = current.next;
        }
        if (previous == null) first = newLink;
        else previous.next = newLink;
        newLink.next = current; 
    }
    
    public double remove() {
        Link temp = first;
        first = first.next;
        return temp.dData;
    }
    
    boolean isEmpty()
    {
        return (first == null);
    }
    
    public void displayList() {
        System.out.print("List smaller-->bigger:");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}


class PriorityQueue {
    private SortedLinkList sorted = new SortedLinkList();
    
    public void insert(double dData)
    {
        sorted.insert(dData);
    }
    
    public double remove()
    {
        return sorted.remove();
    }
    
    public boolean isEmpty()
    {
        return sorted.isEmpty();
    }
    
    public void display()
    {
        sorted.displayList();
    }
        
}


class Ex5_1 {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.insert(10.9);
        pq.insert(5.0);
        pq.insert(40.0);
        pq.insert(20.0);
        
        pq.display();
    }
}
