package lafore.chapter08.exercises.ex8_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PostfixApp {

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.print("Enter postfix: ");
            System.out.flush();
            String input = getString();
            if (input.equals("")) {
                break;
            }

            ParsePost parser = new ParsePost(input);
            Tree output = parser.doParse();

            while (true) {
                System.out.print("Enter type 1, 2 or 3: ");
                int value = getInt();
                output.traverse(value);
                System.out.print("traverse again?: ");
                String answer = getString();
                if (!"y".equalsIgnoreCase(answer)) {
                    break;
                }
            }
        }
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
    
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}