package lafore.chapter08.exercises.ex8_3;

import java.util.Stack;

public class TreeFullCreation {

    private Node root;

    private int lettersSize;
    private char[] letters;

    TreeFullCreation(String lettersString) {
        letters = lettersString.toCharArray();
        lettersSize = letters.length;
        root = recursiveFill(1);
    }

    private Node recursiveFill(int location) {
        if (location > lettersSize) {
            return null;
        }
        Node newNode = new Node(letters[location - 1]);
        newNode.leftNode = recursiveFill(location * 2);
        newNode.rightNode = recursiveFill(location * 2 + 1);
        return newNode;
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
        TreeFullCreation treeFullCreation = new TreeFullCreation(lettersString);

        treeFullCreation.displayTree();
    }
}
