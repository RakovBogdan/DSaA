package chapter05.Exercises;


class CircularList
{
    private Link current;

    public CircularList()
    {
        current = null;
    }
    
    public void insert(double dData)
    {
        Link newLink = new Link(dData);
        current = newLink;
    }
    
    public void delete(double key)
    {
        
    }
    
    public void search(double key)
    {
        
    }
    
    public void display()
    {
        
    }
    
    public void step()
    {
        current = current.next;
    }
}


public class Ex5_3 
{

}
