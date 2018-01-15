package chapter04;


import java.io.*;


class StackChar {

    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackChar(int size) {
        maxSize = size;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char value) {
        stackArray[++top] = value;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}


class Reverser {

    String input;
    String output;

    public Reverser(String input) {

        this.input = input;
    }

    public String reverse() {

        StackChar stack = new StackChar(input.length());

        for(int i=0; i< input.length(); i++) {
            stack.push(input.charAt(i));
        }

        output = "";
        while(!stack.isEmpty()) {
            output += stack.pop();
        }

        return output;
    }
}


class ReverseApp {

    public static void main(String[] args) throws IOException {

        String input, output;
        while (true) {
            System.out.print("Enter a string: ");
            System.out.flush();
            input = getString();

            if (input.equals("")) {
                break;
            }

            Reverser rev = new Reverser(input);
            System.out.println("Reversed word is: " + rev.reverse());
        }
    }

    public static String getString() throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String result = br.readLine();
        return result;
    }
}
