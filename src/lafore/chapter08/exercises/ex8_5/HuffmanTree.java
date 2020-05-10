package lafore.chapter08.exercises.ex8_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static lafore.chapter08.exercises.ex8_5.HuffmanCodesDisplayHelper.escapeIfSpecialCharacter;

public class HuffmanTree {

    private Node root;

    public int getRootFrequency() {
        return root.frequency;
    }

    public HuffmanTree(String value, int frequency) {
        this.root = new Node(value, frequency);
    }

    public void insertLeftTree(HuffmanTree tree) {
        root.leftChild = tree.root;
    }

    public void insertRightTree(HuffmanTree tree) {
        root.rightChild = tree.root;
    }

    public Map<String, String> getHuffmanCodes() {
        Map<String, String> huffmanCodes = new HashMap<>();
        appendCode(root, new StringBuilder(), huffmanCodes);
        return huffmanCodes;
    }

    private void appendCode(Node currentNode, StringBuilder binaryCode, Map<String, String> huffmanCodes) {
        if (isLeafNode(currentNode.leftChild)) {
            huffmanCodes.put(currentNode.leftChild.value, binaryCode.append("0").toString());
        } else {
            appendCode(currentNode.leftChild, binaryCode.append("0"), huffmanCodes);
        }

        binaryCode.deleteCharAt(binaryCode.length() - 1);

        if (isLeafNode(currentNode.rightChild)) {
            huffmanCodes.put(currentNode.rightChild.value, binaryCode.append("1").toString());
        } else {
            appendCode(currentNode.rightChild, binaryCode.append("1"), huffmanCodes);
        }

        binaryCode.deleteCharAt(binaryCode.length() - 1);
    }

    private boolean isLeafNode(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    void displayTree() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        boolean isNextRowEmpty = false;

        int spaceBetweenNodes = 128;

        while (!isNextRowEmpty) {
            Stack<Node> localStack = new Stack<>();
            isNextRowEmpty = true;

            for (int i = 0; i < spaceBetweenNodes / 2; i++) {
                System.out.print(" ");
            }

            while (!globalStack.empty()) {
                Node currentNode = globalStack.pop();

                if (currentNode != null) {
                    System.out.print(escapeIfSpecialCharacter(currentNode.value));

                    localStack.push(currentNode.leftChild);
                    localStack.push(currentNode.rightChild);
                    if (currentNode.leftChild != null ||
                            currentNode.rightChild != null) {
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

    private static class Node {
        String value;
        int frequency;
        Node leftChild;
        Node rightChild;

        Node(String value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
