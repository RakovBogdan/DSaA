package lafore.chapter06;

public class TowersOfHanoi {

    public static void doTowers(int nDisks, char from, char inter, char to) {
        if (nDisks == 1) {
            System.out.println(nDisks + " from:" + from + ", to:" + to);
        } else {
            doTowers(nDisks - 1, from, to, inter);
            System.out.println(nDisks + " from:" + from + ", to:" + to);
            doTowers(nDisks - 1, inter, from, to);
        }
    }

    public static void main(String[] args) {
        doTowers(4, 'A', 'B', 'C');
    }
}
