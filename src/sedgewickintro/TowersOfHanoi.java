package sedgewickintro;

public class TowersOfHanoi {

    public static void moves(int n, boolean left) {
        if (n == 0) { return; }
        moves(n - 1, !left);
        if (left) {
            System.out.println(n + " left");
        } else {
            System.out.println(n + " right");
        }
        moves(n - 1, !left);
    }

    public static void main(String[] args) {
        Integer numberOfDisks = Integer.parseInt(args[0]);
        moves(numberOfDisks, true);
    }
}
