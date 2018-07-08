package lafore.chapter08.exercises.ex8_3;

import java.util.Stack;

public class Tree {

    private Node[] nodes;
    private Node root;

    public Tree(int size) {
        this.nodes = new Node[size];
    }

    public void insert(char letter) {
        Node newNode = new Node(letter);

        if (root == null) {
            nodes[0] = newNode;
            root = newNode;
            return;
        }

        int nextEmptyCellIndex = -1;

        while (nextEmptyCellIndex < nodes.length && nodes[++nextEmptyCellIndex] != null);

        Node parent = nodes[(nextEmptyCellIndex - 1) / 2];

        if (nextEmptyCellIndex % 2 == 0) {
            parent.rightNode = newNode;
        } else {
            parent.leftNode = newNode;
        }

        nodes[nextEmptyCellIndex] = newNode;
    }

    void displayTree() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        boolean isNextRowEmpty = false;

        int spaceBetweenNodes = 64;

        while (!isNextRowEmpty) {
            Stack<Node> localStack = new Stack<>();
            isNextRowEmpty = true;

            for (int i = 0; i < spaceBetweenNodes / 2; i++) {
                System.out.print(" ");
            }

            while (!globalStack.empty()) {
                Node currentNode = globalStack.pop();

                if (currentNode != null) {
                    System.out.print(currentNode.getLetter());
                    localStack.push(currentNode.leftNode);
                    localStack.push(currentNode.rightNode);
                    if (currentNode.leftNode != null ||
                            currentNode.rightNode != null) {
                        isNextRowEmpty = false;
                    }
                } else {
                    System.out.print("-");
                    localStack.push(null);
                    localStack.push(null);
                }

                for (int i = 0; i < spaceBetweenNodes - 1; i++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.empty()) {
                globalStack.push(localStack.pop());
            }

            spaceBetweenNodes /= 2;
        }
    }

    public static void main(String[] args) {
        String lettersString = "ABCDEFGHIJ";
        char[] letters = lettersString.toCharArray();

        Tree tree = new Tree(letters.length);

        for (char letter: letters) {
            tree.insert(letter);
        }

        tree.displayTree();
    }
}
