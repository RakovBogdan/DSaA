package lafore.chapter06.Exercises;

public class Ex6_1 {

    public int mult(int x, int y) {
        int answer = 0;

        for (int i = 0; i < y; i++) {
            answer += x;
        }

        return answer;
    }

    public int recMult(int x, int y) {
        if (y == 1) {
            return x;
        }

        return x + recMult(x,y - 1);
    }

    public static void main(String[] args) {
        Ex6_1 ex6_1 = new Ex6_1();
        System.out.println(ex6_1.mult(2,5));
        System.out.println(ex6_1.recMult(2,5));
    }
}
