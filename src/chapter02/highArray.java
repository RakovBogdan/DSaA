import java.util.Arrays;

class HighArray {

	private long[] arr;
	private int nElems;

	public HighArray(int size) {
		arr = new long[size];
		nElems = 0;
	}

	public long getMax() {
		if(nElems == 0) 
			return -1;
		else {
			long max = arr[0];
			for(int i=1; i<nElems; i++) 
				if(max < arr[i])
					max = arr[i];
			return max;
		}
	}

	public long removeMax() {
		if(nElems == 0) 
			return -1;
		else {
			long max = arr[0];
			for(int i=1; i<nElems; i++) 
				if(max < arr[i])
					max = arr[i];
			delete(max);
			return max;
		}
	}

	public void insert(long item) {
		arr[nElems] = item;
		nElems++;
	}

	public boolean find(long searchKey) {
		int j;
		for (j=0; j<nElems; j++)
			if (arr[j] == searchKey)
				break;
		if (j == nElems) {
			System.out.println(searchKey + " Not Found");
			return false;
		}
		else {
			System.out.println(searchKey + " Found");
			return true;
		}
	}

	public boolean delete(long value) {
		int j;
		for (j=0; j<nElems; j++)
			if (arr[j] == value)
				break;
		if (j == nElems) {
			return false;
		} 
		else {
			for(int k = j; k < (nElems-1); k++) 
				arr[k] = arr[k+1];	
			nElems--;
			return true;
		}
	}

	public void noDups() {
		int counter = 0;
		for(int i=0; i<nElems; i++) {
			for(int j=i+1; j<nElems; j++) {
				if(arr[i] == arr[j]) {
					arr[j] = -1;
				}
			}
		}
		while(delete(-1)) {}
	}

	public void display() {
		for (int j=0; j<nElems; j++) 
			System.out.print(arr[j] + " ");
		System.out.println();
	}	
	
}


class HighArrayApp {

	public static void main(String[] args) {
		int max = 100;
		HighArray arr = new HighArray(max);
		
		arr.insert(1);
		arr.insert(12);
		arr.insert(12);
		arr.insert(14);
		arr.insert(1);
		arr.insert(4);
		arr.insert(5);
		arr.insert(4);
		arr.insert(111);
		arr.insert(2);
		arr.display();
		arr.noDups();
		arr.display();

		long[] sorted = new long[max];
		int i = 0;
		while(arr.getMax() != -1) {
			sorted[i] = arr.removeMax();
			i++;
		}
		for(; i>=0; i--)
			arr.insert(sorted[i]);

		arr.display();
		System.out.println(arr.getMax());
		System.out.println(arr.removeMax());
		
		int searchKey = 35;
		arr.find(searchKey);

		arr.delete(00);
		arr.delete(55);
		
		arr.display();
	
	}

}