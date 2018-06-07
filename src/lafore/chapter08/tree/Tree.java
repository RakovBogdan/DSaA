package lafore.chapter08.tree;


import java.util.Stack;

public class Tree {

    private Node root;

    public void insert(int key, double otherData) {
        Node newNode = new Node();
        newNode.indexData = key;
        newNode.otherDoubleData = otherData;

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent;
        while (true) {
            parent = current;

            if (newNode.indexData < current.indexData) {
                current = current.leftNode;

                if (current == null) {
                    parent.leftNode = newNode;
                    return;
                }
            } else {
                current = current.rightNode;
                if (current == null) {
                    parent.rightNode = newNode;
                    return;
                }
            }
        }
    }

    public boolean delete(int key) {

        boolean isLeftChild = true;
        Node current = root;
        Node parent = root;

        while (current.indexData != key) {
            parent = current;
            if (key < current.indexData) {
                isLeftChild = true;
                current = current.leftNode;
            } else {
                isLeftChild = false;
                current = current.rightNode;
            }
            if (current == null) {
                return false;
            }

            if (current.leftNode == null && current.rightNode == null) {
                if (current == root) {
                    root = null;
                } else if (isLeftChild) {
                    parent.leftNode = null;
                } else {
                    parent.rightNode = null;
                }
            } else if (current.leftNode == null) {
                if (current == root) {
                    root = current.rightNode;
                } else if (isLeftChild) {
                    parent.leftNode = current.rightNode;
                } else {
                    parent.rightNode = current.rightNode;
                }
            } else if (current.rightNode == null) {
                if (current == root) {
                    root = current.leftNode;
                } else if (isLeftChild) {
                    parent.leftNode = current.leftNode;
                } else {
                    parent.rightNode = current.leftNode;
                }
            } else {
                Node successor = getSuccessor(current);

                if (current == root) {
                    root = current;
                } else if (isLeftChild) {
                    parent.leftNode = successor;
                } else {
                    parent.rightNode = successor;
                }

                successor.leftNode = current.leftNode;
            }
        }

        return true;
    }

    private Node getSuccessor(Node nodeToDelete) {
        Node successorParent = nodeToDelete;
        Node successor = nodeToDelete.rightNode;
        Node current = successor.leftNode;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftNode;
        }

        if (successor != nodeToDelete.rightNode) {
            successorParent.leftNode = successor.rightNode;
            successor.rightNode = nodeToDelete.rightNode;
        }

        return successor;
    }

    public Node find(int key) {
        Node current = root;

        while (current.indexData != key) {
            if (key < current.indexData) {
                current = current.leftNode;
            } else {
                current = current.rightNode;
            }
            if (current == null) {
                return null;
            }
        }

        return current;
    }

    public void inOrder() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node localNode) {
        if (localNode == null) {
            return;
        }

        inOrderRecursive(localNode.leftNode);
        System.out.println(localNode.indexData + " ");
        inOrderRecursive(localNode.rightNode);
    }

    public void preOrder() {
        preOrderRecursive(root);
    }


    //(A+B)*C = *+ABC
    private void preOrderRecursive(Node localNode) {
        if (localNode == null) {
            return;
        }
        System.out.println(localNode);
        preOrderRecursive(localNode.leftNode);
        preOrderRecursive(localNode.rightNode);
    }

    public void postOrder() {

    }

    //(A+B)*C = AB+C*
    private void postOrderRecursive(Node localNode) {
        if (localNode == null) {
            return;
        }

        postOrderRecursive(localNode.leftNode);
        postOrderRecursive(localNode.rightNode);
        System.out.println(localNode);
    }

    public void displayTree() {
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
                    System.out.print(currentNode.indexData);
                    localStack.push(currentNode.leftNode);
                    localStack.push(currentNode.rightNode);
                    if (currentNode.leftNode != null ||
                            currentNode.rightNode != null) {
                        isNextRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }

                for (int i = 0; i < spaceBetweenNodes - 2; i++) {
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
}
