package lafore.chapter05.Exercises;


public class Link
{
    Link next;
    double dData;

    public Link(double dData)
    {
        next = null;
        this.dData = dData;
    }
    
    public void displayLink()
    {
        System.out.print(dData + " ");
    }
}
