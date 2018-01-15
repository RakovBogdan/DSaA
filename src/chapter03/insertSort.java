package chapter03;

class ArrayIns {

    private long[] a;
    private int nElems;

    public ArrayIns(int size) {
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

    public void insertionSort() {
        int outer;
        int inner;
        int comprasions = 0;
        int copies = 0;

        for (outer = 1; outer < nElems; outer++) {
            long temp = a[outer];
            inner = outer;
            while (inner>0)
                if (a[inner-1] > temp) {
                    a[inner] = a[inner-1];
                    inner--;
                    copies++;
                    comprasions++;
                }  else {
                    comprasions++;
                    break;
                }
            a[inner] = temp;
        }

        System.out.println("Comprasions: " + comprasions + ", copies: " + copies);
    }

    public void insertionSortNoDups() {
        int inner, outer;
        int numberOfDups = 0;

        for (outer = 1; outer < nElems; outer++) {
            long temp = a[outer];
            inner = outer;
            while (inner>0 && a[inner-1] >= temp) {
                if (a[inner-1] == temp && a[inner-1] > -1) {
                    temp = -1;
                    numberOfDups++;
                }
                a[inner] = a[inner-1];
                inner--;
                }
            a[inner] = temp;
        }

        for (int i = 0; i<nElems-numberOfDups; i++) {
            a[i] = a[i + numberOfDups];
        }
        nElems-=numberOfDups;
    }

    public long median() {
        insertionSort();
        return a[nElems/2];
    }

    public void noDups() {
        insertionSort();

        int shiftAmount = 0;
        int total = nElems;
        long curNum = 0;

        for (int i=0; i < total; i++) {
            if (a[i] == curNum) {
                shiftAmount++;
                nElems--;
            } else {
                a[i - shiftAmount] = a[i];
                curNum = a[i];
            }
        }
    }
}


class InsertSortApp {

    public static void main(String[] args) {
        int maxSize = 10;
        ArrayIns arr = new ArrayIns(maxSize);

        for(int j=0; j<maxSize; j++) {
            long n = (long)( Math.random() * 10 );
            arr.insert(n);
        }

        arr.display();
        arr.insertionSortNoDups();
        arr.display();
    }
}