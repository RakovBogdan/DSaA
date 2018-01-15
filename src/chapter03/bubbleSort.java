package chapter03;

class ArrayBub {

	private long[] a;
	private int nElems;

	public ArrayBub(int size) {
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

	public void bubbleSort() {
		int inner;
		int outerRight;
		int outerLeft = 0;
		
		for(outerRight = nElems-1; outerLeft < outerRight; outerRight--, outerLeft++) {
            for(inner = 0; inner < outerRight; inner++) {
                if(a[inner] > a[inner + 1]) {
                    swap(inner, (inner + 1));
                }
            }
            inner--;
            for(; inner > outerLeft; inner--) {
                if(a[inner] < a[inner - 1]) {
                    swap(inner, (inner-1));
                }
            }
		}
	}

	public void oddEvenSort() {

	    boolean sortRequired = true;
	    while (sortRequired) {
            sortRequired = false;
            for (int j = 1; j < nElems-1; j += 2) {
                if (a[j] > a[j+1]) {
                    swap(j, j+1);
                    sortRequired = true;
                }
            }
            for (int j = 0; j < nElems-1; j += 2) {
                if (a[j] > a[j+1]) {
                    swap(j, j+1);
                    sortRequired = true;
                }
            }
        }

    }

	private void swap(int index1, int index2) {
		long temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
}


class BubbleSortApp {

	public static void main(String[] args) {
		
		int maxSize = 15;
		ArrayBub arr = new ArrayBub(maxSize);
		
		for(int j=0; j<10; j++) { 
			long n = (long)( Math.random() * 10 );
			arr.insert(n);
		}

		arr.display();
		arr.oddEvenSort();
		arr.display();
	}
}