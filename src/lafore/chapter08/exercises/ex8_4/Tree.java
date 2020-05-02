package lafore.chapter08.exercises.ex8_4;


public class Tree {

    private Node root;

    public Tree(char value) {
        root = new Node(value);
    }

    public void insertLeftTree(Tree tree) {
        root.leftChild = tree.root;
    }

    public void insertRightTree(Tree tree) {
        root.rightChild = tree.root;
    }

    public void traverse(int traverseType) {
        switch(traverseType) {
            case 1: System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2: System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3: System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    private void preOrder(Node localRoot) {
        if(localRoot != null) {
            System.out.print(localRoot.value);
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(Node localRoot) {
        if(localRoot != null) {
            System.out.print("(");
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.value);
            inOrder(localRoot.rightChild);
            System.out.print(")");

        }
    }

    private void postOrder(Node localRoot) {
        if(localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.value);
        }
    }


     private static class Node {
        char value;
        Node leftChild;
        Node rightChild;

        Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
