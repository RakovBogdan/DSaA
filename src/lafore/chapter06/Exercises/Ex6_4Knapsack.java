package lafore.chapter06.Exercises;

class StackEx4 {
    private int[] arr;
    private int currentIndex;

    public StackEx4(int maxSize) {
        arr = new int[maxSize];
        currentIndex = -1;
    }

    public void put(int element) {
        arr[++currentIndex] = element;
    }

    public int pop() {
        return arr[currentIndex--];
    }

    public int peek() {
        return arr[currentIndex];
    }

    public void display() {
        for (int i = 0; i <= currentIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class Ex6_4Knapsack {

    private int weights[];
    private int target;
    StackEx4 stack;

    public Ex6_4Knapsack(int[] weights, int target) {
        this.weights = weights;
        this.target = target;
        stack = new StackEx4(weights.length);
    }

    public void combine() {
        combineRec(target, 0);
    }

    public void combineRec(int target, int weightIndex) {
        if (target == 0) {
            stack.display();
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = weightIndex; i < weights.length; i++) {
            stack.put(weights[i]);
            combineRec(target - weights[i], i + 1);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Ex6_4Knapsack ex4 = new Ex6_4Knapsack(new int[]{11, 8, 7, 6, 5}, 20);
        ex4.combine();
    }
}
