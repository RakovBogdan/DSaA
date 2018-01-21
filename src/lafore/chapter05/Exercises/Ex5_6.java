package lafore.chapter05.Exercises;


class Matrix {

    Cell start;
    private int rows;
    private int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        start = new Cell(11);
        Cell current = start;
        for (int i = 1; i < columns; i++) {
            current.nextColumn = new Cell(11 + i);
            current = current.nextColumn;
        }

        for (int i = 1; i < rows; i++) {
            appendRow(i + 1);
        }
    }

    public void appendRow(int position) {
        Cell current = start;

        for (int i = 1; i < position - 1; i++) {
            current = current.nextRow;
        }

        Cell aboveRow = current;
        Cell belowRow = null;

        if (current.nextRow == null) {
            current.nextRow = new Cell(position * 10 + 1);
            current = current.nextRow;
        } else {

        }

        for (int i = 1; i < columns; i++) {
            current.nextColumn = new Cell(position * 10 + i);
            current = current.nextColumn;
            aboveRow = aboveRow.nextColumn;
            aboveRow.nextRow = current;
        }
    }

    void setElement(int row, int column, long data) {
        Cell current = start;
        for (int i = 1; i < row; i++) {
            current = current.nextRow;
        }

        for (int i = 1; i < column; i++) {
            current = current.nextColumn;
        }

        current.data = data;
    }

    void displayMatrix() {
        Cell currentRow = start;
        for (int j = 0; j < rows; j++) {
            Cell currentColumn = currentRow;

            for (int i = 0; i < columns; i++) {
                currentColumn.display();
                currentColumn = currentColumn.nextColumn;
            }
            currentRow = currentRow.nextRow;
            System.out.println();
        }
        System.out.println();
    }


}


public class Ex5_6 {

    public static void main(String[] args) {
        Matrix matrix = new Matrix(3, 4);
        matrix.displayMatrix();
        matrix.setElement(2, 3, 10000);
        matrix.displayMatrix();
    }
}
