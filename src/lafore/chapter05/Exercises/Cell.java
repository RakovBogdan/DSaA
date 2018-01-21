package lafore.chapter05.Exercises;

public class Cell {

    Cell nextRow;
    Cell nextColumn;
    long data;

    public Cell(long data) {
        this.data = data;
    }

    public void display() {
        System.out.print(data + " ");
    }
}
