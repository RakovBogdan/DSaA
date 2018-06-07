package lafore.chapter08.tree;

public class TreeMain {

    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(50, 10.1);
        tree.insert(25, 10.2);
        tree.insert(75, 10.3);
        tree.insert(12, 10.3);
        tree.insert(37, 10.3);
        tree.insert(43, 10.3);
        tree.insert(30, 10.3);
        tree.insert(33, 10.3);
        tree.insert(87, 10.3);
        tree.insert(93, 10.3);
        tree.insert(97, 10.3);


        System.out.println(tree.find(25));

        tree.inOrder();
        tree.displayTree();
    }
}
