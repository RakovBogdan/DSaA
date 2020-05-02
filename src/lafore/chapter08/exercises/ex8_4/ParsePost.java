package lafore.chapter08.exercises.ex8_4;

class ParsePost {

    private StackX theStack;
    private String input;

    public ParsePost(String s) {
        input = s;
    }

    public Tree doParse() {
        theStack = new StackX(20);

        for(int j=0; j<input.length(); j++) {
            char ch = input.charAt(j);
            if (ch >= '0' && ch <= '9') {
                theStack.push(new Tree(ch));
            }
            else {
                appendOperatorToStack(ch);
            }
        }

        return theStack.pop();
    }

    private void appendOperatorToStack(char ch) {
        Tree rightChild = theStack.pop();
        Tree leftChild = theStack.pop();
        Tree operandTree = new Tree(ch);
        operandTree.insertLeftTree(leftChild);
        operandTree.insertRightTree(rightChild);
        theStack.push(operandTree);
    }
}
