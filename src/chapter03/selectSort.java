package chapter03;

class ArraySel {

	long[] a;
	int nElems;

	public ArraySel(int size) {
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

	public void selectionSort() {
		int outer;
		int inner;
		int min = 0;

		for(outer=0; outer < nElems-1; outer++) {
			for(inner=outer; inner < nElems; inner++) {
				if(a[inner] < a[min]) {
					min = inner;
				}
			}
			swap(min, outer);
		}
	}

	public void swap(int index1, int index2) {
		long temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
}


class SelectSortApp {

	public static void main(String[] args) {
		int maxSize = 100000;
		ArraySel arr = new ArraySel(maxSize);
		for(int j=0; j<maxSize; j++) { 
			long n = (long)( j );
			arr.insert(n);
		}

		//arr.display();
		arr.selectionSort();
		//arr.display();
	}
}