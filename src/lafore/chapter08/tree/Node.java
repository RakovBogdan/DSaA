package lafore.chapter08.tree;

class Node {

    int indexData;
    double otherDoubleData;

    Node leftNode;
    Node rightNode;

    @Override
    public String toString() {
        return "{" + indexData + ", " + otherDoubleData + "} ";
    }
}
