package lafore.chapter08.exercises.ex8_3;

public class Node {

    private char letter;
    Node leftNode;
    Node rightNode;

    public Node(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }
}
