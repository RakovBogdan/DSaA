package lafore.chapter06;

public class Triangle {

    public int triangle(int n) {

        if (n == 1) {
            return 1;
        }

        return (n + triangle(n - 1));
    }

    public static void main(String[] args) {
        Triangle tr = new Triangle();
        System.out.println(tr.triangle(1000));
    }
}
