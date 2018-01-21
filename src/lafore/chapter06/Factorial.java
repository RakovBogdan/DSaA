package lafore.chapter06;

public class Factorial {

    public int factorial(int n) {

        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }


    public static void main(String[] args) {
        Factorial fct = new Factorial();
        System.out.println(fct.factorial(10));
    }
}
