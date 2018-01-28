package lafore.chapter06;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Params {
    int number;
    int returnAddress;

    public Params(int number, int returnAddress) {
        this.number = number;
        this.returnAddress = returnAddress;
    }
}

class StackX {
    private Params[] params;
    private int currentAddress;

    public StackX(int maxSize) {
        params = new Params[maxSize];
        currentAddress = -1;
    }


    public void push(Params p) {
        params[++currentAddress] = p;
    }

    public Params pop() {
        return params[currentAddress--];
    }

    public Params peek() {
        return params[currentAddress];
    }
}


public class StackTriangle {

    private static int answer;
    private static int operationCode;
    private static int theNumber;
    private static StackX stack;


    public static void main(String[] args) {
        System.out.print("Please, enter a number for triangle calculation: ");
        theNumber = getNumber();
        recTriangle();
        System.out.println("\nSum of triangle numbers: " + answer);
    }

    public static void recTriangle() {
        stack = new StackX(1000);
        operationCode = 1;

        while (step() == false) {
            ;
        }
    }

    private static boolean step() {
        switch (operationCode) {
            case 1:
                Params startParams = new Params(theNumber, 6);
                stack.push(startParams);
                operationCode = 2;
                break;
            case 2:
                Params currentParams = stack.peek();
                if (currentParams.number == 1) {
                    answer = 1;
                    operationCode = 5;
                } else {
                    operationCode = 3;
                }
                break;
            case 3:
                theNumber -= 1;
                Params newParams = new Params(theNumber, 4);
                stack.push(newParams);
                operationCode = 2;
                break;
            case 4:
                answer += stack.peek().number;
                operationCode = 5;
                break;
            case 5:
                operationCode = stack.pop().returnAddress;
                break;
            case 6:
                return true;
        }

        return false;
    }

    private static int getNumber() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String result = "-1";

        try {
            result = br.readLine();
        } catch (IOException e) {
            System.out.println("Wrong input");
        }

        return Integer.parseInt(result);
    }
}
