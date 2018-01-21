package lafore.chapter04;


/*class Customer {
*
*   private int numberOfGroceries;
    private String name;

    public Customer(String name, int numberOfGroceries) {
        this.name = name;
        this.numberOfGroceries = numberOfGroceries;
    }

    public int getNumberOfGroceries() {
        return numberOfGroceries;
    }

    public void setNumberOfGroceries(int numberOfGroceries) {
        this.numberOfGroceries = numberOfGroceries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
*/


class Supermarket {

    private Queue[] lines;

    public Supermarket(int numberOfLines, int maxQueueSize) {
        lines = new Queue[numberOfLines];
        for (int i=0; i < numberOfLines; i++) {
            lines[i] = new Queue(maxQueueSize);
        }
    }

    private int getTotalLineGroceries(Queue line) {
        return 0;
    }

    public void addCustomer() {
        int line = 0;
        long numberOfGroceries = (long)(Math.random() * 16);
        for (int i=0; i<lines.length; i++) {
            if (lines[line].getValueAt(i) < lines[i].getValueAt(i))
                line = i;
        }
        //lines[line].

    }

}
