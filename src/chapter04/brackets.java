package chapter04;


import java.io.*;


class BracketCheker {

    private String input;

    public BracketCheker(String input) {
        this.input = input;
    }

    public void check() {

        StackChar stack = new StackChar(input.length());

        for (int i=0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch(ch) {
                case '[':
                case '{':
                case '(':
                    stack.push(ch);
                    break;
                case ']':
                case '}':
                case ')':
                    if (!stack.isEmpty()) {
                        char chx = stack.pop();
                        if(chx!='[' && ch==']' ||
                            chx!='{' && ch=='}' ||
                            chx!='(' && ch==')')
                            System.out.println("Error: " + ch + " at " + i);

                    } else {
                        System.out.println("Error: " + ch + " at " + i);
                    }
                default:
                    break;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("Missing right delimeter");
        }
    }
}


class BracketsApp {

    public static void main(String[] args) throws IOException{

        String input;
        while(true) {
            System.out.print("Enter a string with delimiters: ");
            System.out.flush();
            input = getString();
            if(input.equals(""))
                break;

            BracketCheker checker = new BracketCheker(input);
            checker.check();
        }
    }

    public static String getString() throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        return br.readLine();
    }
}