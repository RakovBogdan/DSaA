package lafore.chapter06.Exercises;

public class Ex6_2BinaryTree {

    private char[] chars;
    private int lineLength;
    private int numberOfLines;

    public Ex6_2BinaryTree(int lineLength) {
        this.lineLength = lineLength;
        int lengthTmp = lineLength;
        while (lengthTmp != 0) {
            lengthTmp /= 2;
            numberOfLines++;
        }
        chars = new char[lineLength * numberOfLines];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = '-';
        }
    }

    public void makeBranches() {
        recBranches(0, lineLength - 1, 0);
    }

    private void recBranches(int left, int right, int treeLevel) {
        if (right - left == 0) {
            chars[lineLength * treeLevel + left] = 'X';
            return;
        }
        int middle = (right + left) / 2;
        chars[lineLength * treeLevel + middle + 1] = 'X';
        recBranches(left, middle, treeLevel + 1);
        recBranches(middle + 1, right, treeLevel + 1);
    }

    public void display() {
        for (int i = 0; i < numberOfLines; i++) {
            for (int j = 0; j < lineLength; j++) {
                System.out.print(chars[lineLength * i + j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Ex6_2BinaryTree ex = new Ex6_2BinaryTree(16);
        ex.makeBranches();
        ex.display();
    }
}
