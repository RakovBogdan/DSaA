package lafore.chapter07;

import java.util.Random;

class ArrayForShell {
    private long[] a;
    private int nElems;

    public ArrayForShell(int size) {
        a = new long[size];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for(int i=0; i<nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void shellSort() {
        int inner, outer, h = 1;

        while (h * 3 + 1 < nElems) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            outer = h;

            while (outer < nElems) {
                long tmp = a[outer];
                inner = outer;

                while (inner >= h && tmp < a[inner - h]) {
                    a[inner] = a[inner - h];
                    inner -= h;
                }

                a[inner] = tmp;
                outer++;
            }

            h = (h - 1) / 3;
        }
    }
}

public class ShellSortApp {

    public static void main(String[] args) {
//        ArrayForShell arr = new ArrayForShell(10);
//        for (int i = 0; i < 10; i++) {
//            arr.insert((long) (Math.random() * 99));
//        }
//        arr.display();
//        arr.shellSort();
//        arr.display();

        int maxSize = 100_000;
        ArrayForShell array = new ArrayForShell(maxSize);

        for (int i = 0; i < maxSize; i++) {
            array.insert((long) (Math.random() * maxSize));
        }

        long startTime = System.nanoTime();
        array.shellSort();
        long endTime = System.nanoTime();
        long elapsedTimeMillis = (endTime - startTime) / 1_000_000;

        System.out.println(elapsedTimeMillis);
    }
}
