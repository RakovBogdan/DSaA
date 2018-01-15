package chapter05.Exercises;


class DLink
{
    DLink next;
    DLink previous;
    double dData;

    public DLink(double dData)
    {
        this.dData = dData;
        next = null;
        previous = null;
    }
    
    public void displayLink()
    {
        System.out.print(this.dData + " ");
    }    
}


class DoublyLinkedList
{
    private DLink first;
    private DLink last;
    
    public DLink getFisrt()
    {
        return first;
    }
    
    public DLink getLast()
    {
        return last;
    }

    public DoublyLinkedList()
    {
        first = null;
        last = null;
    }
   
    public boolean isEmpty()
    {
        return (first == null);
    }
    
    public void insertFirst(double dData)
    {
        DLink newLink = new DLink(dData);
        
        if (isEmpty()) last = newLink;
        else  first.previous = newLink;
        
        newLink.next = first;
        first = newLink;
    }
    
    public void insertLast(double dData)
    {
        DLink newLink = new DLink(dData);
        
        if (isEmpty()) first = newLink;
        else  last.next = newLink;
        
        newLink.previous = last;
        last = newLink;
    }
    
    public DLink deleteFirst()
    {
        DLink temp = first;
        
        if (first.next == null) last = null;
        else first.next.previous = null;
        
        first = first.next;
        return temp;
    }
    
    public DLink deleteLast()
    {
        DLink temp = last;
        
        if (last.previous == null) first = null;
        else last.previous.next = null;
        
        last = last.previous;
        return temp;
    }
    
    public boolean insertAfter(double key, double dData)
    {
        DLink newLink = new DLink(dData);
        
        DLink current = first;
        while (current != null && key == current.dData)
        {
            current = current.next;
        }
        if (current == null) 
            return false;
        
        if (current.next == null)
        {
            last = newLink;
        }
        else
        {    
            current.next.previous = newLink;    
        }
        newLink.next = current.next;
        newLink.previous = current;
        current.next = newLink;
        return true;
    }
    
    public DLink deleteKey(double dData)
    {
        DLink current = first;
        while (current != null && dData != current.dData)
        {
            current = current.next;
        }
        if (current == null) return null;
        
        if (current.previous == null)
        {
            first = current.next;
        }
        else
        {
            current.previous.next = current.next;
        }
        
        if (current.next == null)
        {
            last = current.previous;
        }
        else
        {
            current.next.previous = current.previous;
        }
        return current;
    }
    
    public void displayForward()
    {
        DLink current = first;
        System.out.print("List (first-->last): ");
        
        while (current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
    
    public void displayBackward()
    {
        DLink current = last;
        System.out.print("List (last-->first): ");
        
        while (current != null)
        {
            current.displayLink();
            current = current.previous;
        }
        System.out.println("");
    }
}


class DeQueue
{
    DoublyLinkedList list;

    public DeQueue()
    {
        list = new DoublyLinkedList();
    }
    
    public void insertLeft(double dData)
    {
        list.insertFirst(dData);
    }
    
    public void insertRight(double dData)
    {
        list.insertLast(dData);
    }
    
    public DLink popLeft()
    {
        return list.deleteFirst();
    }
    
    public DLink popRight()
    {
        return list.deleteLast();
    }
    
    public double peekLeft()
    {
        return list.getFisrt().dData;
    }
    
    public double peekRight()
    {
        return list.getLast().dData;
    }
    
    public void display()
    {
        list.displayForward();
    }        
}





public class Ex5_2 
{
    public static void main(String[] args)
    {
        DeQueue dequeue = new DeQueue();
        dequeue.insertLeft(10);
        dequeue.insertLeft(20);
        dequeue.insertRight(5);
        dequeue.insertRight(7);
        dequeue.display();
        
        dequeue.popLeft();
        dequeue.popRight();
        dequeue.display();
    }
}
