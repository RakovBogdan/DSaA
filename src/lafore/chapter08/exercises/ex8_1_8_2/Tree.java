package lafore.chapter08.exercises.ex8_1_8_2;


import java.util.Stack;

public class Tree{

    private Node root;

    void insert(char letter) {
        Node newNode = new Node(letter);

        if (root == null) {
            root = newNode;
        } else {
            Node newRoot = new Node('+');
            newRoot.leftNode = root;
            newRoot.rightNode = newNode;
            root = newRoot;
        }
    }

    void merge(Tree tree) {
        Node newRoot = new Node('+');
        newRoot.leftNode = root;
        newRoot.rightNode = tree.root;
        root = newRoot;
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

    public static Tree allNodesAreLeavesFromString(String nodes) {
        Tree[] forest = forestFromString(nodes);

        for (int i = 1; i < forest.length; i++) {
            forest[0].merge(forest[i]);
        }

        return forest[0];
    }

    public static Tree balancedTreeFromString(String nodes) {
        Tree[] forest = forestFromString(nodes);

        int mergeStep = 1;
        int sequenceStep = 2;
        while (mergeStep < forest.length) {
            for (int i = 0; i < forest.length - mergeStep; i+=sequenceStep) {
                forest[i].merge(forest[i + mergeStep]);
            }
            mergeStep *= 2;
            sequenceStep *= 2;
        }

        return forest[0];
    }

    private static Tree[] forestFromString(String nodes) {
        char[] letters = nodes.toCharArray();

        Tree[] trees = new Tree[letters.length];

        for (int i = 0; i < letters.length; i++) {
            char letter = letters[i];
            Tree newTree = new Tree();
            newTree.insert(letter);
            trees[i] = newTree;
        }

        return trees;
    }

    public static void main(String[] args) {
        String lettersString = "ABCDEF";

        Tree tree = allNodesAreLeavesFromString(lettersString);
        tree.displayTree();

        Tree balancedTree = balancedTreeFromString(lettersString);
        balancedTree.displayTree();
    }
}
