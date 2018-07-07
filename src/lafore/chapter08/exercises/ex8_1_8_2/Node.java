package lafore.chapter08.exercises.ex8_1_8_2;

public class Node {

    char letter;
    Node leftNode;
    Node rightNode;

    public Node(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }
}
