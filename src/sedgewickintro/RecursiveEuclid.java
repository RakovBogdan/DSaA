package sedgewickintro;

public class RecursiveEuclid {

    public static int findGreatestCommonDivisor(int p, int q) {
        if (q == 0) { return p; }

        return findGreatestCommonDivisor(q, p % q);
    }

    public static void main(String[] args) {
        System.out.println(findGreatestCommonDivisor(1440, 408));
    }
}
