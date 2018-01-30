package lafore.chapter06.Exercises;

public class Ex6_3RaiseNumber {

    public int power(int x, int y) {
        if (y == 1) {
            return x;
        }

        if (y % 2 == 1) {
            return power(x * x, y / 2) * x;
        } else {
            return power(x * x, y / 2);
        }

    }

    public static void main(String[] args) {
        Ex6_3RaiseNumber ex3 = new Ex6_3RaiseNumber();
        System.out.println(ex3.power(3, 18));
        System.out.println(ex3.power(2, 8));
    }
}
